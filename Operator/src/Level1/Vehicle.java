// Vehicle.java
// Sample Program 6: Vehicle Registration System
// Demonstrates static, this, final, and instanceof best practices
package Level1;

public class Vehicle {
    private static double registrationFee = 5000.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Amit", "Car", "MH12AB1234");
        Object obj = vehicle1;
        if (obj instanceof Vehicle) {
            ((Vehicle) obj).displayDetails();
        }
        Vehicle.updateRegistrationFee(6000.0);
        System.out.println("Updated Registration Fee: " + registrationFee);
    }
}
