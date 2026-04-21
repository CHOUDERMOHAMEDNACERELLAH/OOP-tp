package tp7.exo2.dev;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String TEXT_FILE = "tp7_exo2_dev.txt";
    private static final String BINARY_FILE = "tp7_exo2_dev.bin";
    private static final String OBJECT_FILE = "tp7_exo2_dev.obj";

    static Scanner scanner = new Scanner(System.in);
    static DataIntegrationSystem system = new DataIntegrationSystem();

    public static void main(String[] args) {
        System.out.println("=== Multi-Source Data Integration System (DEV) ===");

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
                    System.out.println("Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Invalid choice.");
            }
        }

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add new element");
        System.out.println("2. Display all elements");
        System.out.println("3. Save to text file");
        System.out.println("4. Load from text file");
        System.out.println("5. Save to binary file");
        System.out.println("6. Load from binary file");
        System.out.println("7. Save to object file");
        System.out.println("8. Load from object file");
        System.out.println("0. Exit");
    }

    static void addElement() {
        System.out.println("\nElement type:");
        System.out.println("1. Employee");
        System.out.println("2. Product");
        System.out.println("3. Client");
        int type = readInt("Type: ");

        try {
            String id = readString("ID: ");
            String name = readString("Name: ");
            IntegratedElement element;

            switch (type) {
                case 1:
                    double salary = readDouble("Salary: ");
                    String department = readString("Department: ");
                    element = new Employee(id, name, salary, department);
                    break;
                case 2:
                    double price = readDouble("Price: ");
                    int stock = readInt("Stock: ");
                    element = new Product(id, name, price, stock);
                    break;
                case 3:
                    String email = readString("Email: ");
                    int points = readInt("Loyalty points: ");
                    element = new Client(id, name, email, points);
                    break;
                default:
                    System.out.println("[!] Unknown type.");
                    return;
            }

            system.addElement(element);
            System.out.println("Added successfully.");

        } catch (InvalidDataException e) {
            System.out.println("[Validation Error] " + e.getMessage());
        } catch (DuplicateIdException e) {
            System.out.println("[Duplicate ID] " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("[Input Error] " + e.getMessage());
        }
    }

    static void saveText() {
        try {
            system.saveToText(TEXT_FILE);
            System.out.println("Saved to text file: " + TEXT_FILE);
        } catch (IOException e) {
            System.out.println("[File Error] Could not save text file: " + e.getMessage());
        }
    }

    static void loadText() {
        try {
            system.loadFromText(TEXT_FILE);
            System.out.println("Loaded from text file: " + TEXT_FILE);
        } catch (IOException e) {
            System.out.println("[File Error] Could not load text file: " + e.getMessage());
        }
    }

    static void saveBinary() {
        try {
            system.saveToBinary(BINARY_FILE);
            System.out.println("Saved to binary file: " + BINARY_FILE);
        } catch (IOException e) {
            System.out.println("[File Error] Could not save binary file: " + e.getMessage());
        }
    }

    static void loadBinary() {
        try {
            system.loadFromBinary(BINARY_FILE);
            System.out.println("Loaded from binary file: " + BINARY_FILE);
        } catch (IOException e) {
            System.out.println("[File Error] Could not load binary file: " + e.getMessage());
        }
    }

    static void saveObject() {
        try {
            system.saveToObject(OBJECT_FILE);
            System.out.println("Saved to object file: " + OBJECT_FILE);
        } catch (IOException e) {
            System.out.println("[File Error] Could not save object file: " + e.getMessage());
        }
    }

    static void loadObject() {
        try {
            system.loadFromObject(OBJECT_FILE);
            System.out.println("Loaded from object file: " + OBJECT_FILE);
        } catch (IOException e) {
            System.out.println("[File Error] Could not load object file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Object Error] Class mismatch while reading object file.");
        }
    }

    static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
