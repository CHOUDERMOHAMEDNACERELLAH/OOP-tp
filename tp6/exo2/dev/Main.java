package tp6.exo2.dev;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static SmartCitySystem system;
    static SmartCitySystem.PowerUnit power;
    static SmartCitySystem.TrafficController traffic;
    static SmartCitySystem.CityDashboard dashboard;

    public static void main(String[] args) {
        system = new SmartCitySystem("NeoCity", 12);

        // Static nested class: no outer instance needed
        dashboard = new SmartCitySystem.CityDashboard(system.cityName);

        // Non-static inner classes: require outer instance
        power = system.new PowerUnit();
        traffic = system.new TrafficController();

        System.out.println("=== Smart City Control System ===");
        System.out.println("City: " + system);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1:
                    dashboard.showStatus();
                    break;
                case 2:
                    dashboard.showHelp();
                    break;
                case 3:
                    power.shutdown();
                    break;
                case 4:
                    power.restore();
                    break;
                case 5:
                    traffic.regulate();
                    break;
                case 6:
                    traffic.addLight();
                    break;
                case 7:
                    system.operateSystem();
                    break;
                case 8:
                    system.backupCommand.execute();
                    break;
                case 9:
                    System.out.println("  " + system);
                    break;
                case 0:
                    System.out.println("System offline. Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Invalid choice.");
            }
        }
        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n=== Control Panel ===");
        System.out.println("1.  Dashboard status");
        System.out.println("2.  Dashboard help");
        System.out.println("3.  Shutdown power");
        System.out.println("4.  Restore power");
        System.out.println("5.  Regulate traffic");
        System.out.println("6.  Add traffic light");
        System.out.println("7.  Run sensor sweep (local class + anonymous)");
        System.out.println("8.  Execute backup command (anonymous class)");
        System.out.println("9.  Show city summary");
        System.out.println("0.  Exit");
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
}
