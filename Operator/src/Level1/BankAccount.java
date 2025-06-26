// Q1_BankAccount.java
// Sample Program 1: Bank Account System
// Demonstrates static, this, final, and instanceof best practices
package Level1;

public class BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    private final int accountNumber;
    private String accountHolderName;

    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1001);
        BankAccount acc2 = new BankAccount("Bob", 1002);
        Object obj = acc1;
        if (obj instanceof BankAccount) {
            ((BankAccount) obj).displayDetails();
        }
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
