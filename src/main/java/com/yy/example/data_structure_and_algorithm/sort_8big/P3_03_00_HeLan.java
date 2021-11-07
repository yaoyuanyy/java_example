package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description:
 * <pre>
 *  一个数组arr，一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。
 *  要求空间复杂度O(1)，时间复杂度O(n)
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-10-17 at 14:32
 */
public class P3_03_00_HeLan {

    public static void main(String[] args) {
        int[] array = new int[]{20, 30, 90, 60, 40, 50, 70, 10};
        sort(array, 60);
        show(array);
    }

    private static void sort(int[] array, int num) {
        int p1 = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= num) {
                exch(array, i, p1);
                p1++;
            }
        }
    }

    public static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
