package tp7.exo2.simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataIntegrationSystem {
    private List<IntegratedElement> elements = new ArrayList<IntegratedElement>();

    public void addElement(IntegratedElement element) throws InvalidDataException, DuplicateIdException {
        if (hasId(element.getId())) {
            throw new DuplicateIdException("ID already exists: " + element.getId());
        }
        element.validate();
        elements.add(element);
    }

    public void displayAll() {
        if (elements.isEmpty()) {
            System.out.println("No elements found.");
            return;
        }
        for (IntegratedElement element : elements) {
            System.out.println("  " + element.display());
        }
    }

    public void saveToText(String file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (IntegratedElement element : elements) {
                writer.write(element.toTextLine());
                writer.newLine();
            }
        }
    }

    public void loadFromText(String file) throws IOException {
        List<IntegratedElement> loaded = new ArrayList<IntegratedElement>();
        Set<String> ids = new HashSet<String>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                IntegratedElement e = parseLine(line);
                if (ids.contains(e.getId())) {
                    throw new IOException("Duplicate ID in text file: " + e.getId());
                }
                ids.add(e.getId());
                loaded.add(e);
            }
        }

        elements = loaded;
    }

    public void saveToBinary(String file) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
            out.writeInt(elements.size());
            for (IntegratedElement e : elements) {
                if (e instanceof Employee) {
                    Employee x = (Employee) e;
                    out.writeUTF("EMPLOYEE");
                    out.writeUTF(x.getId());
                    out.writeUTF(x.getName());
                    out.writeDouble(x.getSalary());
                    out.writeUTF(x.getDepartment());
                } else if (e instanceof Product) {
                    Product x = (Product) e;
                    out.writeUTF("PRODUCT");
                    out.writeUTF(x.getId());
                    out.writeUTF(x.getName());
                    out.writeDouble(x.getPrice());
                    out.writeInt(x.getStock());
                } else if (e instanceof Client) {
                    Client x = (Client) e;
                    out.writeUTF("CLIENT");
                    out.writeUTF(x.getId());
                    out.writeUTF(x.getName());
                    out.writeUTF(x.getEmail());
                    out.writeInt(x.getLoyaltyPoints());
                }
            }
        }
    }

    public void loadFromBinary(String file) throws IOException {
        List<IntegratedElement> loaded = new ArrayList<IntegratedElement>();
        Set<String> ids = new HashSet<String>();

        try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            int size = in.readInt();
            for (int i = 0; i < size; i++) {
                String type = in.readUTF();
                IntegratedElement e;

                if ("EMPLOYEE".equals(type)) {
                    e = new Employee(in.readUTF(), in.readUTF(), in.readDouble(), in.readUTF());
                } else if ("PRODUCT".equals(type)) {
                    e = new Product(in.readUTF(), in.readUTF(), in.readDouble(), in.readInt());
                } else if ("CLIENT".equals(type)) {
                    e = new Client(in.readUTF(), in.readUTF(), in.readUTF(), in.readInt());
                } else {
                    throw new IOException("Unknown type in binary file: " + type);
                }

                try {
                    e.validate();
                } catch (InvalidDataException ex) {
                    throw new IOException("Invalid data in binary file: " + ex.getMessage(), ex);
                }

                if (ids.contains(e.getId())) {
                    throw new IOException("Duplicate ID in binary file: " + e.getId());
                }
                ids.add(e.getId());
                loaded.add(e);
            }
        }

        elements = loaded;
    }

    public void saveToObject(String file) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(elements);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromObject(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Object data = in.readObject();
            if (!(data instanceof List<?>)) {
                throw new IOException("Object file format is invalid.");
            }
            List<IntegratedElement> loaded = (List<IntegratedElement>) data;
            Set<String> ids = new HashSet<String>();
            for (IntegratedElement e : loaded) {
                try {
                    e.validate();
                } catch (InvalidDataException ex) {
                    throw new IOException("Invalid object data: " + ex.getMessage(), ex);
                }
                if (ids.contains(e.getId())) {
                    throw new IOException("Duplicate ID in object file: " + e.getId());
                }
                ids.add(e.getId());
            }
            elements = loaded;
        }
    }

    private boolean hasId(String id) {
        for (IntegratedElement e : elements) {
            if (e.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private IntegratedElement parseLine(String line) throws IOException {
        String[] p = line.split(";");
        if (p.length < 5) {
            throw new IOException("Invalid text line: " + line);
        }

        try {
            if ("EMPLOYEE".equals(p[0])) {
                Employee e = new Employee(p[1], p[2], Double.parseDouble(p[3]), p[4]);
                e.validate();
                return e;
            }
            if ("PRODUCT".equals(p[0])) {
                Product e = new Product(p[1], p[2], Double.parseDouble(p[3]), Integer.parseInt(p[4]));
                e.validate();
                return e;
            }
            if ("CLIENT".equals(p[0])) {
                Client e = new Client(p[1], p[2], p[3], Integer.parseInt(p[4]));
                e.validate();
                return e;
            }
        } catch (NumberFormatException ex) {
            throw new IOException("Invalid number in line: " + line, ex);
        } catch (InvalidDataException ex) {
            throw new IOException("Invalid line data: " + ex.getMessage(), ex);
        }

        throw new IOException("Unknown type: " + p[0]);
    }
}
