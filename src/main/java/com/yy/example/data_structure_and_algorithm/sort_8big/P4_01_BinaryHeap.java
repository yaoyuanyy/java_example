package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 二叉堆
 * <pre>
 * 首先，二叉堆和二叉树有啥关系呢，为什么人们总是把二叉堆画成一棵二叉树？
 * 因为，二叉堆在逻辑上其实是一种特殊的二叉树（完全二叉树），只不过存储在数组里。一般的链表二叉树，我们操作节点的指针，而在数组里，我们把数组索引作为指针
 *
 * 操作就两个：sink（下沉）和 swim（上浮），用以维护二叉堆的性质。
 * 主要应用有两个：首先是一种排序方法「堆排序」，第二是一种很有用的数据结构「优先级队列」。
 *
 * https://labuladong.github.io/algo/2/23/65/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 11/24/22 at 12:01 PM
 */
public class P4_01_BinaryHeap {

    Comparable[] data = null;
    int size;
    /**
     * 上浮: 将第 index 位置的元素上移，直到正确的位置
     * @param index
     */
    public void swim(int index) {
        // 下标从 1 开始
        while (index > 1 && less(index/2, index)) {
            // 如果第 index元素 大于 父节点，即与父节点互换，然后向上移动
            exch(data, index/2, index);
            index = index/2;
        }
    }

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
            exch(data, index, child);
            index = child;
        }
    }

    /// ============== 辅助方法 ==============

    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // 父节点的索引
    int parent(int root) {
        return root / 2;
    }

    // 左孩子的索引
    int left(int root) {
        return root * 2;
    }

    // 右孩子的索引
    int right(int root) {
        return root * 2 + 1;
    }
}
