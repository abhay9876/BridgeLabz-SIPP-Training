package InstanceVsClass;
public class Course {
    String courseName;
    int duration; 
    double fee;
    static String instituteName = "Tech Academy"; 

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 8, 4000.0);
        Course c2 = new Course("Web Development", 10, 5000.0);

        System.out.println("Before Institute Name Update:\n");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        Course.updateInstituteName("CodeCraft Institute");

        System.out.println("\nAfter Institute Name Update:\n");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
