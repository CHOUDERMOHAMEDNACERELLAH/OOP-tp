package tp4.exo5.simple;

public class Main {
    public static void main(String[] args) {
        Individual ind = new Individual("Ali Mansour", "IND001", 25);
        Teacher teacher = new Teacher("Dr. Karim Hadj", "TCH001", 45, "Mathematics", 18);
        SeniorTeacher senior = new SeniorTeacher("Prof. Yacine Bey", "TCH002", 52, "Algorithms", 25,
                "Head of Department");

        System.out.println("=== People ===");
        System.out.println(ind);
        System.out.println(teacher);
        System.out.println(senior);

        System.out.println("\n=== Polymorphic performAction ===");
        Individual[] people = { ind, teacher, senior };
        for (Individual p : people) {
            p.performAction();
        }

        System.out.println("\n=== Teacher-specific actions ===");
        teacher.grading();
        senior.mentorTeachers();

        Course course = new Course("Data Structures", "CS201", 40);
        OnlineCourse online = new OnlineCourse("Machine Learning", "CS401", 30, "Moodle", 90);

        System.out.println("\n=== Courses ===");
        System.out.println(course);
        System.out.println(online);

        System.out.println("\n=== Polymorphic startCourse ===");
        Course[] courses = { course, online };
        for (Course c : courses) {
            c.startCourse();
        }

        System.out.println("\n=== OnlineCourse-specific actions ===");
        online.startOnlineSession();
        online.provideResources();
    }
}
