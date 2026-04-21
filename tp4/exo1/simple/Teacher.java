package tp4.exo1.simple;

public class Teacher extends Person {
    private String subject;
    private int experience;

    public Teacher(String name, int age, String email, String subject, int experience) {
        super(name, age, email);
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

    public void teach() {
        System.out.println(getName() + " is teaching " + subject + ".");
    }

    public void evaluateStudents() {
        System.out.println(getName() + " is evaluating students in " + subject + ".");
    }

    @Override
    public String toString() {
        return "Teacher [name=" + getName() + ", age=" + getAge() + ", email=" + getEmail()
                + ", subject=" + subject + ", experience=" + experience + " years]";
    }
}
