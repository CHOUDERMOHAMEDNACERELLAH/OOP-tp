package tp6.exo1.dev;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static EscapeRoom room;

    public static void main(String[] args) {
        // --- Static nested class: configure before creating the room ---
        EscapeRoom.RoomConfig config = new EscapeRoom.RoomConfig("Hard", 60, 3);
        System.out.println("=== Escape Room Game ===");
        System.out.println("Loaded: " + config);

        room = new EscapeRoom("The Lost Temple", 4);

        // --- Inner class: add puzzles linked to the room ---
        EscapeRoom.Puzzle p1 = room.new Puzzle("Hidden Code", 100);
        EscapeRoom.Puzzle p2 = room.new Puzzle("Mirror Maze", 200);
        EscapeRoom.Puzzle p3 = room.new Puzzle("Locked Chest", 150);
        EscapeRoom.Puzzle p4 = room.new Puzzle("Ancient Cipher", 250);
        room.addPuzzle(p1);
        room.addPuzzle(p2);
        room.addPuzzle(p3);
        room.addPuzzle(p4);

        // --- Local class: apply session rules ---
        room.applyRules(new String[] { "No outside help", "Time limit enforced", "Hints cost 10 pts" });

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1:
                    showRoom();
                    break;
                case 2:
                    showPuzzles();
                    break;
                case 3:
                    solvePuzzle();
                    break;
                case 4:
                    useHint();
                    break;
                case 5:
                    // Anonymous class: one-time emergency alarm
                    room.triggerAlarm();
                    running = false;
                    break;
                case 0:
                    System.out.println("\nGame abandoned. Score: " + room.getTotalScore() + " pts");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Invalid choice.");
            }
            if (running && room.countSolved() == room.getPuzzles().size()) {
                System.out.println("\n*** Congratulations! All puzzles solved! ***");
                System.out.println("Final score: " + room.getTotalScore() + " pts");
                running = false;
            }
        }
        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n--- Game Menu ---");
        System.out.println("1. Room status");
        System.out.println("2. Show puzzles");
        System.out.println("3. Solve a puzzle");
        System.out.println("4. Use a hint");
        System.out.println("5. Trigger alarm (end game)");
        System.out.println("0. Quit");
    }

    static void showRoom() {
        System.out.println("\n  " + room);
    }

    static void showPuzzles() {
        System.out.println("\n--- Puzzles ---");
        for (int i = 0; i < room.getPuzzles().size(); i++) {
            System.out.println("  [" + i + "] " + room.getPuzzles().get(i));
        }
    }

    static void solvePuzzle() {
        showPuzzles();
        int idx = readInt("Puzzle index (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= room.getPuzzles().size()) {
            System.out.println("[!] Invalid index.");
            return;
        }
        room.getPuzzles().get(idx).solve();
    }

    static void useHint() {
        showPuzzles();
        int idx = readInt("Puzzle index (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= room.getPuzzles().size()) {
            System.out.println("[!] Invalid index.");
            return;
        }
        room.getPuzzles().get(idx).useHint();
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
