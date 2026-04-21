package tp4.exo4.dev;

public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateSurface();

    public String toString() {
        return name + " | Surface: " + String.format("%.2f", calculateSurface());
    }
}
