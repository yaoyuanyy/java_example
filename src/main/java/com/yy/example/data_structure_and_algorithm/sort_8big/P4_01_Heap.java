package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 11/24/22 at 12:01 PM
 */
public class P4_01_Heap extends Example{

    @Override
    public void sort(Comparable[] array) {

    }

    public static void main(String[] args) {
        P4_01_Heap heap = new P4_01_Heap();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        heap.sort(array);
        show(array);
    }


}
