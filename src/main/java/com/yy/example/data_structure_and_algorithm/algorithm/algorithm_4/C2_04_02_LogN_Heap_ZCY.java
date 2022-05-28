package com.yy.example.data_structure_and_algorithm.algorithm.algorithm_4;

/**
 * Description: 堆排序
 * 来自左程云算法视频
 * k从0开始
 * 所以：左子节点为 2k+1：右子节点为 2k+2；父节点为 (k-1)/2
 *
 * <pre>
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/27/22 at 10:20 AM
 */
public class C2_04_02_LogN_Heap_ZCY extends Example {

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        // 堆的构造
        for (int i = 0; i < n; i++) {
            swim(a, i);
        }

        exch(a, 0, --n);
        // 下沉排序: 不断的队列的最大值位置与最后最后一个位置的元素互换
        while (n > 0) {
            sink(a, 0, n);
            n--;
            exch(a, 0 , n);
        }
    }

    /**
     * 上浮：i 不断的上移
     * 将 i 位置的元素，往上移动
     * @param a
     * @param i
     */
    private void swim(Comparable[] a, int i) {
        while (less(a[(i - 1)/2], a[i])) {
            // 互换
            exch(a, i, (i - 1)/2);
            i = (i - 1) / 2;
        }
    }

    private void sink(Comparable[] a, int i, int n) {
        while ((2*i+1) <= n) {
            int tmp = 2 * i + 1;
            if(tmp < n && less(a[tmp], a[tmp + 1])) {
                tmp++;
            }
            if(tmp >= n || !less(a[i], a[tmp])) {
                break;
            }
            exch(a, i, tmp);
            i = tmp;
        }
    }

    public static void main(String[] args) {

        C2_04_02_LogN_Heap_ZCY heap = new C2_04_02_LogN_Heap_ZCY();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        heap.sort(array);
        show(array);
        System.out.println("C2_04_02_LogN_Heap_ZCY 数组递增吗：" + heap.isSorted(array));
    }
}
