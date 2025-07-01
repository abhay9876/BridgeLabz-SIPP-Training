package ReviewTasks;
import java.util.Scanner;

public class RechargeSimulation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000;
        System.out.println(" Recharge Simulation ----");
        System.out.println("Choose your SIM provider:");
        System.out.println("1. Jio (₹239)");
        System.out.println("2. Airtel (₹265)");
        System.out.println("3. VI (₹249)");

        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();

        String simName = "";
        int rechargeAmount = 0;

        switch (choice) {
            case 1:
                simName = "Jio";
                rechargeAmount = 239;
                break;
            case 2:
                simName = "Airtel";
                rechargeAmount = 265;
                break;
            case 3:
                simName = "VI";
                rechargeAmount = 249;
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2 or 3.");
                sc.close();
                return;
        }

        System.out.println("\nRecharge Successful!");
        System.out.println("SIM Provider: " + simName);
        System.out.println("Recharge Amount: ₹" + rechargeAmount);
        System.out.println("Remaining Balance : "+ (balance - rechargeAmount));

        sc.close();
    }
}
