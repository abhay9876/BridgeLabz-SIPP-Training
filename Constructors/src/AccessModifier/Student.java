package AccessModifier;

public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value. It should be between 0.0 and 10.0.");
        }
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student:");
        System.out.println("Name: " + name); 
        System.out.println("Specialization: " + specialization);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("CGPA: " + getCGPA()); 
    }
}

class Students {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Ravi Kumar", 8.7);
        s1.displayStudentDetails();

        System.out.println();

        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Anjali Sharma", 9.2, "Data Science");
        pg1.displayPostgraduateDetails();

        System.out.println("\nUpdating CGPA...");
        pg1.setCGPA(9.5);
        pg1.displayPostgraduateDetails();
    }
}
