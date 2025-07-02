package HybridInheritance;

class Vehicle {
    String model;
    int maxSpeed;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println("Charging electric vehicle " + model + " with capacity " + batteryCapacity + " kWh.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelCapacity;

    PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    public void refuel() {
        System.out.println("Refueling petrol vehicle " + model + " with " + fuelCapacity + " liters.");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 250, 75);
        PetrolVehicle honda = new PetrolVehicle("Honda City", 180, 40);

        tesla.charge();
        honda.refuel();
    }
}

