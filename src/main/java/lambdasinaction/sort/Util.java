package lambdasinaction.sort;

import java.util.Arrays;
import java.util.Random;

public final class Util {
    private static final Random random = new Random();

    private Util() {
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

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
