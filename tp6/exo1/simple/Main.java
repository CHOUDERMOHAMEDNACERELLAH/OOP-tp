package tp6.exo1.simple;

public class Main {
    public static void main(String[] args) {

        // --- 1. Static nested class: no outer instance needed ---
        EscapeRoom.RoomConfig config = new EscapeRoom.RoomConfig("Hard", 60);
        System.out.println("Room config: " + config);

        // --- Create outer instance ---
        EscapeRoom room = new EscapeRoom("The Lost Temple", 4);
        System.out.println("Room: " + room);

        // --- 2. Inner class: must use outer instance to create ---
        EscapeRoom.Puzzle p1 = room.new Puzzle("Hidden Code", 100);
        EscapeRoom.Puzzle p2 = room.new Puzzle("Mirror Maze", 200);
        EscapeRoom.Puzzle p3 = room.new Puzzle("Locked Chest", 150);

        System.out.println("\n--- Puzzles ---");
        System.out.println("  " + p1);
        System.out.println("  " + p2);
        System.out.println("  " + p3);

        // --- 3. Local class: invoked inside applyRules() ---
        System.out.println("\n--- Applying Rules ---");
        room.applyRules("No hints allowed");
        room.applyRules("Team of 4 required");

        // --- Solve puzzles via inner class ---
        System.out.println("\n--- Solving Puzzles ---");
        p1.solve();
        p2.solve();
        p1.solve(); // already solved

        // --- 4. Anonymous class: alarm triggers once ---
        System.out.println("\n--- Trigger Alarm ---");
        room.triggerAlarm();

        System.out.println("\nFinal state: " + room);
    }
}
