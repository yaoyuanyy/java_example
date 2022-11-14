package com.yy.example.data_structure_and_algorithm.algorithm.book_algorithm_4;

/**
 * Description: 堆排序
 * 来自算法4
 * k从1开始
 * 所以：左子节点为 2k：右子节点为 2k+1；父节点为 k/2
 *
 * NOTE: 此处 k 是从1开始的。从0开始的版本参加左程云算法部分 {@link C2_04_02_LogN_Heap_ZCY}
 *
 * <pre>
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/27/22 at 10:20 AM
 */
public class C2_04_02_LogN_Heap extends Example {

    @Override
    public void sort(Comparable[] a) {
        int n = a.length - 1;
        // 堆的构造
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }

        // 下沉排序: 不断的队列的最大值位置与最后最后一个位置的元素互换
        while (n > 1) {
            exch(a, 1 , n--);
            sink(a, 1, n);
        }

    }

    /**
     * 方法作用：不断的与子节点比较，使大的数上移：
     *
     * 下沉：指的是 k 位置的变化趋势：是下沉的
     *
     * @param k 数组下标
     */
    private void sink(Comparable[] a, int k, int n) {

        while (2 * k <= n) {
            int tmp = k * 2;
            if(tmp < n && less(a[tmp], a[tmp + 1])) {
                tmp++;
            }
            // 父节点小于子节点，则换
            if(!less(a[k], a[tmp])) {
                break;
            }
            exch(a, k, tmp);
            k = tmp;
        }
    }

    public static void main(String[] args) {

        C2_04_02_LogN_Heap heap = new C2_04_02_LogN_Heap();
        Integer[] array = new Integer[]{0, 20, 30, 90, 60, 40, 50, 70, 10};
        heap.sort(array);
        show(array);
        System.out.println("数组递增吗：" + heap.isSorted(array));
    }
}
