package com.yy.example.data_structure_and_algorithm.algorithm.algorithm_4;

import java.util.concurrent.CompletableFuture;

/**
 * Description: 快速排序 (切分排序)
 * <pre>
 * 核心：将待排序的数组 n (递归地) 切分为两部分，分别排序，整体自然就有序了
 * 重点：
 * 1.快速排序是递归进行的
 * 2.先切分后递归 (与归并相比)
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/23/22 at 10:53 AM
 */
public class C2_03_00_LogN_Quick extends Example{

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lo, int hi) {
//        if(hi <= lo) {
//            return;
//        }
        // 当是小数组时，使用插入排序
        if(hi <= lo + 3) {
            System.out.print("开始使用插入排序:");
            show(a);
            C2_01_03_Simple_Insertion insertion = new C2_01_03_Simple_Insertion();
            insertion.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // 从左往右找到大于等于 v 的元素的位置
            while (less(a[++i], v)) {
                if(i>=hi) break;
            }

            // 从右往左找到小于等于 v 的元素的位置
            while (less(v, a[--j])) {
                if(j <= lo) break;
            }

            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {

        C2_03_00_LogN_Quick quick = new C2_03_00_LogN_Quick();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        System.out.println("quick sort");
        System.out.print("原 值 ");show(array);
        quick.sort(array);
        show(array);
    }
}
