public class SearchComparison {
    public static boolean linearSearch(int[] arr, int target) {
        for (int i : arr) if (i == target) return true;
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        java.util.Arrays.sort(arr);
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data = new int[1000000];
        for (int i = 0; i < data.length; i++) data[i] = i;
        System.out.println("Linear Search: " + linearSearch(data, 999999));
        System.out.println("Binary Search: " + binarySearch(data, 999999));
    }
}