
public class BubbleSortStudentMarks {
    public static void bubbleSort(int[] arr) {
        boolean swapped;
        int n = arr.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
