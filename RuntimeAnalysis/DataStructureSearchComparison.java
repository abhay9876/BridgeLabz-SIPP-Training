import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        int target = 999999;

        long start = System.currentTimeMillis();
        for (int i : array) if (i == target) break;
        System.out.println("Array search: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        hashSet.contains(target);
        System.out.println("HashSet search: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        treeSet.contains(target);
        System.out.println("TreeSet search: " + (System.currentTimeMillis() - start) + "ms");
    }
}