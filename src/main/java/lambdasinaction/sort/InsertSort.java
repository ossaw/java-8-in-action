package lambdasinaction.sort;

import static lambdasinaction.sort.Util.genArr;
import static lambdasinaction.sort.Util.isArrSorted;

public class InsertSort {
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
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            int cur = arr[i + 1];
            int sortedIdx = i;
            while (sortedIdx >= 0 && cur < arr[sortedIdx])
                arr[sortedIdx + 1] = arr[sortedIdx--];
            arr[sortedIdx + 1] = cur;
        }
    }
}
