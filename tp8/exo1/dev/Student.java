package tp8.exo1.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private final String id;
    private String name;
    private final List<Course> enrolledCourses;

    public Student(String id, String name) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Student id cannot be empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.id = id.trim();
        this.name = name.trim();
        this.enrolledCourses = new ArrayList<Course>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.name = name.trim();
    }

    public List<Course> getEnrolledCourses() {
        return Collections.unmodifiableList(enrolledCourses);
    }

    boolean attachCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            return false;
        }
        enrolledCourses.add(course);
        return true;
    }

    boolean detachCourse(Course course) {
        return enrolledCourses.remove(course);
    }

    public String toString() {
        return "Student[id=" + id + ", name=" + name + ", enrolledCourses=" + enrolledCourses.size() + "]";
    }
}
