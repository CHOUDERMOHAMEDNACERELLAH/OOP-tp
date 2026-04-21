package tp5.exo3.dev;

public abstract class Shape {
    private String name;
    private String color;

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double calculateSurface();

    public abstract double calculatePerimeter();

    public String toString() {
        return name + " [" + color + "]"
                + " | Area: " + String.format("%.2f", calculateSurface())
                + " | Perimeter: " + String.format("%.2f", calculatePerimeter());
    }
}
