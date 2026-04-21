package tp4.exo5.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Individual> people = new ArrayList<Individual>();
    static List<Course> courses = new ArrayList<Course>();

    public static void main(String[] args) {
        people.add(new Individual("Ali Mansour", "IND001", 25));
        people.add(new Individual("Sara Boudia", "IND002", 22));
        people.add(new Teacher("Dr. Karim Hadj", "TCH001", 45, "Mathematics", 18));
        people.add(new Teacher("Dr. Lina Meziane", "TCH002", 38, "Physics", 12));
        people.add(new SeniorTeacher("Prof. Yacine Bey", "TCH003", 52, "Algorithms", 25, "Head of Department"));
        people.add(new SeniorTeacher("Prof. Rima Ould", "TCH004", 48, "Networking", 20, "Program Coordinator"));

        courses.add(new Course("Data Structures", "CS201", 40));
        courses.add(new Course("Operating Systems", "CS301", 36));
        courses.add(new OnlineCourse("Machine Learning", "CS401", 30, "Moodle", 90));
        courses.add(new OnlineCourse("Web Development", "CS402", 24, "Google Classroom", 60));

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1:
                    showPeople();
                    break;
                case 2:
                    showCourses();
                    break;
                case 3:
                    performAllActions();
                    break;
                case 4:
                    startAllCourses();
                    break;
                case 5:
                    editPerson();
                    break;
                case 6:
                    editCourse();
                    break;
                case 0:
                    System.out.println("\nGoodbye!");
                    running = false;

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n=== Training Center Manager ===");
        System.out.println("1. Show all people");
        System.out.println("2. Show all courses");
        System.out.println("3. Perform actions (polymorphism demo)");
        System.out.println("4. Start all courses (polymorphism demo)");
        System.out.println("5. Edit a person");
        System.out.println("6. Edit a course");
        System.out.println("0. Exit");
    }

    static void showPeople() {
        System.out.println("\n--- People (" + people.size() + ") ---");
        for (int i = 0; i < people.size(); i++) {
            System.out.println("  [" + i + "] " + people.get(i));
        }
    }

    static void showCourses() {
        System.out.println("\n--- Courses (" + courses.size() + ") ---");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("  [" + i + "] " + courses.get(i));
        }
    }

    static void performAllActions() {
        System.out.println("\n--- Calling performAction() on every person ---");
        for (Individual p : people) {
            System.out.print("  ");
            p.performAction();
        }
    }

    static void startAllCourses() {
        System.out.println("\n--- Calling startCourse() on every course ---");
        for (Course c : courses) {
            System.out.print("  ");
            c.startCourse();
        }
    }

    static void editPerson() {
        showPeople();
        int idx = readInt("\nIndex of person to edit (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= people.size()) {
            System.out.println("  [!] Out of range.");
            return;
        }
        Individual p = people.get(idx);
        System.out.println("\nEditing: " + p);
        System.out.println("  1. Name (" + p.getName() + ")");
        System.out.println("  2. ID   (" + p.getId() + ")");
        System.out.println("  3. Age  (" + p.getAge() + ")");

        if (p instanceof Teacher) {
            Teacher t = (Teacher) p;
            System.out.println("  4. Subject    (" + t.getSubject() + ")");
            System.out.println("  5. Experience (" + t.getExperience() + " yrs)");
        }
        if (p instanceof SeniorTeacher) {
            SeniorTeacher s = (SeniorTeacher) p;
            System.out.println("  6. Responsibility Level (" + s.getResponsibilityLevel() + ")");
        }

        int field = readInt("  Field: ");
        switch (field) {
            case 1:
                p.setName(readString("  New name: "));
                break;
            case 2:
                p.setId(readString("  New ID: "));
                break;
            case 3:
                p.setAge(readInt("  New age: "));
                break;
            case 4:
                if (p instanceof Teacher) {
                    ((Teacher) p).setSubject(readString("  New subject: "));
                } else {
                    System.out.println("  [!] Not a teacher.");
                    return;
                }
                break;
            case 5:
                if (p instanceof Teacher) {
                    ((Teacher) p).setExperience(readInt("  New experience: "));
                } else {
                    System.out.println("  [!] Not a teacher.");
                    return;
                }
                break;
            case 6:
                if (p instanceof SeniorTeacher) {
                    ((SeniorTeacher) p).setResponsibilityLevel(readString("  New level: "));
                } else {
                    System.out.println("  [!] Not a senior teacher.");
                    return;
                }
                break;
            default:
                System.out.println("  [!] Invalid field.");
                return;
        }
        System.out.println("  Updated: " + p);
    }

    static void editCourse() {
        showCourses();
        int idx = readInt("\nIndex of course to edit (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= courses.size()) {
            System.out.println("  [!] Out of range.");
            return;
        }
        Course c = courses.get(idx);
        System.out.println("\nEditing: " + c);
        System.out.println("  1. Title    (" + c.getTitle() + ")");
        System.out.println("  2. Code     (" + c.getCode() + ")");
        System.out.println("  3. Duration (" + c.getDuration() + "h)");

        if (c instanceof OnlineCourse) {
            OnlineCourse oc = (OnlineCourse) c;
            System.out.println("  4. Platform       (" + oc.getPlatform() + ")");
            System.out.println("  5. Access Duration (" + oc.getAccessDuration() + " days)");
        }

        int field = readInt("  Field: ");
        switch (field) {
            case 1:
                c.setTitle(readString("  New title: "));
                break;
            case 2:
                c.setCode(readString("  New code: "));
                break;
            case 3:
                c.setDuration(readInt("  New duration (h): "));
                break;
            case 4:
                if (c instanceof OnlineCourse) {
                    ((OnlineCourse) c).setPlatform(readString("  New platform: "));
                } else {
                    System.out.println("  [!] Not an online course.");
                    return;
                }
                break;
            case 5:
                if (c instanceof OnlineCourse) {
                    ((OnlineCourse) c).setAccessDuration(readInt("  New access (days): "));
                } else {
                    System.out.println("  [!] Not an online course.");
                    return;
                }
                break;
            default:
                System.out.println("  [!] Invalid field.");
                return;
        }
        System.out.println("  Updated: " + c);
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Enter a valid integer.");
            }
        }
    }

    static String readString(String prompt) {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        while (s.isEmpty()) {
            System.out.println("  [!] Cannot be empty.");
            System.out.print(prompt);
            s = scanner.nextLine().trim();
        }
        return s;
    }
}
