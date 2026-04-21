package tp4.exo1.simple;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30, "alice@ensta.dz");
        System.out.println(person);

        Teacher teacher = new Teacher("Bob", 45, "bob@ensta.dz", "Mathematics", 20);
        System.out.println(teacher);

        teacher.teach();
        teacher.evaluateStudents();

        teacher.setSubject("Physics");
        teacher.setExperience(21);
        System.out.println("After update: " + teacher);
    }
}
