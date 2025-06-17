package Level2;

import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        
        double[][] marks = new double[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];

        
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                while (true) {
                    System.out.print(subject + " marks (0-100): ");
                    double m = sc.nextDouble();
                    if (m >= 0 && m <= 100) {
                        marks[i][j] = m;
                        break;
                    }
                    System.out.println("Invalid marks. Try again.");
                }
            }

            
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3;

         
            if (percentage[i] >= 90) grade[i] = "A+";
            else if (percentage[i] >= 80) grade[i] = "A";
            else if (percentage[i] >= 70) grade[i] = "B";
            else if (percentage[i] >= 60) grade[i] = "C";
            else if (percentage[i] >= 50) grade[i] = "D";
            else grade[i] = "F";
        }

        
        System.out.println("\n--- Student Report ---");
        System.out.printf("%-10s %-10s %-10s %-10s %-12s %-6s\n", "Physics", "Chemistry", "Maths", "Total", "Percent", "Grade");

        for (int i = 0; i < number; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            System.out.printf("%-10.2f %-10.2f %-10.2f %-10.2f %-12.2f %-6s\n",
                    marks[i][0], marks[i][1], marks[i][2], total, percentage[i], grade[i]);
        }
    }
}
