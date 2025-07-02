package MultiLevelInheritance;



class Order {
	String orderId;
	String orderDate;
	
	Order(String orderId, String orderDate){
		this.orderId= orderId;
		this.orderDate= orderDate;
	}
	
	void getOrderStatus() {
		System.out.println("Order Placed !!!");
	}
}

class ShippedOrder extends Order{
	String trackingNumber;
	 
	ShippedOrder(String orderId, String orderDate,String trackingNumber ){
		super(orderId , orderDate);
		this.trackingNumber = trackingNumber;
	}
	
	void getOrderStatus() {
		System.out.println("Order Shipped !  " +"Tracking Number :"+ trackingNumber );
	}
}

class  DeliveredOrder extends ShippedOrder {
	String deliveryDate;
	
	DeliveredOrder(String orderId, String orderDate,String trackingNumber,String deliveryDate){
		super(orderId,orderDate,trackingNumber);
		this.deliveryDate=deliveryDate;
		
	}
	
	void getOrderStatus() {
		System.out.println("Order delivered on: "+ deliveryDate);
	}
	
	
	
	
}
public class OnlineRetailOrderManagement {
        public static void main(String[] args) {
        	Order order = new Order("as342","25-06-2025");
        	order.getOrderStatus();
        	
        	ShippedOrder shipped  = new ShippedOrder("as342","25-06-2025","123456987");
        	shipped.getOrderStatus();
        	
        	DeliveredOrder d = new DeliveredOrder("as342","25-06-2025","123456987", "2025-07-03");
        	d.getOrderStatus();
        	
        }
}
