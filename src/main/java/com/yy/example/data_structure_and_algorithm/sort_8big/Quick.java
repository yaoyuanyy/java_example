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
public class Quick extends Example {

    public static void main(String[] args) {

        Quick selection = new Quick();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        selection.sort(array);
    }

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length -1);
    }

    private void sort(Comparable[] a, int low, int high) {
        show(a);
        if(low > high) return;
        int mid = partition(a, low, high);
        sort(a, low, mid - 1);
        sort(a, mid + 1, high);
    }

    private int partition(Comparable[] a, int low, int high) {
        Comparable tmp = a[low];
        int i = low;
        int j = high + 1;

        while (true) {
            while (less(a[++i], tmp)) {
                if(i == high) break;
            }
            while (less(tmp, a[--j])){
                if(j == low) break;
            }

            if(i >= j) break;

            exch(a, i, j);
            show(a);
        }

        System.out.println("最后差一步 j:" + j);
        show(a);
        exch(a, low, j);
        show(a);

        return j;
    }
}
