package tp4.exo1.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice Martin", 28, "alice@ensta.dz"));
        persons.add(new Person("Omar Benali", 34, "omar@ensta.dz"));
        persons.add(new Person("Sarah Chouikh", 22, "sarah@ensta.dz"));

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Dr. Karim Hadj", 45, "karim@ensta.dz", "Mathematics", 18));
        teachers.add(new Teacher("Dr. Lina Meziane", 38, "lina@ensta.dz", "Physics", 12));
        teachers.add(new Teacher("Prof. Yacine Bey", 52, "yacine@ensta.dz", "Algorithms", 25));
        teachers.add(new Teacher("Dr. Rima Ould", 41, "rima@ensta.dz", "Networking", 9));

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Your choice: ");

            switch (choice) {
                case 1:
                    showAllPersons(persons);
                    break;
                case 2:
                    showAllTeachers(teachers);
                    break;
                case 3:
                    editPerson(persons);
                    break;
                case 4:
                    editTeacher(teachers);
                    break;
                case 0:
                    System.out.println("\nExiting. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("  [!] Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    static void printMainMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║      Training Center Manager         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Show all Persons                 ║");
        System.out.println("║  2. Show all Teachers                ║");
        System.out.println("║  3. Edit a Person                    ║");
        System.out.println("║  4. Edit a Teacher                   ║");
        System.out.println("║  0. Exit                             ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    static void showAllPersons(List<Person> persons) {
        System.out.println("\n── Persons (" + persons.size() + ") ──────────────────────────");
        for (int i = 0; i < persons.size(); i++) {
            System.out.println("  [" + i + "] " + persons.get(i));
        }
    }

    static void showAllTeachers(List<Teacher> teachers) {
        System.out.println("\n── Teachers (" + teachers.size() + ") ─────────────────────────");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println("  [" + i + "] " + teachers.get(i));
        }
    }

    static void editPerson(List<Person> persons) {
        showAllPersons(persons);
        int idx = readInt("\nEnter the index of the Person to edit (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= persons.size()) {
            System.out.println("  [!] Index out of range.");
            return;
        }

        Person p = persons.get(idx);
        System.out.println("\nEditing: " + p);
        System.out.println("  1. Name    (current: " + p.getName() + ")");
        System.out.println("  2. Age     (current: " + p.getAge() + ")");
        System.out.println("  3. Email   (current: " + p.getEmail() + ")");
        int field = readInt("  Choose field to edit: ");

        switch (field) {
            case 1:
                String name = readString("  New name: ");
                p.setName(name);
                break;
            case 2:
                int age = readInt("  New age: ");
                p.setAge(age);
                break;
            case 3:
                String email = readString("  New email: ");
                p.setEmail(email);
                break;
            default:
                System.out.println("  [!] Invalid field.");
                return;
        }

        System.out.println("  ✔ Updated: " + p);
    }

    static void editTeacher(List<Teacher> teachers) {
        showAllTeachers(teachers);
        int idx = readInt("\nEnter the index of the Teacher to edit (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= teachers.size()) {
            System.out.println("  [!] Index out of range.");
            return;
        }

        Teacher t = teachers.get(idx);
        System.out.println("\nEditing: " + t);
        System.out.println("  1. Name        (current: " + t.getName() + ")");
        System.out.println("  2. Age         (current: " + t.getAge() + ")");
        System.out.println("  3. Email       (current: " + t.getEmail() + ")");
        System.out.println("  4. Subject     (current: " + t.getSubject() + ")");
        System.out.println("  5. Experience  (current: " + t.getExperience() + " yrs)");
        int field = readInt("  Choose field to edit: ");

        switch (field) {
            case 1:
                String name = readString("  New name: ");
                t.setName(name);
                break;
            case 2:
                int age = readInt("  New age: ");
                t.setAge(age);
                break;
            case 3:
                String email = readString("  New email: ");
                t.setEmail(email);
                break;
            case 4:
                String subj = readString("  New subject: ");
                t.setSubject(subj);
                break;
            case 5:
                int exp = readInt("  New experience (yrs): ");
                t.setExperience(exp);
                break;
            default:
                System.out.println("  [!] Invalid field.");
                return;
        }

        System.out.println("  ✔ Updated: " + t);
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Please enter a valid integer.");
            }
        }
    }

    static String readString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println("  [!] Input cannot be empty.");
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        }
        return input;
    }
}
