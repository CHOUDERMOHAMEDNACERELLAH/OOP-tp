package tp8.exo1.simple;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UniversitySystem system = new UniversitySystem();

        system.addStudent("S001", "Amina");
        system.addStudent("S002", "Youssef");
        system.addStudent("S003", "Sara");

        system.addCourse("CS101", "Introduction to Programming", 2);
        system.addCourse("CS102", "Data Structures", 3);
        system.addCourse("CS103", "Algorithms", 4);

        system.enrollStudentInCourse("S001", "CS101");
        system.enrollStudentInCourse("S001", "CS102");
        system.enrollStudentInCourse("S002", "CS101");
        system.enrollStudentInCourse("S003", "CS102");
        system.enrollStudentInCourse("S003", "CS103");

        System.out.println("=== Students Sorted by Name ===");
        for (Student student : system.getStudentsSortedByName()) {
            System.out.println(student);
        }

        System.out.println();
        System.out.println("=== Courses Sorted by Capacity ===");
        for (Course course : system.getCoursesSortedByCapacity()) {
            System.out.println(course);
        }

        System.out.println();
        System.out.println("=== Students in CS102 ===");
        for (Student student : system.listStudentsInCourse("CS102")) {
            System.out.println("- " + student.getName());
        }

        System.out.println();
        System.out.println("=== Courses of S001 ===");
        for (Course course : system.listCoursesOfStudent("S001")) {
            System.out.println("- " + course.getTitle());
        }

        System.out.println();
        System.out.println("=== Grouped by Number of Courses ===");
        for (Map.Entry<Integer, List<Student>> entry : system.groupStudentsByCourseCount().entrySet()) {
            System.out.println(entry.getKey() + " course(s):");
            for (Student student : entry.getValue()) {
                System.out.println("  - " + student.getName());
            }
        }

        System.out.println();
        Course busiest = system.findCourseWithHighestEnrollment();
        System.out.println("Course with highest enrollment: " + (busiest == null ? "none" : busiest.getTitle()));
        System.out.println("Total students: " + system.getTotalStudents());
        System.out.println("Total courses: " + system.getTotalCourses());
        System.out.println("Average enrollment per course: " + String.format("%.2f", system.getAverageEnrollmentPerCourse()));
    }
}
