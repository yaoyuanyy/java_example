package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description:
 * <pre>
 * 核心：找出大的数往后移
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-23 at 07:40
 */
public class P2_01_Simple_MaoPao extends Example {

    public static void main(String[] args) {

        P2_01_Simple_MaoPao algorithm = new P2_01_Simple_MaoPao();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        algorithm.sort(array);
    }

    @Override
    public void sort(Comparable[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                }
            }
            // 一次遍历后的结果
            show(a);
        }
        show(a);
    }
}
