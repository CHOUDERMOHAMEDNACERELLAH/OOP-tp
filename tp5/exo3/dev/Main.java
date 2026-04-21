package tp5.exo3.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Shape> shapes = new ArrayList<Shape>();

    public static void main(String[] args) {
        shapes.add(new Circle(5, "Red"));
        shapes.add(new Circle(3.5, "Blue"));
        shapes.add(new Rectangle(4, 7, "Green"));
        shapes.add(new Rectangle(10, 2, "Yellow"));
        shapes.add(new Triangle(3, 4, 5, "Purple"));
        shapes.add(new Triangle(6, 8, 10, "Orange"));

        boolean running = true;
        while (running) {
            printMenu();
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
                case 4:
                    showLargestArea();
                    break;
                case 5:
                    showLargestPerimeter();
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
        System.out.println("\n=== Shape Calculator ===");
        System.out.println("1. Show all shapes");
        System.out.println("2. Add a shape");
        System.out.println("3. Edit a shape");
        System.out.println("4. Show shape with largest area");
        System.out.println("5. Show shape with largest perimeter");
        System.out.println("0. Exit");
    }

    static void showAll() {
        if (shapes.isEmpty()) {
            System.out.println("  No shapes.");
            return;
        }
        System.out.println("\n--- Shapes (" + shapes.size() + ") ---");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println("  [" + i + "] " + shapes.get(i));
        }
    }

    static void addShape() {
        System.out.println("  1. Circle");
        System.out.println("  2. Rectangle");
        System.out.println("  3. Triangle");
        int type = readInt("Type: ");
        String color = readString("Color: ");
        switch (type) {
            case 1:
                double r = readDouble("Radius: ");
                shapes.add(new Circle(r, color));
                break;
            case 2:
                double w = readDouble("Width: ");
                double h = readDouble("Height: ");
                shapes.add(new Rectangle(w, h, color));
                break;
            case 3:
                double a = readDouble("Side A: ");
                double b = readDouble("Side B: ");
                double c = readDouble("Side C: ");
                shapes.add(new Triangle(a, b, c, color));
                break;
            default:
                System.out.println("[!] Invalid type.");
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
            System.out.println("[!] Invalid index.");
            return;
        }
        Shape s = shapes.get(idx);
        System.out.println("Editing: " + s);

        if (s instanceof Circle) {
            Circle circle = (Circle) s;
            System.out.println("  1. Radius (" + circle.getRadius() + ")");
            System.out.println("  2. Color (" + circle.getColor() + ")");
            int f = readInt("Field: ");
            if (f == 1)
                circle.setRadius(readDouble("New radius: "));
            else if (f == 2)
                circle.setColor(readString("New color: "));
            else {
                System.out.println("[!] Invalid field.");
                return;
            }
        } else if (s instanceof Rectangle) {
            Rectangle rect = (Rectangle) s;
            System.out.println("  1. Width (" + rect.getWidth() + ")");
            System.out.println("  2. Height (" + rect.getHeight() + ")");
            System.out.println("  3. Color (" + rect.getColor() + ")");
            int f = readInt("Field: ");
            if (f == 1)
                rect.setWidth(readDouble("New width: "));
            else if (f == 2)
                rect.setHeight(readDouble("New height: "));
            else if (f == 3)
                rect.setColor(readString("New color: "));
            else {
                System.out.println("[!] Invalid field.");
                return;
            }
        } else if (s instanceof Triangle) {
            Triangle tri = (Triangle) s;
            System.out.println("  1. Side A (" + tri.getSideA() + ")");
            System.out.println("  2. Side B (" + tri.getSideB() + ")");
            System.out.println("  3. Side C (" + tri.getSideC() + ")");
            System.out.println("  4. Color (" + tri.getColor() + ")");
            int f = readInt("Field: ");
            if (f == 1)
                tri.setSideA(readDouble("New side A: "));
            else if (f == 2)
                tri.setSideB(readDouble("New side B: "));
            else if (f == 3)
                tri.setSideC(readDouble("New side C: "));
            else if (f == 4)
                tri.setColor(readString("New color: "));
            else {
                System.out.println("[!] Invalid field.");
                return;
            }
        }
        System.out.println("Updated: " + s);
    }

    static void showLargestArea() {
        if (shapes.isEmpty()) {
            System.out.println("  No shapes.");
            return;
        }
        Shape max = shapes.get(0);
        for (Shape s : shapes) {
            if (s.calculateSurface() > max.calculateSurface())
                max = s;
        }
        System.out.println("Largest area: " + max);
    }

    static void showLargestPerimeter() {
        if (shapes.isEmpty()) {
            System.out.println("  No shapes.");
            return;
        }
        Shape max = shapes.get(0);
        for (Shape s : shapes) {
            if (s.calculatePerimeter() > max.calculatePerimeter())
                max = s;
        }
        System.out.println("Largest perimeter: " + max);
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
