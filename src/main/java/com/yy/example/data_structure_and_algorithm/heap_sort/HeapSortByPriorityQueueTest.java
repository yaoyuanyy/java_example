package com.yy.example.data_structure_and_algorithm.heap_sort;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-06-29 at 09:48
 */
public class HeapSortByPriorityQueueTest {

    public static void main(String[] args) {
        int[] heap = {23, 45, 2, 6, 55, 90, 23, 4, 5};

        //-------- 获取最大的top k的数字 --------
        TopKPriorityQueue topKOfBig = new TopKPriorityQueue(3, true);
        for (int value : heap) {
            topKOfBig.buildSmallHeap(value);
        }
        topKOfBig.out();
        //-------- 获取最大的top k的数字 --------

        //-------- 获取最小的top k的数字 --------
        TopKPriorityQueue topKOfSmall = new TopKPriorityQueue(3, false);
        for (int value : heap) {
            topKOfSmall.buildBigHeap(value);
        }
        topKOfSmall.out();
        //-------- 获取最小的top k的数字 --------


    }
}
