import java.util.function.Predicate;

class TemperatureAlert{
    public static void main(String[] args) {
        Predicate<Double> predict = (t)->t >40.0;
        double temp1 = 30.0;
        double temp2 = 48.2;

        System.out.println("Temperature Alert : "+ predict.test(temp1));
        System.out.println("Temperature Alert : "+ predict.test(temp2));
    }
}