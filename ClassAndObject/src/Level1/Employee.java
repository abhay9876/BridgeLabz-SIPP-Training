package Level1;

public class Employee{ 
   
	
	private String name;
	private int id;
	private int salary;
	
	public Employee(String name,int id , int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	
	public void displayDetails() {
		System.out.println("Employee Name :"+ name);
		System.out.println("Employee id :"+ id);
		System.out.println("Employee Salary :"+ salary);
		
	}
	
	public static void main(String[] args) {
		Employee emp = new Employee("Abhay",123,100000000);
		emp.displayDetails();
	}
}
