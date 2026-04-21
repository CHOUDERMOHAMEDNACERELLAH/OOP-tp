package tp5.exo3.simple;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5),
                new Circle(3.5),
                new Rectangle(4, 7),
                new Rectangle(10, 2),
                new Triangle(3, 4, 5),
                new Triangle(6, 8, 10)
        };

        System.out.println("=== Shapes Overview ===");
        for (Shape s : shapes) {
            System.out.println("  " + s);
        }

        // Find shape with largest area using polymorphism
        Shape largest = shapes[0];
        for (Shape s : shapes) {
            if (s.calculateSurface() > largest.calculateSurface()) {
                largest = s;
            }
        }
        System.out.println("\nLargest area: " + largest);
    }
}
