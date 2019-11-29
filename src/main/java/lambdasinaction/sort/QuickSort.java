package lambdasinaction.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] arr = genArr(10);
        printArr(arr);
        sort(arr);
        printArr(arr);
        System.out.println(isArrSorted(arr));
    }

    static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 1 || low < 0 || low > high)
            return;
        int p = partition(arr, low, high);

        sort(arr, low, p - 1);
        sort(arr, p + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low, j = high, index = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= index)
                j--;
            if (i < j)
                arr[i++] = arr[j];
            while (i < j && arr[i] < index)
                i++;
            if (i < j)
                arr[j--] = arr[i];
        }
        arr[i] = index;
        return i;
    }

    static int[] genArr(int length) {
        if (length <= 0)
            throw new IllegalArgumentException();

        int[] result = new int[length];
        for (int i = 0; i < result.length; i++)
            result[i] = random.nextInt(100);
        return result;
    }

    static boolean isArrSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException();
        if (arr.length == 1)
            return true;

        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }

    static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
