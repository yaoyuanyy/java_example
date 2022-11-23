package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-10-17 at 09:59
 */
public class P3_03_Quick extends Example {

    public static void main(String[] args) {

        P3_03_Quick quick = new P3_03_Quick();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        quick.sort(array);
        show(array);
    }

    @Override
    public void sort(Comparable[] a) {
        sort((Integer[]) a, 0, a.length - 1);
    }

    private void sort(Integer[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Integer[] a, int lo, int hi) {
        // 指定两个指针：分别从数组的左右两侧相向移动
        int p1 = lo;
        int p2 = hi + 1;
        Integer v = a[lo];
        // p1 指针向右走，p2 指针向左走
        while (true) {
            // 找到大于v的 那个元素下标
            while (less(a[++p1], v)) if(p1 == hi) break;
            // 找到小于v的 那个元素下标
            while (less(v, a[--p2])) if(p2 == lo) break;
            if(p1 >= p2) break;
            exch(a, p1, p2);
        }
        exch(a, lo, p2);

        return p2;
    }
}
