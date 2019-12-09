package lambdasinaction.sort;

import static lambdasinaction.sort.Util.genArr;
import static lambdasinaction.sort.Util.isArrSorted;

public class QuickSort {
    public static void main(String[] args) {
        test(20, 1000);
    }

    static void test(int arrLength, int testTime) {
        for (int i = 0; i < testTime; i++) {
            int[] arr = genArr(arrLength);
            sort(arr);
            if (!isArrSorted(arr))
                throw new RuntimeException();
        }
    }

    private static void sort(int[] arr) {
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
        int l = low, h = high, idx = arr[l];
        while (l < h) {
            while (l < h && idx <= arr[h])
                h--;
            if (l < h)
                arr[l++] = arr[h];
            while (l < h && idx > arr[l])
                l++;
            if (l < h)
                arr[h--] = arr[l];
        }
        arr[l] = idx;
        return l;
    }
}
