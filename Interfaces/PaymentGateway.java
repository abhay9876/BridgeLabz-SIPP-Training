interface PaymentProcessor {
    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refund of " + amount + " processed (default).");
    }
}

class PayPal implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via PayPal.");
    }
}

class Stripe implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Stripe.");
    }
    public void refund(double amount) {
        System.out.println("Stripe refund of " + amount + " completed.");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPal();
        PaymentProcessor stripe = new Stripe();

        paypal.pay(500);
        paypal.refund(200);

        stripe.pay(1000);
        stripe.refund(300);
    }
}
