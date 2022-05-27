package com.yy.example.data_structure_and_algorithm.algorithm.algorithm_4;

/**
 * Description: 优先队列 api 结构
 * 两种类型：最大优先队列 or 最小优先队列
 * <pre>
 * NOTE: 此处以最小优先队列为例
 * 优先队列有两个主要的功能：
 * 1. 删除最小元素 delMin()
 * 2. 插入元素 insert(key)
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/27/22 at 10:00 AM
 */
public interface C2_04_00_MinPQ_Api<E> extends Comparable<E> {
//      构造方法
//    C2_04_00_MaxPQ_Api();
//    C2_04_00_MaxPQ_Api(int max);
//    C2_04_00_MaxPQ_Api(E[] arr);

    void insert(E key);

    /**
     * 返回最大值
     * @return
     */
    E min();

    /**
     * 删除并返回最大值
     * @return
     */
    E delMin();

    boolean isEmpty();

    int size();
}
