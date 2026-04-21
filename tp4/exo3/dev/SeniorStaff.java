package tp4.exo3.dev;

public class SeniorStaff extends Staff {
    private String responsibilityLevel;

    public SeniorStaff(String name, String id, String email, String department, int workYears,
            String responsibilityLevel) {
        super(name, id, email, department, workYears);
        this.responsibilityLevel = responsibilityLevel;
    }

    public String getResponsibilityLevel() {
        return responsibilityLevel;
    }

    public void setResponsibilityLevel(String responsibilityLevel) {
        this.responsibilityLevel = responsibilityLevel;
    }

    public void manageSection() {
        System.out.println(getName() + " (Level: " + responsibilityLevel + ") is managing a library section.");
    }

    public String toString() {
        return "Senior     | " + getName() + " | ID: " + getId() + " | Dept: " + getDepartment()
                + " | Years: " + getWorkYears() + " | Level: " + responsibilityLevel;
    }
}
