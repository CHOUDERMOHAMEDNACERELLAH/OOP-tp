package tp4.exo5.dev;

public class Course {
    private String title;
    private String code;
    private int duration;

    public Course(String title, String code, int duration) {
        this.title = title;
        this.code = code;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void startCourse() {
        System.out.println("Starting course: " + title + " (" + code + ")");
    }

    public String toString() {
        return "Course | " + title + " | Code: " + code + " | Duration: " + duration + "h";
    }
}
