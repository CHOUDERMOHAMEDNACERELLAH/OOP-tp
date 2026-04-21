package tp4.exo5.dev;

public class SeniorTeacher extends Teacher {
    private String responsibilityLevel;

    public SeniorTeacher(String name, String id, int age, String subject, int experience, String responsibilityLevel) {
        super(name, id, age, subject, experience);
        this.responsibilityLevel = responsibilityLevel;
    }

    public String getResponsibilityLevel() {
        return responsibilityLevel;
    }

    public void setResponsibilityLevel(String responsibilityLevel) {
        this.responsibilityLevel = responsibilityLevel;
    }

    public void performAction() {
        System.out.println(
                getName() + " is leading and supervising in " + getSubject() + " [" + responsibilityLevel + "].");
    }

    public void mentorTeachers() {
        System.out.println(getName() + " is mentoring junior teachers.");
    }

    public String toString() {
        return "SeniorTeacher | " + getName() + " | ID: " + getId() + " | Age: " + getAge()
                + " | Subject: " + getSubject() + " | Exp: " + getExperience()
                + " yrs | Level: " + responsibilityLevel;
    }
}
