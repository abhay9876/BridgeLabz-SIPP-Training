import java.util.*;
import java.util.stream.Collectors;

public class EmployeeHR {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Abhay", "Rohit", "Meera", "Sonal");

        
        List<String> uppercased = employees.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());

        uppercased.forEach(System.out::println);
    }
}
