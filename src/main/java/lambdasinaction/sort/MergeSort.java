package lambdasinaction.sort;

import static lambdasinaction.sort.Util.genArr;
import static lambdasinaction.sort.Util.isArrSorted;

public class MergeSort {
    public static void main(String[] args) {
        test(30, 1000);
    }

    private static void test(int arrLength, int testTime) {
        for (int i = 0; i < testTime; i++) {
            int[] arr = genArr(arrLength);
            sort(arr);
            if (!isArrSorted(arr))
                throw new RuntimeException();
        }
    }

    private static void sort(int[] arr) {
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
        int i = 0, l = left, m = mid + 1;
        while (l <= mid && m <= right)
            if (arr[l] <= arr[m])
                tmp[i++] = arr[l++];
            else
                tmp[i++] = arr[m++];
        while (l <= mid)
            tmp[i++] = arr[l++];
        while (m <= right)
            tmp[i++] = arr[m++];

        for (int j = 0; left <= right; j++)
            arr[left++] = tmp[j];
    }
}