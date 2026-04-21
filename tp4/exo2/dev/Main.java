package tp4.exo2.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<GameCharacter> characters = new ArrayList<GameCharacter>();

    public static void main(String[] args) {
        characters.add(new GameCharacter("Goblin", 80, 15));
        characters.add(new GameCharacter("Orc", 100, 20));
        characters.add(new Warrior("Knight", 120, 25, 30, 10));
        characters.add(new Warrior("Berserker", 90, 35, 10, 25));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Mini Battle Arena ===");
            System.out.println("1. Show all characters");
            System.out.println("2. Attack (character vs character)");
            System.out.println("3. Special Attack (warrior only)");
            System.out.println("4. Defend (warrior only)");
            System.out.println("5. Edit a character");
            System.out.println("0. Exit");
            int choice = readInt("Choice: ");

            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    attack();
                    break;
                case 3:
                    specialAttack();
                    break;
                case 4:
                    defend();
                    break;
                case 5:
                    edit();
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

    static void showAll() {
        System.out.println("\n--- Characters ---");
        for (int i = 0; i < characters.size(); i++) {
            System.out.println("  [" + i + "] " + characters.get(i));
        }
    }

    static void attack() {
        showAll();
        int a = readInt("Attacker index: ");
        int b = readInt("Target index: ");
        if (!valid(a) || !valid(b) || a == b) {
            System.out.println("[!] Invalid indices.");
            return;
        }
        GameCharacter attacker = characters.get(a);
        GameCharacter target = characters.get(b);
        int damage = attacker.getPower();
        int newHealth = target.getHealth() - damage;
        target.setHealth(newHealth < 0 ? 0 : newHealth);
        System.out.println(attacker.getName() + " attacks " + target.getName() + " for " + damage + " damage!");
        System.out.println(target);
    }

    static void specialAttack() {
        showAll();
        int a = readInt("Warrior index: ");
        int b = readInt("Target index: ");
        if (!valid(a) || !valid(b) || a == b) {
            System.out.println("[!] Invalid indices.");
            return;
        }
        if (!(characters.get(a) instanceof Warrior)) {
            System.out.println("[!] Character at index " + a + " is not a Warrior.");
            return;
        }
        Warrior w = (Warrior) characters.get(a);
        w.specialAttack(characters.get(b));
        System.out.println(characters.get(b));
    }

    static void defend() {
        showAll();
        int a = readInt("Warrior index: ");
        if (!valid(a)) {
            System.out.println("[!] Invalid index.");
            return;
        }
        if (!(characters.get(a) instanceof Warrior)) {
            System.out.println("[!] Character at index " + a + " is not a Warrior.");
            return;
        }
        ((Warrior) characters.get(a)).defend();
    }

    static void edit() {
        showAll();
        int idx = readInt("Index to edit (-1 to cancel): ");
        if (idx == -1)
            return;
        if (!valid(idx)) {
            System.out.println("[!] Invalid index.");
            return;
        }
        GameCharacter c = characters.get(idx);
        System.out.println("Editing: " + c);
        System.out.println("  1. Name (" + c.getName() + ")");
        System.out.println("  2. Health (" + c.getHealth() + ")");
        System.out.println("  3. Power (" + c.getPower() + ")");
        if (c instanceof Warrior) {
            System.out.println("  4. Armor (" + ((Warrior) c).getArmor() + ")");
            System.out.println("  5. Rage Level (" + ((Warrior) c).getRageLevel() + ")");
        }
        int field = readInt("Field: ");
        switch (field) {
            case 1:
                c.setName(readString("New name: "));
                break;
            case 2:
                c.setHealth(readInt("New health: "));
                break;
            case 3:
                c.setPower(readInt("New power: "));
                break;
            case 4:
                if (c instanceof Warrior) {
                    ((Warrior) c).setArmor(readInt("New armor: "));
                    break;
                }
                System.out.println("[!] Invalid field.");
                return;
            case 5:
                if (c instanceof Warrior) {
                    ((Warrior) c).setRageLevel(readInt("New rage: "));
                    break;
                }
                System.out.println("[!] Invalid field.");
                return;
            default:
                System.out.println("[!] Invalid field.");
                return;
        }
        System.out.println("Updated: " + c);
    }

    static boolean valid(int idx) {
        return idx >= 0 && idx < characters.size();
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
