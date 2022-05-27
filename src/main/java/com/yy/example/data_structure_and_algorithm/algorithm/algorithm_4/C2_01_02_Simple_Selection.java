package com.yy.example.data_structure_and_algorithm.algorithm.algorithm_4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 选择排序
 * <pre>
 * 选择最小的放在数组的第一个位置，选择第二小的放在数组第二个位置，依次类推
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/23/22 at 10:29 AM
 */
public class C2_01_02_Simple_Selection extends Example {

    @Override
    public void sort(Comparable[] a) {
        // 外循环为交换的位置
        for (int i = 0; i < a.length; i++) {
            // 内循环为比较的位置：选出最小的元素
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if(less(a[j], a[min])) {
                    min = j;
                }
            }
            System.out.println("移动次数:" + count.incrementAndGet());
            exch(a, i , min);
            // 辅助方法，便于查看交换过程
            show(a);
        }
        show(a);
    }

    AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        C2_01_02_Simple_Selection selection = new C2_01_02_Simple_Selection();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        selection.sort(array);
    }
}
