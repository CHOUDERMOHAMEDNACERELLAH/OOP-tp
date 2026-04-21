package tp4.exo4.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Shape> shapes = new ArrayList<Shape>();

    public static void main(String[] args) {
        shapes.add(new Circle(5));
        shapes.add(new Circle(3.5));
        shapes.add(new Rectangle(4, 7));
        shapes.add(new Rectangle(10, 2));
        shapes.add(new Triangle(6, 3));
        shapes.add(new Triangle(8, 5));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Surface Calculator ===");
            System.out.println("1. Show all shapes");
            System.out.println("2. Add a shape");
            System.out.println("3. Edit a shape");
            System.out.println("0. Exit");
            int choice = readInt("Choice: ");

            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    addShape();
                    break;
                case 3:
                    editShape();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Invalid.");
            }
        }
        scanner.close();
    }

    static void showAll() {
        System.out.println("\n--- Shapes ---");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println("  [" + i + "] " + shapes.get(i));
        }
    }

    static void addShape() {
        System.out.println("  1. Circle");
        System.out.println("  2. Rectangle");
        System.out.println("  3. Triangle");
        int type = readInt("Type: ");
        switch (type) {
            case 1:
                double r = readDouble("Radius: ");
                shapes.add(new Circle(r));
                break;
            case 2:
                double w = readDouble("Width: ");
                double h = readDouble("Height: ");
                shapes.add(new Rectangle(w, h));
                break;
            case 3:
                double b = readDouble("Base: ");
                double ht = readDouble("Height: ");
                shapes.add(new Triangle(b, ht));
                break;
            default:
                System.out.println("[!] Invalid.");
                return;
        }
        System.out.println("Added: " + shapes.get(shapes.size() - 1));
    }

    static void editShape() {
        showAll();
        int idx = readInt("Index to edit (-1 to cancel): ");
        if (idx == -1)
            return;
        if (idx < 0 || idx >= shapes.size()) {
            System.out.println("[!] Invalid.");
            return;
        }

        Shape s = shapes.get(idx);
        System.out.println("Editing: " + s);

        if (s instanceof Circle) {
            Circle c = (Circle) s;
            System.out.println("  Current radius: " + c.getRadius());
            c.setRadius(readDouble("New radius: "));
        } else if (s instanceof Rectangle) {
            Rectangle rec = (Rectangle) s;
            System.out.println("  1. Width (" + rec.getWidth() + ")");
            System.out.println("  2. Height (" + rec.getHeight() + ")");
            int f = readInt("Field: ");
            if (f == 1)
                rec.setWidth(readDouble("New width: "));
            else if (f == 2)
                rec.setHeight(readDouble("New height: "));
            else {
                System.out.println("[!] Invalid.");
                return;
            }
        } else if (s instanceof Triangle) {
            Triangle tri = (Triangle) s;
            System.out.println("  1. Base (" + tri.getBase() + ")");
            System.out.println("  2. Height (" + tri.getHeight() + ")");
            int f = readInt("Field: ");
            if (f == 1)
                tri.setBase(readDouble("New base: "));
            else if (f == 2)
                tri.setHeight(readDouble("New height: "));
            else {
                System.out.println("[!] Invalid.");
                return;
            }
        }
        System.out.println("Updated: " + s);
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

    static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[!] Enter a valid number.");
            }
        }
    }
}
