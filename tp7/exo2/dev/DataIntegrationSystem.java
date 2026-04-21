package tp7.exo2.dev;

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

    private List<IntegratedElement> elements;

    public DataIntegrationSystem() {
        this.elements = new ArrayList<IntegratedElement>();
    }

    public void addElement(IntegratedElement element) throws InvalidDataException, DuplicateIdException {
        if (containsId(element.getId())) {
            throw new DuplicateIdException("Duplicate ID: " + element.getId());
        }
        element.validate();
        elements.add(element);
    }

    public void displayAll() {
        if (elements.isEmpty()) {
            System.out.println("No data available.");
            return;
        }
        System.out.println("\n--- Integrated Elements (" + elements.size() + ") ---");
        for (IntegratedElement element : elements) {
            System.out.println("  " + element.display());
        }
    }

    public void saveToText(String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (IntegratedElement element : elements) {
                writer.write(element.toTextLine());
                writer.newLine();
            }
        }
    }

    public void loadFromText(String path) throws IOException {
        List<IntegratedElement> loaded = new ArrayList<IntegratedElement>();
        Set<String> ids = new HashSet<String>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                IntegratedElement element = parseTextLine(line);
                if (ids.contains(element.getId())) {
                    throw new IOException("Duplicate ID found in text file: " + element.getId());
                }
                ids.add(element.getId());
                loaded.add(element);
            }
        }

        elements = loaded;
    }

    public void saveToBinary(String path) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(path))) {
            out.writeInt(elements.size());
            for (IntegratedElement element : elements) {
                if (element instanceof Employee) {
                    Employee e = (Employee) element;
                    out.writeUTF("EMPLOYEE");
                    out.writeUTF(e.getId());
                    out.writeUTF(e.getName());
                    out.writeDouble(e.getSalary());
                    out.writeUTF(e.getDepartment());
                } else if (element instanceof Product) {
                    Product p = (Product) element;
                    out.writeUTF("PRODUCT");
                    out.writeUTF(p.getId());
                    out.writeUTF(p.getName());
                    out.writeDouble(p.getPrice());
                    out.writeInt(p.getStock());
                } else if (element instanceof Client) {
                    Client c = (Client) element;
                    out.writeUTF("CLIENT");
                    out.writeUTF(c.getId());
                    out.writeUTF(c.getName());
                    out.writeUTF(c.getEmail());
                    out.writeInt(c.getLoyaltyPoints());
                }
            }
        }
    }

    public void loadFromBinary(String path) throws IOException {
        List<IntegratedElement> loaded = new ArrayList<IntegratedElement>();
        Set<String> ids = new HashSet<String>();

        try (DataInputStream in = new DataInputStream(new FileInputStream(path))) {
            int size = in.readInt();
            for (int i = 0; i < size; i++) {
                String type = in.readUTF();
                IntegratedElement element;

                if ("EMPLOYEE".equals(type)) {
                    element = new Employee(in.readUTF(), in.readUTF(), in.readDouble(), in.readUTF());
                } else if ("PRODUCT".equals(type)) {
                    element = new Product(in.readUTF(), in.readUTF(), in.readDouble(), in.readInt());
                } else if ("CLIENT".equals(type)) {
                    element = new Client(in.readUTF(), in.readUTF(), in.readUTF(), in.readInt());
                } else {
                    throw new IOException("Unknown type in binary file: " + type);
                }

                try {
                    element.validate();
                } catch (InvalidDataException e) {
                    throw new IOException("Invalid data in binary file: " + e.getMessage(), e);
                }

                if (ids.contains(element.getId())) {
                    throw new IOException("Duplicate ID in binary file: " + element.getId());
                }
                ids.add(element.getId());
                loaded.add(element);
            }
        }

        elements = loaded;
    }

    public void saveToObject(String path) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(elements);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromObject(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            Object data = in.readObject();
            if (!(data instanceof List<?>)) {
                throw new IOException("Object file does not contain a list.");
            }

            List<IntegratedElement> loaded = (List<IntegratedElement>) data;
            Set<String> ids = new HashSet<String>();
            for (IntegratedElement element : loaded) {
                try {
                    element.validate();
                } catch (InvalidDataException e) {
                    throw new IOException("Invalid object data: " + e.getMessage(), e);
                }
                if (ids.contains(element.getId())) {
                    throw new IOException("Duplicate ID in object file: " + element.getId());
                }
                ids.add(element.getId());
            }
            elements = loaded;
        }
    }

    public List<IntegratedElement> getElements() {
        return elements;
    }

    private boolean containsId(String id) {
        for (IntegratedElement element : elements) {
            if (element.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private IntegratedElement parseTextLine(String line) throws IOException {
        String[] parts = line.split(";");
        if (parts.length < 5) {
            throw new IOException("Invalid text line format: " + line);
        }

        String type = parts[0].trim();
        try {
            if ("EMPLOYEE".equals(type)) {
                Employee e = new Employee(parts[1], parts[2], Double.parseDouble(parts[3]), parts[4]);
                e.validate();
                return e;
            }
            if ("PRODUCT".equals(type)) {
                Product p = new Product(parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]));
                p.validate();
                return p;
            }
            if ("CLIENT".equals(type)) {
                Client c = new Client(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                c.validate();
                return c;
            }
            throw new IOException("Unknown type in text file: " + type);
        } catch (NumberFormatException e) {
            throw new IOException("Invalid number format in line: " + line, e);
        } catch (InvalidDataException e) {
            throw new IOException("Invalid record in text file: " + e.getMessage(), e);
        }
    }
}
