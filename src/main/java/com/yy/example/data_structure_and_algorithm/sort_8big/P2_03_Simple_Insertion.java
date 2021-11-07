package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 插入排序 (算法第四版 - P157)
 * <pre>
 * 核心：局部有序，逐步扩大到整个数组。
 *    让待排序元素依次和局部有序数组中的元素比较，如果比局部有序数组中的最后一个元素大，则直接加入局部有序数组中的最后一个
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-27 at 11:32
 */
public class P2_03_Simple_Insertion extends Example {

    public static void main(String[] args) {

        P2_03_Simple_Insertion algorithm = new P2_03_Simple_Insertion();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        algorithm.sort(array);
    }

    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                }
            }
            show(a);
        }
    }
}
