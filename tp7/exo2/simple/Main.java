package tp7.exo2.simple;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String TXT = "tp7_exo2_simple.txt";
    private static final String BIN = "tp7_exo2_simple.bin";
    private static final String OBJ = "tp7_exo2_simple.obj";

    static Scanner scanner = new Scanner(System.in);
    static DataIntegrationSystem system = new DataIntegrationSystem();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1:
                    addElement();
                    break;
                case 2:
                    system.displayAll();
                    break;
                case 3:
                    saveText();
                    break;
                case 4:
                    loadText();
                    break;
                case 5:
                    saveBinary();
                    break;
                case 6:
                    loadBinary();
                    break;
                case 7:
                    saveObject();
                    break;
                case 8:
                    loadObject();
                    break;
                case 0:
                    System.out.println("Exit.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n=== Data Integration (SIMPLE) ===");
        System.out.println("1. Add element");
        System.out.println("2. Display all");
        System.out.println("3. Save text");
        System.out.println("4. Load text");
        System.out.println("5. Save binary");
        System.out.println("6. Load binary");
        System.out.println("7. Save object");
        System.out.println("8. Load object");
        System.out.println("0. Exit");
    }

    static void addElement() {
        System.out.println("1.Employee  2.Product  3.Client");
        int type = readInt("Type: ");

        try {
            String id = readString("ID: ");
            String name = readString("Name: ");
            IntegratedElement e;

            if (type == 1) {
                double salary = readDouble("Salary: ");
                String department = readString("Department: ");
                e = new Employee(id, name, salary, department);
            } else if (type == 2) {
                double price = readDouble("Price: ");
                int stock = readInt("Stock: ");
                e = new Product(id, name, price, stock);
            } else if (type == 3) {
                String email = readString("Email: ");
                int points = readInt("Points: ");
                e = new Client(id, name, email, points);
            } else {
                System.out.println("Unknown type.");
                return;
            }

            system.addElement(e);
            System.out.println("Element added.");
        } catch (InvalidDataException ex) {
            System.out.println("Validation error: " + ex.getMessage());
        } catch (DuplicateIdException ex) {
            System.out.println("Duplicate ID: " + ex.getMessage());
        }
    }

    static void saveText() {
        try {
            system.saveToText(TXT);
            System.out.println("Saved: " + TXT);
        } catch (IOException ex) {
            System.out.println("Text save error: " + ex.getMessage());
        }
    }

    static void loadText() {
        try {
            system.loadFromText(TXT);
            System.out.println("Loaded: " + TXT);
        } catch (IOException ex) {
            System.out.println("Text load error: " + ex.getMessage());
        }
    }

    static void saveBinary() {
        try {
            system.saveToBinary(BIN);
            System.out.println("Saved: " + BIN);
        } catch (IOException ex) {
            System.out.println("Binary save error: " + ex.getMessage());
        }
    }

    static void loadBinary() {
        try {
            system.loadFromBinary(BIN);
            System.out.println("Loaded: " + BIN);
        } catch (IOException ex) {
            System.out.println("Binary load error: " + ex.getMessage());
        }
    }

    static void saveObject() {
        try {
            system.saveToObject(OBJ);
            System.out.println("Saved: " + OBJ);
        } catch (IOException ex) {
            System.out.println("Object save error: " + ex.getMessage());
        }
    }

    static void loadObject() {
        try {
            system.loadFromObject(OBJ);
            System.out.println("Loaded: " + OBJ);
        } catch (IOException ex) {
            System.out.println("Object load error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Class error while reading object file.");
        }
    }

    static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
