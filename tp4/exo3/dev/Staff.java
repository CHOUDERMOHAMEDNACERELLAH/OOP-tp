package tp4.exo3.dev;

public class Staff extends Individual {
    private String department;
    private int workYears;

    public Staff(String name, String id, String email, String department, int workYears) {
        super(name, id, email);
        this.department = department;
        this.workYears = workYears;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getWorkYears() {
        return workYears;
    }

    public void setWorkYears(int workYears) {
        this.workYears = workYears;
    }

    public void performStaffDuties() {
        System.out.println(getName() + " is performing staff duties in " + department + ".");
    }

    public void assistUsers() {
        System.out.println(getName() + " is assisting library users.");
    }

    public String toString() {
        return "Staff      | " + getName() + " | ID: " + getId() + " | Dept: " + department + " | Years: " + workYears;
    }
}
