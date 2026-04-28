package tp8.exo1.dev;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static void printMenu() {
        System.out.println();
        System.out.println("=== University Course Management System ===");
        System.out.println("1. Add student");
        System.out.println("2. Add course");
        System.out.println("3. Enroll student in course");
        System.out.println("4. Remove student from course");
        System.out.println("5. Find student by ID");
        System.out.println("6. Find course by code");
        System.out.println("7. List students in a course");
        System.out.println("8. List courses of a student");
        System.out.println("9. Display students sorted by name");
        System.out.println("10. Display courses sorted by capacity");
        System.out.println("11. Group students by number of enrolled courses");
        System.out.println("12. Course with highest enrollment");
        System.out.println("13. Show statistics");
        System.out.println("14. Remove student from system");
        System.out.println("15. Remove course from system");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void printCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {
        UniversitySystem system = new UniversitySystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            try {
                if ("1".equals(choice)) {
                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Student name: ");
                    String name = scanner.nextLine();
                    system.addStudent(id, name);
                    System.out.println("Student added.");
                } else if ("2".equals(choice)) {
                    System.out.print("Course code: ");
                    String code = scanner.nextLine();
                    System.out.print("Course title: ");
                    String title = scanner.nextLine();
                    System.out.print("Course capacity: ");
                    int capacity = Integer.parseInt(scanner.nextLine().trim());
                    system.addCourse(code, title, capacity);
                    System.out.println("Course added.");
                } else if ("3".equals(choice)) {
                    System.out.print("Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Course code: ");
                    String courseCode = scanner.nextLine();
                    system.enrollStudentInCourse(studentId, courseCode);
                    System.out.println("Enrollment completed.");
                } else if ("4".equals(choice)) {
                    System.out.print("Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Course code: ");
                    String courseCode = scanner.nextLine();
                    system.removeStudentFromCourse(studentId, courseCode);
                    System.out.println("Student removed from course.");
                } else if ("5".equals(choice)) {
                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();
                    System.out.println(system.findStudentById(id));
                } else if ("6".equals(choice)) {
                    System.out.print("Course code: ");
                    String code = scanner.nextLine();
                    System.out.println(system.findCourseByCode(code));
                } else if ("7".equals(choice)) {
                    System.out.print("Course code: ");
                    String code = scanner.nextLine();
                    printStudents(system.listStudentsInCourse(code));
                } else if ("8".equals(choice)) {
                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();
                    printCourses(system.listCoursesOfStudent(id));
                } else if ("9".equals(choice)) {
                    printStudents(system.getStudentsSortedByName());
                } else if ("10".equals(choice)) {
                    printCourses(system.getCoursesSortedByCapacity());
                } else if ("11".equals(choice)) {
                    Map<Integer, List<Student>> grouped = system.groupStudentsByCourseCount();
                    for (Map.Entry<Integer, List<Student>> entry : grouped.entrySet()) {
                        System.out.println(entry.getKey() + " course(s):");
                        for (Student student : entry.getValue()) {
                            System.out.println("  - " + student.getName());
                        }
                    }
                } else if ("12".equals(choice)) {
                    Course best = system.findCourseWithHighestEnrollment();
                    System.out.println(best == null ? "No courses available." : best);
                } else if ("13".equals(choice)) {
                    System.out.println("Total students: " + system.getTotalStudents());
                    System.out.println("Total courses: " + system.getTotalCourses());
                    System.out.println("Average enrollment per course: " + String.format("%.2f", system.getAverageEnrollmentPerCourse()));
                } else if ("14".equals(choice)) {
                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();
                    system.removeStudent(id);
                    System.out.println("Student removed from system.");
                } else if ("15".equals(choice)) {
                    System.out.print("Course code: ");
                    String code = scanner.nextLine();
                    system.removeCourse(code);
                    System.out.println("Course removed from system.");
                } else if ("0".equals(choice)) {
                    running = false;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid numeric value.");
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}
