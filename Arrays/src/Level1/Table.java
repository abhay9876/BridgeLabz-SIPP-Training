package Level1;

import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        int[] multiplicationResult = new int[4];

        for (int i = 0; i < 4; i++) {
            multiplicationResult[i] = input * (i + 6);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(input + " * " + (i + 6) + " = " + multiplicationResult[i]);
        }

        scanner.close();
    }
}
