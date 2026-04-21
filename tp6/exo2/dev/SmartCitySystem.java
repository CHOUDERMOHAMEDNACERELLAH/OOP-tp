package tp6.exo2.dev;

public class SmartCitySystem {
    String cityName;
    boolean powerOn;
    int trafficLightCount;

    public SmartCitySystem(String cityName, int trafficLightCount) {
        this.cityName = cityName;
        this.powerOn = true;
        this.trafficLightCount = trafficLightCount;
    }

    // =========================================================
    // STATIC NESTED CLASS — CityDashboard
    // Independent of any SmartCitySystem instance.
    // Receives cityName via constructor (no outer 'this' access).
    // =========================================================
    static class CityDashboard {
        private String cityName;

        CityDashboard(String cityName) {
            this.cityName = cityName;
        }

        void showStatus() {
            System.out.println("  [Dashboard] City: " + cityName);
        }

        void showHelp() {
            System.out.println("  [Dashboard] Commands: shutdown | scan | emergency | backup");
        }
    }

    // =========================================================
    // NON-STATIC INNER CLASS — PowerUnit
    // Needs access to outer instance's powerOn field.
    // =========================================================
    class PowerUnit {
        void shutdown() {
            powerOn = false; // accesses outer instance field
            System.out.println("  [Power] " + cityName + " power grid offline.");
        }

        void restore() {
            powerOn = true;
            System.out.println("  [Power] " + cityName + " power grid restored.");
        }

        boolean isOn() {
            return powerOn;
        }
    }

    // =========================================================
    // NON-STATIC INNER CLASS — TrafficController
    // =========================================================
    class TrafficController {
        void regulate() {
            if (!powerOn) {
                System.out.println("  [Traffic] Cannot regulate — power is off.");
                return;
            }
            System.out.println("  [Traffic] Managing " + trafficLightCount
                    + " lights in " + cityName + ".");
        }

        void addLight() {
            trafficLightCount++;
            System.out.println("  [Traffic] Light added. Total: " + trafficLightCount);
        }
    }

    // =========================================================
    // METHOD WITH LOCAL CLASS — SensorScan
    // Temporary sensor logic that exists only during the scan.
    // =========================================================
    void operateSystem() {
        class TemporarySensor { // no 'static' — local classes cannot be static
            private String zone;

            TemporarySensor(String zone) {
                this.zone = zone;
            }

            void scan() {
                System.out.println("  [Sensor] Scanning zone '" + zone
                        + "' in " + cityName + " | power=" + powerOn);
            }
        }

        System.out.println("  [System] Running sensor sweep...");
        new TemporarySensor("North").scan();
        new TemporarySensor("South").scan();
        new TemporarySensor("East").scan();

        // Anonymous class: single emergency command
        Command emergencyCommand = new Command() {
            public void execute() {
                System.out.println("  [Emergency] All units on high alert in " + cityName + "!");
            }
        };
        emergencyCommand.execute();
    }

    // Anonymous class field: backup command
    Command backupCommand = new Command() {
        public void execute() { // was wrongly named run() in original
            System.out.println("  [Backup] Backup systems activated for " + cityName + ".");
        }
    };

    public String toString() {
        return "SmartCity['" + cityName + "', power=" + powerOn
                + ", lights=" + trafficLightCount + "]";
    }
}
