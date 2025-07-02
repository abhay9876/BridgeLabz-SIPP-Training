package HybridInheritance;

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void performDuties() {
        System.out.println("Chef " + name + " is cooking " + specialty + " dishes.");
    }
}

class Waiter extends Person implements Worker {
    String assignedSection;

    Waiter(String name, int id, String assignedSection) {
        super(name, id);
        this.assignedSection = assignedSection;
    }

    public void performDuties() {
        System.out.println("Waiter " + name + " is serving tables in section " + assignedSection + ".");
    }
}

public class ResturantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Rahul", 101, "Italian");
        Waiter waiter = new Waiter("Amit", 202, "Outdoor Patio");

        chef.performDuties();
        waiter.performDuties();
    }
}
