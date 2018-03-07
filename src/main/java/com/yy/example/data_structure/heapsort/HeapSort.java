package com.yy.example.data_structure.heapsort;

import java.util.Arrays;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/18 at 下午6:27
 */
public class HeapSort {

    public static void main(final String[] args) {

        final int[] a = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        System.out.println("Input: " + Arrays.toString(a));
        heapSort(a);
        System.out.println("Output: " + Arrays.toString(a));
    }

    public static void heapSort(final int[] a) {

        for (int i = a.length / 2; i >= 0; i--) {
            create2XMAXHeap(a, i, a.length);
            //create2XMINHeap(a, i, a.length);
        }

        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            create2XMAXHeap(a, 0, i);
        }
    }

    /**
     * 结果：
     * <pre>
     *                      0
     *                2           2
     *            3       3   4       9
     *         11   18  7
     * </pre>
     *
     * @param a
     * @param i
     * @param length
     */
    private static void create2XMAXHeap(final int[] a, int i, final int length) {
        int child;
        final int father;
        for (father = a[i]; leftChild(i) < length; i = child) {
            child = leftChild(i);
            System.out.println();
            if (child != length - 1 && a[child] < a[child + 1]) {
                child++;
            }
            if (father < a[child]) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = father;
    }

    private static void create2XMINHeap(final int[] a, int i, final int length) {
        int child;
        final int father;
        for (father = a[i]; leftChild(i) < length; i = child) {
            child = leftChild(i);
            System.out.println();
            if (child != length - 1 && a[child] > a[child + 1]) {
                child++;
            }
            if (father > a[child]) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = father;
    }

    public static int leftChild(final int i) {
        return i * 2 + 1;
    }

    // 交换元素位置
    private static void swap(final int[] a, final int index1, final int index2) {
        final int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
}
