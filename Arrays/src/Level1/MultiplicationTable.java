package Level1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        int[] multiplication = new int[10];

        for (int i = 0; i < 10; i++) {
            multiplication[i] = input * (i + 1);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(input + " * " + (i + 1) + " = " + multiplication[i]);
        }

        scanner.close();
    }
}
