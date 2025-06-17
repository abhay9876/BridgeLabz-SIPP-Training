package Level1;

import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        double[] input = new double[10];
        double total = 0.0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double number = scanner.nextDouble();

            if (number <= 0 || index == 10)
                break;

            input[index] = number;
            index++;
        }

        System.out.print("Numbers entered: ");
        for (int i = 0; i < index; i++) {
            System.out.print(input[i] + " ");
            total += input[i];
        }

        System.out.println("\nSum of all numbers: " + total);
        scanner.close();
    }
}
