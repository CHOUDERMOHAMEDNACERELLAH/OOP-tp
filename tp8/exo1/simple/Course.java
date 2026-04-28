package tp8.exo1.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private final String code;
    private String title;
    private final int capacity;
    private final List<Student> enrolledStudents;

    public Course(String code, String title, int capacity) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Course title cannot be empty.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Course capacity must be greater than zero.");
        }
        this.code = code.trim();
        this.title = title.trim();
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<Student>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Course title cannot be empty.");
        }
        this.title = title.trim();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledCount() {
        return enrolledStudents.size();
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public List<Student> getEnrolledStudents() {
        return Collections.unmodifiableList(enrolledStudents);
    }

    boolean attachStudent(Student student) {
        if (enrolledStudents.contains(student)) {
            return false;
        }
        if (isFull()) {
            return false;
        }
        enrolledStudents.add(student);
        return true;
    }

    boolean detachStudent(Student student) {
        return enrolledStudents.remove(student);
    }

    public String toString() {
        return "Course[code=" + code + ", title=" + title + ", capacity=" + capacity + ", enrolled=" + enrolledStudents.size() + "]";
    }
}
