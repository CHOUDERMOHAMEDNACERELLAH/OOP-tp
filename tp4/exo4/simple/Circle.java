package tp4.exo4.simple;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double calculateSurface() {
        return Math.PI * radius * radius;
    }
}
