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
public class P3_03_01_HeLan {

    /**
     * https://static.kancloud.cn/mangomei/deepstudy/2762747
     * https://github.com/three-body-zhangbeihai/java-summary/blob/master/%E7%AE%97%E6%B3%95%E5%92%8C%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95/8.%E8%8D%B7%E5%85%B0%E5%9B%BD%E6%97%97%E9%97%AE%E9%A2%98.md
     * @param array
     * @param num
     */
    private static void sort(int[] array, int num) {
        // 定义小于区域的下标，也可理解为区域的右边界指针
        int p1 = 0;
        // i 为指针
        for (int i = 0; i < array.length; i++) {
            // 目标区域右移，i 指针右移
            if (array[i] < num) {
                exch(array, i, p1);
                p1++;
            }
        }
    }

    private static void sort2(int[] array, int num) {
        int i = 0;
        int j = array.length - 1;

        while (i <= j) {
            while (i < j && array[i] < num) {
                i++;
            }
            while (j > i && array[j] > num) {
                j--;
            }
            exch(array, i, j);
            if (i >= j) {
                break;
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

    public static void main(String[] args) {
        int[] array = new int[]{20, 30, 90, 60, 40, 50, 70, 10};
        sort(array, 60);
        show(array);
    }
}
