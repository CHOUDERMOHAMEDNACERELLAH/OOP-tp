package tp5.exo3.simple;

public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateSurface();

    public abstract double calculatePerimeter();

    public String toString() {
        return name
                + " | Area: " + String.format("%.2f", calculateSurface())
                + " | Perimeter: " + String.format("%.2f", calculatePerimeter());
    }
}
