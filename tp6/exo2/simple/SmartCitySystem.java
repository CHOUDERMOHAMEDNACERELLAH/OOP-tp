package tp6.exo2.simple;

/*
 * ============================================================
 *  ORIGINAL CODE — ERRORS FOUND & EXPLAINED
 * ============================================================
 *
 * ERROR 1 — CityDashboard.showStatus() accesses 'cityName'
 *   Problem : CityDashboard is a STATIC nested class.
 *             Static nested classes have NO implicit reference to
 *             an outer instance, so they cannot access instance
 *             fields like 'cityName'.
 *   Fix     : Pass cityName as a constructor parameter instead.
 *
 * ERROR 2 — 'static class TemporarySensor' inside operateSystem()
 *   Problem : Local classes (declared inside a method) cannot be
 *             declared 'static' in Java.
 *   Fix     : Remove the 'static' modifier from TemporarySensor.
 *
 * ERROR 3 — Anonymous class for emergencyCommand has no body
 *   Problem : 'Command' is an interface with an abstract method
 *             execute(). The anonymous class must implement it.
 *   Fix     : Add 'public void execute() { ... }' to the body.
 *
 * ERROR 4 — 'wrongCommand' anonymous class implements run() not execute()
 *   Problem : The Command interface declares execute(), not run().
 *             The anonymous class doesn't fulfil the contract.
 *   Fix     : Rename run() to execute().
 *
 * ERROR 5 — new SmartCitySystem.PowerUnit() in Main
 *   Problem : PowerUnit is a NON-STATIC inner class. It cannot be
 *             instantiated without an enclosing SmartCitySystem
 *             instance.
 *   Fix     : Create a SmartCitySystem instance first, then use
 *             system.new PowerUnit().
 *
 * ERROR 6 — new CityDashboard() in Main
 *   Problem : CityDashboard is a static nested class of
 *             SmartCitySystem; it must be referenced with its
 *             fully qualified name SmartCitySystem.CityDashboard.
 *   Fix     : SmartCitySystem.CityDashboard dashboard =
 *                 new SmartCitySystem.CityDashboard(cityName);
 * ============================================================
 */
public class SmartCitySystem {
    String cityName = "NeoCity";
    boolean powerOn = true;

    // FIX 1: CityDashboard is static → cannot access outer instance field.
    // Solution: accept cityName as a constructor parameter.
    static class CityDashboard {
        private String cityName;

        CityDashboard(String cityName) {
            this.cityName = cityName;
        }

        void showStatus() {
            System.out.println("City: " + cityName);
        }
    }

    // PowerUnit is a non-static inner class → needs an outer instance.
    class PowerUnit {
        void shutdown() {
            powerOn = false; // accesses outer instance field correctly
            System.out.println("Power shutdown");
        }
    }

    void operateSystem() {
        // FIX 2: removed 'static' — local classes cannot be static.
        class TemporarySensor {
            void scan() {
                System.out.println("Scanning city sensors");
            }
        }
        TemporarySensor sensor = new TemporarySensor();
        sensor.scan();

        // FIX 3: anonymous class now implements execute().
        Command emergencyCommand = new Command() {
            public void execute() {
                System.out.println("Emergency protocol activated!");
            }
        };
        emergencyCommand.execute();
    }

    // FIX 4: changed run() to execute() to implement Command correctly.
    Command wrongCommand = new Command() {
        public void execute() {
            System.out.println("Backup command executed");
        }
    };
}
