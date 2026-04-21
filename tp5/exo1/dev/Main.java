package tp5.exo1.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Vehicle> fleet = new ArrayList<Vehicle>();
    static int nextId = 5;

    public static void main(String[] args) {
        fleet.add(new PassengerVehicle("V001", "Mercedes", "Sprinter", 2022, 20));
        fleet.add(new PassengerVehicle("V002", "Toyota", "Coaster", 2021, 30));
        fleet.add(new CargoVehicle("V003", "Volvo", "FH16", 2023, 25.0));
        fleet.add(new CargoVehicle("V004", "Scania", "R500", 2020, 18.5));

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    addVehicle();
                    break;
                case 3:
                    editVehicle();
                    break;
                case 4:
                    operateAll();
                    break;
                case 0:
                    System.out.println("\nGoodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Invalid choice.");
            }
        }
        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n=== Fleet Manager ===");
        System.out.println("1. Show all vehicles");
        System.out.println("2. Add a vehicle");
        System.out.println("3. Edit a vehicle");
        System.out.println("4. Operate all (polymorphism demo)");
        System.out.println("0. Exit");
    }

    static void showAll() {
        if (fleet.isEmpty()) {
            System.out.println("  No vehicles in fleet.");
            return;
        }
        System.out.println("\n--- Fleet (" + fleet.size() + ") ---");
        for (int i = 0; i < fleet.size(); i++) {
            System.out.println("  [" + i + "] " + fleet.get(i));
        }
    }

    static void addVehicle() {
        System.out.println("  1. Passenger Vehicle");
        System.out.println("  2. Cargo Vehicle");
        int type = readInt("Type: ");
        if (type != 1 && type != 2) {
            System.out.println("[!] Invalid type.");
            return;
        }
        String id = "V00" + nextId++;
        String brand = readString("Brand: ");
        String model = readString("Model: ");
        int year = readInt("Year: ");
        if (type == 1) {
            int seats = readInt("Seat capacity: ");
            fleet.add(new PassengerVehicle(id, brand, model, year, seats));
        } else {
            double load = readDouble("Max load (tons): ");
            fleet.add(new CargoVehicle(id, brand, model, year, load));
        }
        System.out.println("Added: " + fleet.get(fleet.size() - 1));
    }

    static void editVehicle() {
        showAll();
        int idx = readInt("Index to edit (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= fleet.size()) {
            System.out.println("[!] Invalid index.");
            return;
        }
        Vehicle v = fleet.get(idx);
        System.out.println("Editing: " + v);
        System.out.println("  1. Brand (" + v.getBrand() + ")");
        System.out.println("  2. Model (" + v.getModel() + ")");
        System.out.println("  3. Year (" + v.getYear() + ")");
        if (v instanceof PassengerVehicle) {
            System.out.println("  4. Seat capacity (" + ((PassengerVehicle) v).getSeatCapacity() + ")");
        } else if (v instanceof CargoVehicle) {
            System.out.println("  4. Max load tons (" + ((CargoVehicle) v).getMaxLoadTons() + ")");
        }
        int field = readInt("Field: ");
        switch (field) {
            case 1:
                v.setBrand(readString("New brand: "));
                break;
            case 2:
                v.setModel(readString("New model: "));
                break;
            case 3:
                v.setYear(readInt("New year: "));
                break;
            case 4:
                if (v instanceof PassengerVehicle)
                    ((PassengerVehicle) v).setSeatCapacity(readInt("New seat capacity: "));
                else if (v instanceof CargoVehicle)
                    ((CargoVehicle) v).setMaxLoadTons(readDouble("New max load (tons): "));
                break;
            default:
                System.out.println("[!] Invalid field.");
                return;
        }
        System.out.println("Updated: " + v);
    }

    static void operateAll() {
        System.out.println("\n--- Operating All Vehicles ---");
        for (Vehicle v : fleet) {
            v.operate();
        }
    }

    static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print(prompt);
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print(prompt);
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }

    static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
