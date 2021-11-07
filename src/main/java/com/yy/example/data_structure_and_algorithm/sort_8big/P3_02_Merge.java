package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 归并排序
 * <pre>
 * 核心：将要排序的数组分成两个子数组，对每个子数组进行递归排序，然后将排好序的子数组 组合成一个有序数组
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-28 at 10:24
 */
public class P3_02_Merge extends Example {

    public static void main(String[] args) {

        P3_02_Merge merge = new P3_02_Merge();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        merge.sort(array);
        show(array);
    }

    @Override
    public void sort(Comparable[] a) {
        sort((Integer[]) a, 0, a.length - 1);
    }

    public void sort(Integer[] a, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 2);
        sort(a, l, mid);
        sort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    /**
     * while 的形式
     *
     * @param a
     * @param l
     * @param mid
     * @param r
     */
    private void merge(Integer[] a, int l, int mid, int r) {
        Integer[] help = new Integer[r - l + 1];
        int i = 0;
        // 指定两个指针：分别从两个子数组的左侧开始移动
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = less(a[p1], a[p2]) ? a[p1++] : a[p2++];
        }
        while (p1 <= mid) {
            help[i++] = a[p1++];
        }
        while (p2 <= r) {
            help[i++] = a[p2++];
        }

        for (int k = 0; k < help.length; k++) {
            a[l + k] = help[k];
        }
    }
}
