package InstanceVsClass;

public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000.0; 

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Amit Sharma", "Car");
        Vehicle v2 = new Vehicle("Neha Gupta", "Motorcycle");

        System.out.println("Before Updating Registration Fee:\n");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(6500.0);

        System.out.println("\nAfter Updating Registration Fee:\n");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
