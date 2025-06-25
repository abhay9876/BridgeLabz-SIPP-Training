package AccessModifier;

public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsAccountDetails() {
        System.out.println("Savings Account Number: " + accountNumber);        
        System.out.println("Account Holder: " + accountHolder);               
        System.out.println("Balance: ₹" + getBalance());                      
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("ACC1001", "Rahul Verma", 10000);
        account1.displayAccountDetails();

        System.out.println();

        SavingsAccount savings1 = new SavingsAccount("SAV2001", "Priya Singh", 20000, 4.5);
        savings1.displaySavingsAccountDetails();

        System.out.println("\nDepositing ₹5000 into Savings Account...");
        savings1.deposit(5000);
        savings1.displaySavingsAccountDetails();

        System.out.println("\nWithdrawing ₹7000 from Savings Account...");
        savings1.withdraw(7000);
        savings1.displaySavingsAccountDetails();
    }
}
