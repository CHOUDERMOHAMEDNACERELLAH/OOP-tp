package tp5.exo1.simple;

public class CargoVehicle extends Vehicle {
    private double maxLoadTons;

    public CargoVehicle(String id, String brand, String model, int year, double maxLoadTons) {
        super(id, brand, model, year);
        this.maxLoadTons = maxLoadTons;
    }

    public double getMaxLoadTons() {
        return maxLoadTons;
    }

    public void setMaxLoadTons(double maxLoadTons) {
        this.maxLoadTons = maxLoadTons;
    }

    public void operate() {
        System.out.println(getBrand() + " " + getModel()
                + " is hauling up to " + maxLoadTons + " tons of cargo.");
    }

    public String toString() {
        return super.toString() + " | Cargo | Max Load: " + maxLoadTons + "t";
    }
}
