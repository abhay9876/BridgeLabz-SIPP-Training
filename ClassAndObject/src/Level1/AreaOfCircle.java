package Level1;

public class AreaOfCircle {
    // Attribute
    private double radius;

    // Constructor
    public AreaOfCircle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Display method
    public void displayDetails() {
        System.out.println("Circle Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    // Main method
    public static void main(String[] args) {
    	AreaOfCircle circle = new AreaOfCircle(5.5); // Example radius
        circle.displayDetails();
    }
}
