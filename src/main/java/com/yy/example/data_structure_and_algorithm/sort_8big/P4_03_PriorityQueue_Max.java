package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 二叉堆 应用1 - 优先队列
 * <pre>
 *
 *
 * https://labuladong.github.io/algo/2/23/65/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 11/24/22 at 12:01 PM
 */
public class P4_03_PriorityQueue_Max<Key extends Comparable> implements P4_03_PriorityQueue_Max_Api{

    Object[] data = null;
    int size;

    public P4_03_PriorityQueue_Max(int capcity) {
        this.data = new Object[capcity];
        this.size = 0;
    }

    /**
     * 元素放到末尾，然后执行上浮操作
     *
     * @param key
     */
    @Override
    public void insert(Object key) {
        // 我们是从 1 下标开始
        size++;
        // 新元素放入尾部
        data[size] = key;
        // 将新元素上浮
        swim(size);
    }

    @Override
    public Key delMax() {
        Key max = (Key) data[1];
        exch(1, size);
        data[size] = null;
        size--;
        // 将新的第一个元素下沉
        sink(1);
        return max;
    }

    @Override
    public Object max() {
        return data[1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 上浮: 将第 index 位置的元素上移，直到正确的位置
     * @param index
     */
    public void swim(int index) {
        // 下标从 1 开始
        while (index > 1 && less(index/2, index)) {
            // 如果第 index元素 大于 父节点，即与父节点互换，然后向上移动
            exch(index/2, index);
            index = index/2;
        }
    }

    public static void main(String[] args) {

        P4_03_PriorityQueue_Max<Integer> priorityQueueMax = new P4_03_PriorityQueue_Max<>(10);
        priorityQueueMax.insert(1);
        priorityQueueMax.insert(3);
        priorityQueueMax.insert(5);
        priorityQueueMax.insert(2);
        priorityQueueMax.insert(4);

        Integer max = priorityQueueMax.delMax();

        for (Object o : priorityQueueMax.data) {
            System.out.println(o);
        }

        System.out.println(max);
    }

    /// ============== 辅助方法 ==============
    /// ============== 二叉堆的操作 ==============

    /**
     * 下沉：将第 index 位置的元素下移，知道正确的位置
     *
     * @param index
     */
    public void sink(int index) {
        while (index * 2 < size) {
            int child = index * 2;
            // 找到左右子节点中较大的元素，使用其下标
            if(child + 1 < size && less(child, child + 1)) {
                child++;
            }
            // 一旦发现父不小于子，停止移动。注意这里用的反向逻辑，如果用正向逻辑，是不对的
            if(!less(index, child)) {
                break;
            }
            exch(index, child);
            index = child;
        }
    }

    public boolean less(int i, int j) {
        return ((Comparable)data[i]).compareTo(data[j]) < 0;
    }

    public void exch(int i, int j) {
        Object tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
