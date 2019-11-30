package lambdasinaction.sort;

import static lambdasinaction.sort.Util.genArr;
import static lambdasinaction.sort.Util.isArrSorted;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        test(10, 1000);
    }

    private static void test(int arrLength, int testTime) {
        for (int i = 0; i < testTime; i++) {
            int[] arr = genArr(arrLength);
            if (!isArrSorted(sort(arr)))
                throw new RuntimeException();
        }
    }

    private static int[] sort(int[] array) {
        if (array.length < 2)
            return array;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

}
