package lambdasinaction.sort;

import static lambdasinaction.sort.Util.genArr;
import static lambdasinaction.sort.Util.isArrSorted;
import static lambdasinaction.sort.Util.swap;

public class SelectSort {
    public static void main(String[] args) {
        test(20, 1000);
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
        if (arr == null || arr.length == 0)
            return;

        for (int i = 0; i < arr.length; i++) {
            int minValIdx = i;
            for (int j = i; j < arr.length; j++)
                if (arr[minValIdx] > arr[j])
                    minValIdx = j;
            swap(arr, minValIdx, i);
        }
    }
}
