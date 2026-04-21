package tp4.exo4.simple;

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
        return name + " | Surface: " + calculateSurface();
    }
}
