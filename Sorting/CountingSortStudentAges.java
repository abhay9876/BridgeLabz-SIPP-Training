
public class CountingSortStudentAges {
    public static void countingSort(int[] arr, int maxAge) {
        int[] count = new int[maxAge + 1];
        for (int age : arr)
            count[age]++;
        int index = 0;
        for (int i = 0; i <= maxAge; i++) {
            while (count[i]-- > 0)
                arr[index++] = i;
        }
    }
}
