package AccessModifier;

public class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
    }
}

class Manager extends Employee {
    String teamName;

    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    public void displayManagerDetails() {
        System.out.println("Manager ID: " + employeeID);          
        System.out.println("Department: " + department);         
        System.out.println("Salary: ₹" + getSalary());            
        System.out.println("Team Name: " + teamName);
    }
}

class Employees {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Finance", 45000);
        emp1.displayEmployeeDetails();

        System.out.println();

        Manager mgr1 = new Manager(201, "IT", 80000, "Development");
        mgr1.displayManagerDetails();

        System.out.println("\nUpdating Manager Salary...");
        mgr1.setSalary(90000);
        mgr1.displayManagerDetails();
    }
}
