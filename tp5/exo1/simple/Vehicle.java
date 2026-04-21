package tp5.exo1.simple;

public abstract class Vehicle {
    private String id;
    private String brand;
    private String model;
    private int year;

    public Vehicle(String id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public abstract void operate();

    public String toString() {
        return "[" + id + "] " + brand + " " + model + " (" + year + ")";
    }
}
