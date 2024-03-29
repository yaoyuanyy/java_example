package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 基础类
 * <pre>
 * 来自算法4
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-01 at 21:06
 */
public abstract class Example {

    public abstract void sort(Comparable[] a);

    /**
     * 含义：a 小于 b 吗
     * a > b: false; a < b: true;
     * @param a
     * @param b
     * @return
     */
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }


    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
