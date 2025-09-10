class Product implements Cloneable {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ClonePrototype {
    public static void main(String[] args) {
        try {
            Product p1 = new Product("Laptop", 50000);
            Product p2 = (Product) p1.clone();
            System.out.println("Cloned Product: " + p2.name + " - " + p2.price);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
