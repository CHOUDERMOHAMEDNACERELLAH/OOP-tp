package tp8.exo1.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UniversitySystem {
    private final Map<String, Student> students;
    private final Map<String, Course> courses;

    public UniversitySystem() {
        this.students = new LinkedHashMap<String, Student>();
        this.courses = new LinkedHashMap<String, Course>();
    }

    public void addStudent(String id, String name) {
        if (students.containsKey(id)) {
            throw new IllegalArgumentException("Student with id '" + id + "' already exists.");
        }
        students.put(id, new Student(id, name));
    }

    public void addCourse(String code, String title, int capacity) {
        if (courses.containsKey(code)) {
            throw new IllegalArgumentException("Course with code '" + code + "' already exists.");
        }
        courses.put(code, new Course(code, title, capacity));
    }

    public Student findStudentById(String id) {
        return students.get(id);
    }

    public Course findCourseByCode(String code) {
        return courses.get(code);
    }

    public void enrollStudentInCourse(String studentId, String courseCode) {
        Student student = findStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found: " + studentId);
        }
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            throw new IllegalArgumentException("Course not found: " + courseCode);
        }
        if (course.getEnrolledStudents().contains(student)) {
            throw new IllegalStateException("Student is already enrolled in this course.");
        }
        if (course.isFull()) {
            throw new IllegalStateException("Course capacity has been reached.");
        }
        if (!course.attachStudent(student)) {
            throw new IllegalStateException("Unable to enroll student in course.");
        }
        if (!student.attachCourse(course)) {
            course.detachStudent(student);
            throw new IllegalStateException("Unable to update student enrollment.");
        }
    }

    public void removeStudentFromCourse(String studentId, String courseCode) {
        Student student = findStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found: " + studentId);
        }
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            throw new IllegalArgumentException("Course not found: " + courseCode);
        }
        if (!course.detachStudent(student)) {
            throw new IllegalStateException("Student is not enrolled in this course.");
        }
        student.detachCourse(course);
    }

    public void removeStudent(String id) {
        Student student = students.remove(id);
        if (student == null) {
            throw new IllegalArgumentException("Student not found: " + id);
        }
        for (Course course : new ArrayList<Course>(student.getEnrolledCourses())) {
            course.detachStudent(student);
            student.detachCourse(course);
        }
    }

    public void removeCourse(String code) {
        Course course = courses.remove(code);
        if (course == null) {
            throw new IllegalArgumentException("Course not found: " + code);
        }
        for (Student student : new ArrayList<Student>(course.getEnrolledStudents())) {
            student.detachCourse(course);
            course.detachStudent(student);
        }
    }

    public List<Student> getStudentsSortedByName() {
        List<Student> sorted = new ArrayList<Student>(students.values());
        Collections.sort(sorted, Comparator.comparing(Student::getName).thenComparing(Student::getId));
        return sorted;
    }

    public List<Course> getCoursesSortedByCapacity() {
        List<Course> sorted = new ArrayList<Course>(courses.values());
        Collections.sort(sorted, Comparator.comparingInt(Course::getCapacity).thenComparing(Course::getCode));
        return sorted;
    }

    public Map<Integer, List<Student>> groupStudentsByCourseCount() {
        Map<Integer, List<Student>> grouped = new TreeMap<Integer, List<Student>>();
        for (Student student : students.values()) {
            int courseCount = student.getEnrolledCourses().size();
            List<Student> list = grouped.get(courseCount);
            if (list == null) {
                list = new ArrayList<Student>();
                grouped.put(courseCount, list);
            }
            list.add(student);
        }
        for (List<Student> list : grouped.values()) {
            Collections.sort(list, Comparator.comparing(Student::getName).thenComparing(Student::getId));
        }
        return grouped;
    }

    public Course findCourseWithHighestEnrollment() {
        Course best = null;
        for (Course course : courses.values()) {
            if (best == null || course.getEnrolledCount() > best.getEnrolledCount()) {
                best = course;
            }
        }
        return best;
    }

    public List<Student> listStudentsInCourse(String courseCode) {
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            throw new IllegalArgumentException("Course not found: " + courseCode);
        }
        return new ArrayList<Student>(course.getEnrolledStudents());
    }

    public List<Course> listCoursesOfStudent(String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found: " + studentId);
        }
        return new ArrayList<Course>(student.getEnrolledCourses());
    }

    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }

    public List<Course> getAllCourses() {
        return new ArrayList<Course>(courses.values());
    }

    public int getTotalStudents() {
        return students.size();
    }

    public int getTotalCourses() {
        return courses.size();
    }

    public double getAverageEnrollmentPerCourse() {
        if (courses.isEmpty()) {
            return 0.0;
        }
        int totalEnrollments = 0;
        for (Course course : courses.values()) {
            totalEnrollments += course.getEnrolledCount();
        }
        return (double) totalEnrollments / courses.size();
    }
}
