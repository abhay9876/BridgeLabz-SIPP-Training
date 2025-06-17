package Level2;


import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Enter the number of persons: ");
        int number = scanner.nextInt();
        
        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];
        
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight for person " + (i + 1) + ": ");
            double weight = scanner.nextDouble();
            while (weight < 0) {
                System.out.print("Please enter a positive weight: ");
                weight = scanner.nextDouble();
            }
            personData[i][0] = weight;

            System.out.print("Enter height for person " + (i + 1) + ": ");
            double height = scanner.nextDouble();
            while (height < 0) {
                System.out.print("Please enter a positive height: ");
                height = scanner.nextDouble();
            }
            personData[i][1] = height;

            // Calculate BMI
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            // Determine weight status
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        // Display results
        System.out.println("Height\tWeight\tBMI\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s%n", personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
        
        scanner.close();
    }
}