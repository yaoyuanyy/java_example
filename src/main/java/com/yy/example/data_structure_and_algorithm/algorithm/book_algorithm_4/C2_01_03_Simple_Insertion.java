package com.yy.example.data_structure_and_algorithm.algorithm.book_algorithm_4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 插入排序
 * <pre>
 * 核心：将待排序序列分为两个序列，前一个序列保持有序，依次将后一个序列的元素，按顺序插入到前一个序列
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/23/22 at 10:53 AM
 */
public class C2_01_03_Simple_Insertion extends Example{

    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(less(a[j], a[j - 1])) {
                    System.out.println("移动次数:" + count.incrementAndGet());
                    exch(a, j, j - 1);
                }
            }
            System.out.print("第" + i + "次 ");show(a);
        }
    }

    /**
     * 为快速排序使用
     *
     * @param a
     * @param lo
     * @param hi
     */
    public void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi + 1; i++) {
            for (int j = i; j > lo; j--) {
                if(less(a[j], a[j - 1])) {
                    System.out.println("移动次数:" + count.incrementAndGet());
                    exch(a, j, j - 1);
                }
            }
            System.out.print("第" + i + "次 ");show(a);
        }
    }

    AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        C2_01_03_Simple_Insertion insertion = new C2_01_03_Simple_Insertion();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        System.out.println("insert sort");
        System.out.print("原 值 ");show(array);
        insertion.sort(array);
    }
}
