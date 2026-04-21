package tp6.exo2.simple;

public class Main {
    public static void main(String[] args) {
        SmartCitySystem system = new SmartCitySystem();

        // FIX 5: PowerUnit is non-static → must use outer instance reference.
        SmartCitySystem.PowerUnit unit = system.new PowerUnit();
        unit.shutdown();

        // FIX 6: use fully qualified name; pass cityName to constructor.
        SmartCitySystem.CityDashboard dashboard = new SmartCitySystem.CityDashboard(system.cityName);
        dashboard.showStatus();

        system.operateSystem();

        // Demonstrate the corrected wrongCommand anonymous class.
        system.wrongCommand.execute();
    }
}
