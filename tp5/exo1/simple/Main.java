package tp5.exo1.simple;

public class Main {
    public static void main(String[] args) {
        Vehicle[] fleet = {
                new PassengerVehicle("V001", "Mercedes", "Sprinter", 2022, 20),
                new PassengerVehicle("V002", "Toyota", "Coaster", 2021, 30),
                new CargoVehicle("V003", "Volvo", "FH16", 2023, 25.0),
                new CargoVehicle("V004", "Scania", "R500", 2020, 18.5)
        };

        System.out.println("=== Fleet Overview ===");
        for (Vehicle v : fleet) {
            System.out.println("  " + v);
        }

        System.out.println("\n=== Fleet Operations ===");
        for (Vehicle v : fleet) {
            v.operate();
        }
    }
}
