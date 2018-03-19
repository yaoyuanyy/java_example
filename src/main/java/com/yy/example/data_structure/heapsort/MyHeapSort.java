package com.yy.example.data_structure.heapsort;

import java.util.Arrays;

/**
 * Description: 我实现的
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/18 at 下午6:27
 */
public class MyHeapSort {

    public static void main(final String[] args) {

        final int[] a = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        System.out.println("Input: " + Arrays.toString(a));
        heapSort(a);
        System.out.println("Output: " + Arrays.toString(a));
    }

    public static void heapSort(final int[] a) {
        // 构造一个大顶堆
        for (int i=a.length / 2; i>=0; i--) {
            create2XMAXHeap(a, i, a.length);
            //create2XMINHeap(a, i, a.length);
        }

        for (int i = a.length-1 ; i>=0; i--){
            swap(a, 0, i);
            create2XMAXHeap(a, 0, i);
            //create2XMINHeap(a, 0, i);
        }
    }

    /**
     * @param a
     * @param i
     * @param length
     */
    private static void create2XMAXHeap(final int[] a, int i, final int length) {
        int child = 0;
        int target;
        for(target = a[i];leftChild(i)<length; i = child){
            child = leftChild(i);
            if (child != length - 1 && a[child] < a[child + 1]) {
                child ++;
            }

            if(target < a[child]) {
                a[i] = a[child];
            }else {
                break;
            }
        }
        a[i] = target;

    }

    private static void create2XMINHeap(final int[] a, int i, final int length) {
        int child = 0;
        int target;
        for(target = a[i]; leftChild(i)<length; i = child) {
            child = leftChild(i);
            if(child != length - 1 && a[child] > a[child+1]) {
                child ++;
            }

            if(target > a[child]) {
                a[i] = a[child];
            }else {
                break;
            }
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
