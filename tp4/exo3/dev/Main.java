package tp4.exo3.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Individual> people = new ArrayList<Individual>();
    static List<Item> items = new ArrayList<Item>();

    public static void main(String[] args) {
        people.add(new Individual("Ali Merad", "IND001", "ali@lib.dz"));
        people.add(new Individual("Nadia Farah", "IND002", "nadia@lib.dz"));
        people.add(new Staff("Sara Bel", "STF001", "sara@lib.dz", "Archives", 5));
        people.add(new Staff("Omar Zid", "STF002", "omar@lib.dz", "IT", 8));
        people.add(new SeniorStaff("Karim Hadj", "SNR001", "karim@lib.dz", "Management", 12, "High"));

        items.add(new Item("Java Programming", "BK001", 2023));
        items.add(new Item("Data Structures", "BK002", 2021));
        items.add(new SpecialItem("Ancient Manuscript", "SP001", 1850, "Historical", true));
        items.add(new SpecialItem("Research Journal", "SP002", 2024, "Academic", false));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Library System ===");
            System.out.println("1. Show all people");
            System.out.println("2. Show all items");
            System.out.println("3. Edit a person");
            System.out.println("4. Edit an item");
            System.out.println("5. Staff actions");
            System.out.println("6. Special item actions");
            System.out.println("0. Exit");
            int choice = readInt("Choice: ");

            switch (choice) {
                case 1:
                    showPeople();
                    break;
                case 2:
                    showItems();
                    break;
                case 3:
                    editPerson();
                    break;
                case 4:
                    editItem();
                    break;
                case 5:
                    staffActions();
                    break;
                case 6:
                    specialItemActions();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Invalid option.");
            }
        }
        scanner.close();
    }

    static void showPeople() {
        System.out.println("\n--- People ---");
        for (int i = 0; i < people.size(); i++) {
            System.out.println("  [" + i + "] " + people.get(i));
        }
    }

    static void showItems() {
        System.out.println("\n--- Items ---");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("  [" + i + "] " + items.get(i));
        }
    }

    static void editPerson() {
        showPeople();
        int idx = readInt("Index to edit (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= people.size()) {
            System.out.println("[!] Invalid index.");
            return;
        }

        Individual p = people.get(idx);
        System.out.println("Editing: " + p);
        System.out.println("  1. Name (" + p.getName() + ")");
        System.out.println("  2. ID (" + p.getId() + ")");
        System.out.println("  3. Email (" + p.getEmail() + ")");
        if (p instanceof Staff) {
            System.out.println("  4. Department (" + ((Staff) p).getDepartment() + ")");
            System.out.println("  5. Work Years (" + ((Staff) p).getWorkYears() + ")");
        }
        if (p instanceof SeniorStaff) {
            System.out.println("  6. Responsibility Level (" + ((SeniorStaff) p).getResponsibilityLevel() + ")");
        }
        int field = readInt("Field: ");
        switch (field) {
            case 1:
                p.setName(readString("New name: "));
                break;
            case 2:
                p.setId(readString("New ID: "));
                break;
            case 3:
                p.setEmail(readString("New email: "));
                break;
            case 4:
                if (p instanceof Staff) {
                    ((Staff) p).setDepartment(readString("New dept: "));
                    break;
                }
                System.out.println("[!] Invalid.");
                return;
            case 5:
                if (p instanceof Staff) {
                    ((Staff) p).setWorkYears(readInt("New years: "));
                    break;
                }
                System.out.println("[!] Invalid.");
                return;
            case 6:
                if (p instanceof SeniorStaff) {
                    ((SeniorStaff) p).setResponsibilityLevel(readString("New level: "));
                    break;
                }
                System.out.println("[!] Invalid.");
                return;
            default:
                System.out.println("[!] Invalid.");
                return;
        }
        System.out.println("Updated: " + p);
    }

    static void editItem() {
        showItems();
        int idx = readInt("Index to edit (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= items.size()) {
            System.out.println("[!] Invalid index.");
            return;
        }

        Item it = items.get(idx);
        System.out.println("Editing: " + it);
        System.out.println("  1. Title (" + it.getTitle() + ")");
        System.out.println("  2. Code (" + it.getCode() + ")");
        System.out.println("  3. Year (" + it.getYear() + ")");
        if (it instanceof SpecialItem) {
            System.out.println("  4. Category (" + ((SpecialItem) it).getCategory() + ")");
            System.out.println("  5. Restricted (" + ((SpecialItem) it).isRestricted() + ")");
        }
        int field = readInt("Field: ");
        switch (field) {
            case 1:
                it.setTitle(readString("New title: "));
                break;
            case 2:
                it.setCode(readString("New code: "));
                break;
            case 3:
                it.setYear(readInt("New year: "));
                break;
            case 4:
                if (it instanceof SpecialItem) {
                    ((SpecialItem) it).setCategory(readString("New category: "));
                    break;
                }
                System.out.println("[!] Invalid.");
                return;
            case 5:
                if (it instanceof SpecialItem) {
                    String r = readString("Restricted? (true/false): ");
                    ((SpecialItem) it).setRestricted(r.equalsIgnoreCase("true"));
                    break;
                }
                System.out.println("[!] Invalid.");
                return;
            default:
                System.out.println("[!] Invalid.");
                return;
        }
        System.out.println("Updated: " + it);
    }

    static void staffActions() {
        showPeople();
        int idx = readInt("Staff index: ");
        if (idx < 0 || idx >= people.size()) {
            System.out.println("[!] Invalid.");
            return;
        }
        if (!(people.get(idx) instanceof Staff)) {
            System.out.println("[!] Not a staff member.");
            return;
        }
        Staff s = (Staff) people.get(idx);
        System.out.println("  1. Perform duties");
        System.out.println("  2. Assist users");
        if (s instanceof SeniorStaff) {
            System.out.println("  3. Manage section");
        }
        int action = readInt("Action: ");
        switch (action) {
            case 1:
                s.performStaffDuties();
                break;
            case 2:
                s.assistUsers();
                break;
            case 3:
                if (s instanceof SeniorStaff) {
                    ((SeniorStaff) s).manageSection();
                    break;
                }
                System.out.println("[!] Invalid.");
                break;
            default:
                System.out.println("[!] Invalid.");
        }
    }

    static void specialItemActions() {
        showItems();
        int idx = readInt("Special item index: ");
        if (idx < 0 || idx >= items.size()) {
            System.out.println("[!] Invalid.");
            return;
        }
        if (!(items.get(idx) instanceof SpecialItem)) {
            System.out.println("[!] Not a special item.");
            return;
        }
        SpecialItem sp = (SpecialItem) items.get(idx);
        System.out.println("  1. Show reference");
        System.out.println("  2. Check access");
        int action = readInt("Action: ");
        switch (action) {
            case 1:
                sp.showReference();
                break;
            case 2:
                sp.checkAccess();
                break;
            default:
                System.out.println("[!] Invalid.");
        }
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[!] Enter a valid integer.");
            }
        }
    }

    static String readString(String prompt) {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        while (s.isEmpty()) {
            System.out.println("[!] Cannot be empty.");
            System.out.print(prompt);
            s = scanner.nextLine().trim();
        }
        return s;
    }
}
