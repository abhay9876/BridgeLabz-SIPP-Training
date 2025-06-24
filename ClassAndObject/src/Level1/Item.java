package Level1;

public class Item {
     private int itemCode;
     private String itemName;
     private int price;
     
     public Item(int itemCode , String itemName , int price) {
    	 this.itemCode = itemCode;
    	 this.itemName = itemName;
    	 this.price = price;
    	 
     }
     
     
     public void displayDetails() {
    	 System.out.println("Item Code : " + itemCode);
         System.out.println("Item Name : " + itemName);
         System.out.println("Price     : ₹" + price);

     }
     
     public double calculateTotalCost(int quantity) {
         return price * quantity;
     }
     
     public static void main(String[] args) {
    	 Item item1 = new Item(123,"Gla",1000);
    	 System.out.println("item  Detail :");
    	 item1.displayDetails();
    	 
    	 
    	 int quantity = 3;
    	 System.out.println("Total cost for quantity:"+quantity);
    	 System.out.println(item1.calculateTotalCost(quantity));
     }
}
