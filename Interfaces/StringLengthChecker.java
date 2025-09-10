import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> lengthFunc = str -> str.length();

        String msg = "Hello Functional Interfaces!";
        int length = lengthFunc.apply(msg);

        System.out.println("Message length: " + length);
        System.out.println("Exceeds 20 chars : " + (length > 20));
    }
}
