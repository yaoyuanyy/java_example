package com.yy.example.data_structure_and_algorithm.heapsort;

import java.util.Arrays;

/**
 * Description: 我实现的
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/18 at 下午6:27
 */
public class MyHeapSortTmp {

    public static void main(final String[] args) {

        final int[] a = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        System.out.println("Input: " + Arrays.toString(a));
        heapSort(a);
        System.out.println("Output: " + Arrays.toString(a));
    }

    public static void heapSort(final int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            create2XMAXHeap(a, i, a.length);
        }
    }

    /**
     * @param a
     * @param i
     * @param length
     */
    private static void create2XMAXHeap(final int[] a, int i, final int length) {
        int childIdx = 0;
        final int target;
        for (target = a[i]; leftChild(i) < length; ) {
            childIdx = leftChild(i);
            if (childIdx != length - 1 && a[childIdx] < a[childIdx + 1]) {
                childIdx++;
            }

            if (target < a[childIdx]) {
                a[i] = a[childIdx];
            } else {
                break;
            }

            i = childIdx;
        }
        a[i] = target;
    }

    private static int leftChild(final int i) {
        return i * 2 + 1;
    }

    // 交换元素位置
    private static void swap(final int[] a, final int idx1, final int idx2) {
        final int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}
