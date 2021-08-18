package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 选择排序 (算法第四版 - P156)
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-01 at 21:16
 */
public class Selection extends Example {

    public static void main(String[] args) {

        Selection selection = new Selection();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        selection.sort(array);
    }

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if(less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
            show(a);
        }
    }
}
