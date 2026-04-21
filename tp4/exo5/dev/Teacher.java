package tp4.exo5.dev;

public class Teacher extends Individual {
    private String subject;
    private int experience;

    public Teacher(String name, String id, int age, String subject, int experience) {
        super(name, id, age);
        this.subject = subject;
        this.experience = experience;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void performAction() {
        System.out.println(getName() + " is teaching " + subject + ".");
    }

    public void grading() {
        System.out.println(getName() + " is grading students in " + subject + ".");
    }

    public String toString() {
        return "Teacher | " + getName() + " | ID: " + getId() + " | Age: " + getAge()
                + " | Subject: " + subject + " | Exp: " + experience + " yrs";
    }
}
