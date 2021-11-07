package com.yy.example.java.queue.priority_block_queue;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Description:
 * <pre>
 *     {@link PriorityQueue}的源码调试的例子，及通过源码学习堆排序的实现源码和代码实现
 *     eg:
 *     int[] heap = {23, 45, 2, 6, 55, 90, 23, 4, 5};
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-06-28 at 14:50
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue( 9);
        priorityQueue.add(23);
        priorityQueue.add(45);
        priorityQueue.add(2);
        priorityQueue.add(6);
        priorityQueue.add(55);
        priorityQueue.add(90);
        priorityQueue.add(23);
        priorityQueue.add(4);
        priorityQueue.add(5);

        outPretty(priorityQueue);

        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("value:" + value);
        }
    }

    private static void outPretty(PriorityQueue<Integer> priorityQueue) {
        Integer[] array = priorityQueue.toArray(new Integer[priorityQueue.size()]);
         for (int i = 0; i < array.length; i++) {
            System.out.println("");
        }
    }
}
