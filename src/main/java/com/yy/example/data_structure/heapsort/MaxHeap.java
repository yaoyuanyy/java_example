package com.yy.example.data_structure.heapsort;

import java.util.Arrays;

/**
 * Description: 堆排序
 * <p>
 * 参考：https://www.cnblogs.com/jetpie/p/3971382.html
 * 辅助参考：
 * http://blog.csdn.net/jianyuerensheng/article/details/51263453
 * http://blog.51cto.com/mushiqianmeng/738164
 * http://vickyqi.com/2015/08/14/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E7%B3%BB%E5%88%97%E2%80%94%E2%80%94%E5%A0%86%E6%8E%92%E5%BA%8F/
 * <p>
 * </p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/21 at 下午3:17
 */
public class MaxHeap {

    protected double A[];
    protected int heapsize;

    //constructors
    public MaxHeap() {
    }

    public MaxHeap(final double[] A) {
        buildMaxHeap(A);
    }

    //构造一个“最大堆”
    public void buildMaxHeap(final double[] A) {
        this.A = A;
        this.heapsize = A.length;

        for (int i = parent(heapsize - 1); i >= 0; i--)
            maxHeapify(i);
    }

    protected void maxHeapify(final int i) {
        final int l = left(i);
        final int r = right(i);
        int largest = i;
        if (l <= heapsize - 1 && A[l] > A[i])
            largest = l;
        if (r <= heapsize - 1 && A[r] > A[largest])
            largest = r;
        if (largest != i) {
            final double temp = A[i];
            // swap
            A[i] = A[largest];
            A[largest] = temp;
            this.maxHeapify(largest);
        }
    }

    // 对一个array使用heapsort，也就是打印出每步的排序轨迹
    public void heapsort(final double[] A) {
        buildMaxHeap(A);

        //打印排序轨迹
        int step = 1;
        for (int i = A.length - 1; i > 0; i--) {
            final double temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            heapsize--;
            System.out.println("Step: " + (step++) + Arrays.toString(A));
            maxHeapify(0);
        }
    }

    protected int parent(final int i) {
        return (i - 1) / 2;
    }

    protected int left(final int i) {
        return 2 * i + 1;
    }

    protected int right(final int i) {
        return 2 * i + 2;
    }

    public static void main(final String[] args) {
        //a sample input
        final double[] A = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        System.out.println("Input: " + Arrays.toString(A));
        final MaxHeap maxhp = new MaxHeap();
        maxhp.heapsort(A);
        System.out.println("Output: " + Arrays.toString(A));

    }
}
