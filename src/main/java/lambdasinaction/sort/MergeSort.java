package lambdasinaction.sort;

import static lambdasinaction.sort.Util.genArr;
import static lambdasinaction.sort.Util.isArrSorted;

public class MergeSort {
    public static void main(String[] args) {
        test(3, 1);
    }

    private static void test(int arrLength, int testTime) {
        for (int i = 0; i < testTime; i++) {
            int[] arr = genArr(arrLength);
            sort(arr);
            if (!isArrSorted(arr))
                throw new RuntimeException();
        }
    }

    public static void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, 0, arr.length - 1, tmp);
    }

    private static void sort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, tmp);
            sort(arr, mid + 1, right, tmp);
            merge(arr, left, mid, right, tmp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right)
            if (arr[i] <= arr[j])
                tmp[t++] = arr[i++];
            else
                tmp[t++] = arr[j++];
        while (i <= mid)
            tmp[t++] = arr[i++];
        while (j <= right)
            tmp[t++] = arr[j++];

        for (int k = 0; left <= right; k++)
            arr[left++] = tmp[k];
    }
}