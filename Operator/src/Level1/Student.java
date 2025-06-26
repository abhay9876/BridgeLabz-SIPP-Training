// Student.java
// Sample Program 5: University Student Management
// Demonstrates static, this, final, and instanceof best practices
package Level1;

public class Student {
    private static String universityName = "National University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Rita", 201, "A");
        Object obj = student1;
        if (obj instanceof Student) {
            ((Student) obj).displayDetails();
        }
        Student.displayTotalStudents();
    }
}
