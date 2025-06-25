package Level1;
public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    static final double DAILY_RATE = 1500.0; 

    public CarRental() {
        this("Unknown", "Standard", 1);
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental defaultRental = new CarRental();
        CarRental customRental = new CarRental("Ravi Kumar", "Hyundai Creta", 5);

        System.out.println("Default Rental:");
        defaultRental.displayRentalDetails();

        System.out.println("\nCustom Rental:");
        customRental.displayRentalDetails();
    }
}
