package tp7.exo2.simple;

public class Employee extends IntegratedElement {
    private static final long serialVersionUID = 1L;

    private double salary;
    private String department;

    public Employee(String id, String name, double salary, String department) {
        super(id, name, "Employee");
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void validate() throws InvalidDataException {
        validateCommon();
        if (salary <= 0) {
            throw new InvalidSalaryException("Salary must be > 0.");
        }
        if (department == null || department.trim().isEmpty()) {
            throw new InvalidDataException("Department is required.");
        }
    }

    @Override
    public String toTextLine() {
        return "EMPLOYEE;" + getId() + ";" + getName() + ";" + salary + ";" + department;
    }

    @Override
    public String display() {
        return super.display() + ", salary=" + salary + ", department=" + department;
    }
}
