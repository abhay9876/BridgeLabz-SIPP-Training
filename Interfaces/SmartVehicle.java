interface Vehicle {
    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery info not available for this vehicle.");
    }
}

class Car implements Vehicle {
    public void displaySpeed() {
        System.out.println("Car speed: 80 km/h");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Electric Car speed: 60 km/h");
    }
    public void displayBattery() {
        System.out.println("Battery: 75%");
    }
}

public class SmartVehicle {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle eCar = new ElectricCar();

        car.displaySpeed();
        car.displayBattery();

        eCar.displaySpeed();
        eCar.displayBattery();
    }
}
