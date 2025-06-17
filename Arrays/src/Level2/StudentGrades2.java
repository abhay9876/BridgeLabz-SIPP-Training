package Level2;


import java.util.Scanner;

public class StudentGrades2 {
    public static void main(String[] args) {
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        
        double[][] marks = new double[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];

        
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                marks[i][j] = scanner.nextDouble();
                
                while (marks[i][j] < 0) {
                    System.out.print("Please enter positive marks for Subject " + (j + 1) + ": ");
                    marks[i][j] = scanner.nextDouble();
                }
            }
           
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;

            
            if (percentages[i] >= 90) {
                grades[i] = "A";
            } else if (percentages[i] >= 80) {
                grades[i] = "B";
            } else if (percentages[i] >= 70) {
                grades[i] = "C";
            } else if (percentages[i] >= 60) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

      
        System.out.println("\nStudent Grades:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1) + ": Marks: " + marks[i][0] + ", " + marks[i][1] + ", " + marks[i][2] +
                    " | Percentage: " + percentages[i] + "% | Grade: " + grades[i]);
        }

        scanner.close();
    }
}
