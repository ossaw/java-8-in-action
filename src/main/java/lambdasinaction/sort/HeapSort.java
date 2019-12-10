package lambdasinaction.sort;

import static lambdasinaction.sort.Util.genArr;
import static lambdasinaction.sort.Util.isArrSorted;
import static lambdasinaction.sort.Util.swap;

public class HeapSort {
    public static void main(String[] args) {
        test(20, 10000);
    }

    private static void test(int arrLength, int testTime) {
        for (int i = 0; i < testTime; i++) {
            int[] arr = genArr(arrLength);
            sort(arr);
            if (!isArrSorted(arr))
                throw new RuntimeException();
        }
    }

    private static void sort(int[] array) {
        if (array == null || array.length <= 1)
            return;

        int len = array.length;
        // 1.构建一个最大堆
        buildMaxHeap(array, len);
        // 2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            adjustHeap(array, 0, --len);
        }
    }

    private static void buildMaxHeap(int[] array, int len) {
        // 从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len / 2 - 1); i >= 0; i--)
            adjustHeap(array, i, len);
    }

    private static void adjustHeap(int[] array, int i, int len) {
        int maxIndex = i;
        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex, len);
        }
    }
}
