package com.yy.example.data_structure_and_algorithm.algorithm.book_algorithm_4;

import java.util.PriorityQueue;

/**
 * Description:
 * <pre>
 * 测试 PriotiryQueue默认的顺序是从大到小 or 从小到大
 *
 * 结论：默认是从小到大
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/29/22 at 10:09 AM
 */
public class C2_04_01_PriotiryQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        priorityQueue.add(50);
        priorityQueue.add(30);
        priorityQueue.add(60);
        priorityQueue.add(90);
        priorityQueue.add(10);
        priorityQueue.add(20);

        int size = priorityQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println("value:" + priorityQueue.poll());
        }
    }
}
