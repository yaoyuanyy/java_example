package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 堆排序 算法4 P205
 * <pre>
 * k从1开始
 * 所以：左子节点为 2k：右子节点为 2k+1；父节点为 k/2
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 11/24/22 at 12:01 PM
 */
public class P4_04_Heap extends Example {

    /**
     * 1. 构造一个大顶堆
     * 2. 不断的将大顶堆的第一个元素放到尾部
     * 3. 最后就是排好序的数组
     * 算法4 P205
     *
     * @param array
     */
    @Override
    public void sort(Comparable[] array) {
        int size = array.length - 1;
        for (int k = size / 2; k >= 1; k--) {
            // 将第 k 个元素下沉
            sink(array, k, size);
        }
        // 此时数组已经是大顶堆
        // 第一个元素就是最大的，将最大的与末尾位置的元素互换
        // 互换后第一个位置元素需要下沉，从而保持大顶堆
        // 如此反复直到全部元素
        while (size > 1) {
            exch(array, 1, size--);
            sink(array, 1, size);
        }
    }

    /**
     * 上浮: 将第 index 位置的元素上移，直到正确的位置
     *
     * @param index
     */
    public void swim(Comparable[] data, int index) {
        // 下标从 1 开始
        while (index > 1 && less(data, index / 2, index)) {
            // 如果第 index元素 大于 父节点，即与父节点互换，然后向上移动
            exch(data, index / 2, index);
            index = index / 2;
        }
    }

    /**
     * 下沉：将第 index 位置的元素下移，知道正确的位置
     *
     * @param index
     */
    public void sink(Comparable[] data, int index, int size) {
        while (index * 2 <= size) {
            int child = index * 2;
            // 找到左右子节点中较大的元素，使用其下标
            if (child < size && less(data, child, child + 1)) {
                child++;
            }
            // 一旦发现父不小于子，停止移动。注意这里用的反向逻辑，如果用正向逻辑，是不对的
            if (!less(data, index, child)) {
                break;
            }
            exch(data, index, child);
            index = child;
        }
    }

    /// ============== 辅助方法 ==============

//    public boolean less(Comparable[] data, int i, int j) {
//        return data[i].compareTo(data[j]) < 0;
//    }

//    public void exch(Comparable[] a, int i, int j) {
//        Comparable tmp = a[i];
//        a[i] = a[j];
//        a[j] = tmp;
//    }

    public static void main(String[] args) {
        P4_04_Heap heap = new P4_04_Heap();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        heap.sort(array);
        show(array);
    }
}
