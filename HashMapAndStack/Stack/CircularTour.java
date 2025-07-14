package stack_problems;
import java.util.*;

class PetrolPump {
    int petrol, distance;

    PetrolPump(int p, int d) {
        petrol = p;
        distance = d;
    }
}

public class CircularTour {
    public static int findStartingPoint(PetrolPump[] pumps) {
        int total = 0, balance = 0, start = 0;
        for (int i = 0; i < pumps.length; i++) {
            balance += pumps[i].petrol - pumps[i].distance;
            total += pumps[i].petrol - pumps[i].distance;
            if (balance < 0) {
                start = i + 1;
                balance = 0;
            }
        }
        return (total >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        System.out.println(findStartingPoint(pumps));
    }
}