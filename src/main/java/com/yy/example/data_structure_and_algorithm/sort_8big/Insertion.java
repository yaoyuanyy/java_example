package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 插入排序 (算法第四版 - P157)
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-01 at 21:16
 */
public class Insertion extends Example {

    public static void main(String[] args) {

        Insertion selection = new Insertion();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        selection.sort(array);
    }

    @Override
    public void sort(Comparable[] a) {
        show(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                show(a);
            }
            //show(a);
        }
    }
}
