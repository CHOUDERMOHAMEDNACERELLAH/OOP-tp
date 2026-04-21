package tp5.exo1.dev;

public class PassengerVehicle extends Vehicle {
    private int seatCapacity;

    public PassengerVehicle(String id, String brand, String model, int year, int seatCapacity) {
        super(id, brand, model, year);
        this.seatCapacity = seatCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public void operate() {
        System.out.println(getBrand() + " " + getModel()
                + " is transporting up to " + seatCapacity + " passengers.");
    }

    public String toString() {
        return super.toString() + " | Passenger | Seats: " + seatCapacity;
    }
}
