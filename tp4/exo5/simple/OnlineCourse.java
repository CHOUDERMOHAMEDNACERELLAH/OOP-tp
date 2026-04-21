package tp4.exo5.simple;

public class OnlineCourse extends Course {
    private String platform;
    private int accessDuration;

    public OnlineCourse(String title, String code, int duration, String platform, int accessDuration) {
        super(title, code, duration);
        this.platform = platform;
        this.accessDuration = accessDuration;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getAccessDuration() {
        return accessDuration;
    }

    public void setAccessDuration(int accessDuration) {
        this.accessDuration = accessDuration;
    }

    public void startCourse() {
        System.out.println("Starting online course: " + getTitle() + " on " + platform);
    }

    public void startOnlineSession() {
        System.out.println("Launching online session for " + getTitle() + " on " + platform + ".");
    }

    public void provideResources() {
        System.out.println("Providing digital resources for " + getTitle() + " (access: " + accessDuration + " days).");
    }

    public String toString() {
        return "OnlineCourse [title=" + getTitle() + ", code=" + getCode() + ", duration=" + getDuration()
                + "h, platform=" + platform + ", access=" + accessDuration + " days]";
    }
}
