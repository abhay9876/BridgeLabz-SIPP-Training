import java.io.*;

class Employee implements Serializable {
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class DataSerialization {
    public static void main(String[] args) {
        Employee emp = new Employee("Abhay", 25);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("backup.ser"))) {
            out.writeObject(emp);
            System.out.println("Backup created.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
