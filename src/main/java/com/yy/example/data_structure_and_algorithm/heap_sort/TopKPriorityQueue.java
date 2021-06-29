package com.yy.example.data_structure_and_algorithm.heap_sort;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-06-29 at 19:37
 */
public class TopKPriorityQueue {

    private PriorityQueue<Integer> priorityQueue;
    private int k_size;

    /**
     * PriorityQueue默认实现的小顶堆
     *
     * 最小的top k的数字: 大顶堆; 最大的top k的数字：小顶堆
     * bigOrSmall big:true; small:false 默认是true 大顶堆：即正序(从小到大)
     * @param k_size
     * @param bigOrSmall
     */
    public TopKPriorityQueue(int k_size, boolean bigOrSmall) {
        this.k_size = k_size;
        if(bigOrSmall) {
            this.priorityQueue = new PriorityQueue<>(k_size);
        }else {
            this.priorityQueue = new PriorityQueue<>(k_size, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
    }

    /**
     * 获取最小的top k的数字
     * @param key
     */
    public void buildBigHeap(int key){
        if(priorityQueue.size() < k_size){
            priorityQueue.offer(key);
        }else {
            if(priorityQueue.peek() > key) {
                priorityQueue.poll();
                priorityQueue.offer(key);
            }
        }
    }

    /**
     * 获取最大的top k的数字
     * @param key
     */
    public void buildSmallHeap(int key){

        if(priorityQueue.size() < k_size){
            priorityQueue.offer(key);
        }else {
            // 对顶元素
            if(priorityQueue.peek() < key) {
                priorityQueue.poll();
                priorityQueue.offer(key);
            }
        }
    }

    public void out() {
        // 这种情况不保证顺序
        priorityQueue.forEach(o -> System.out.println(o));
    }

    public void outPretty() {
        // 这种情况不保证顺序
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
    }

}
