package Level1;
import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int number3 = sc.nextInt();

        if(number1 > number2 && number1 > number3) {
        	System.out.print("First number is largest !");
        }
        else if(number2 > number1 && number2 > number3) {
        	System.out.print("Second number is largest !");
        }
        else {
        	System.out.print("Third number is largest !");
        }
    }
}
