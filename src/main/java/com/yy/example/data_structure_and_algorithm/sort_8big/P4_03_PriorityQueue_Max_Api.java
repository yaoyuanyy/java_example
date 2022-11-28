package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 优先队列 api 结构
 * <pre>
 * 此处以最大优先队列为例。两种类型：最大优先队列 or 最小优先队列
 * 优先队列有两个主要的操作：
 * 1. 插入元素 insert(key)
 * 2. 删除最大元素 delMax()
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 5/27/22 at 10:00 AM
 */
public interface P4_03_PriorityQueue_Max_Api<E> {
//      构造方法
//    C2_04_00_MaxPQ_Api();
//    C2_04_00_MaxPQ_Api(int max);
//    C2_04_00_MaxPQ_Api(E[] arr);

    void insert(E key);

    /**
     * 返回最大值
     *
     * @return
     */
    E max();

    /**
     * 删除并返回最大值
     *
     * @return
     */
    E delMax();

    boolean isEmpty();

    int size();
}
