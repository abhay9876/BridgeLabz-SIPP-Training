package Level2;

public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int quantityToAdd) {
        quantity += quantityToAdd;
        System.out.println(quantityToAdd + " more added to cart.");
    }

    public void removeItem(int quantityToRemove) {
        if (quantityToRemove <= quantity) {
            quantity -= quantityToRemove;
            System.out.println(quantityToRemove + " item(s) removed.");
        } else {
            System.out.println("Not enough quantity to remove.");
        }
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public void displayCartItem() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : ₹" + price);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Total Cost: ₹" + getTotalCost());
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Bluetooth Speaker", 1999.00, 1);
        item.addItem(2);
        item.removeItem(1);
        item.displayCartItem();
    }
}
