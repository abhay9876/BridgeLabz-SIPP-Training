package Level2;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            double height, weight;

            
            while (true) {
                System.out.print("Enter height in meters: ");
                height = sc.nextDouble();
                if (height > 0) break;
                System.out.println("Height must be positive. Try again.");
            }

           
            while (true) {
                System.out.print("Enter weight in kg: ");
                weight = sc.nextDouble();
                if (weight > 0) break;
                System.out.println("Weight must be positive. Try again.");
            }

           
            personData[i][0] = height;
            personData[i][1] = weight;

            
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

       
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height", "Weight", "BMI", "Status");

        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n",
                    personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}

