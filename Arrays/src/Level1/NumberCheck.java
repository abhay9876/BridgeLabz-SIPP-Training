package Level1;

import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        int[] input = new int[5];
        Scanner scanner = new Scanner(System.in);

        
        for (int i = 0; i < input.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            input[i] = scanner.nextInt();
        }

        
        for (int i = 0; i < input.length; i++) {
            int number = input[i];
            System.out.print("Element " + (i + 1) + " is " + number + " => ");

            if (number > 0) {
                if (number % 2 == 0)
                    System.out.println("Positive and Even");
                else
                    System.out.println("Positive and Odd");
            } else if (number < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        
        if (input[0] == input[4]) {
            System.out.println("First and Last elements are Equal.");
        } else if (input[0] > input[4]) {
            System.out.println("First element is Greater than Last.");
        } else {
            System.out.println("First element is Less than Last.");
        }

        scanner.close();
    }
}

