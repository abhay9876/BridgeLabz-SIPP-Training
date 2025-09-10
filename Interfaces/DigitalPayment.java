interface Payment{
    void pay();
}

class Upi implements Payment{
     public void pay(){
        System.out.println("Payment Complete through UPI !");
     }
}

class CreditCard implements Payment{
    public void pay(){
        System.out.println("Payment Complete thorugh CreditCard !");
     }
}
class Wallet implements Payment{
    public void pay(){
        System.out.println("Payment Complete through Wallet !");
     }
}


public class DigitalPayment {
     public static void main(String[] args) {
        Upi upi = new Upi();
        CreditCard cc = new CreditCard();
        Wallet wallet = new Wallet();


        upi.pay();
        cc.pay();
        wallet.pay();
     }
}
