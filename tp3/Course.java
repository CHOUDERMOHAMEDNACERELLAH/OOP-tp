public class Course {
    String courseName;
    String code;
    int credits;

    Course(String courseName, String code, int credits) {
        this.courseName = courseName;
        this.code = code;
        this.credits = credits;
    }

    void display() {
        System.out.println("Course: " + courseName + " | Code: " + code + " | Credits: " + credits);
    }

    boolean isFullCredit() {
        return credits >= 4;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Object Oriented Programming", "OOP101", 4);
        Course c2 = new Course("Data Structures", "DS201", 3);
        Course c3 = new Course("Database Systems", "DB301", 5);

        c1.display();
        System.out.println("Full credit: " + c1.isFullCredit());
        System.out.println();

        c2.display();
        System.out.println("Full credit: " + c2.isFullCredit());
        System.out.println();

        c3.display();
        System.out.println("Full credit: " + c3.isFullCredit());
    }
}
