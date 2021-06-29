package com.yy.example.data_structure_and_algorithm.heap_sort;

import java.util.Arrays;

/**
 * Description: 堆排序
 * <p>
 * 参考：http://blog.csdn.net/zdp072/article/details/44227317
 * </p>
 * <pre>
 *     此代码出自书籍：[数据结构与算法分析_Java语言描述(第2版)].韦斯
 * </pre>
 * NB.
 * Created by skyler on 2017/11/21 at 下午3:17
 */
public class HeapSort {

    /**
     * 堆排序
     */
    private static void heapSort(final int[] a) {
        // 将待排序的序列构建成一个大顶堆
        for (int i = a.length / 2; i >= 0; i--) {
            heapAdjust(a, i, a.length);
        }

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = a.length - 1; i > 0; i--) {
            // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            swap(a, 0, i);
            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            heapAdjust(a, 0, i);
        }
    }

    /**
     * 构建堆的过程
     *
     * @param a      需要排序的数组
     * @param i      需要构建堆的根节点的序号
     * @param length 数组的长度
     */
    private static void heapAdjust(final int[] a, int i, final int length) {
        int child;
        final int target;
        for (target = a[i]; leftChild(i) < length; i = child) {
            child = leftChild(i);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != length - 1 && a[child] < a[child + 1]) {
                child++; // 序号增1，指向右子树
            }

            // 如果父节点小于孩子结点，则需要交换
            if (target < a[child]) {
                a[i] = a[child];
            } else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        a[i] = target;
    }


    // 获取到左孩子结点
    private static int leftChild(final int i) {
        return 2 * i + 1;
    }

    // 交换元素位置
    private static void swap(final int[] a, final int index1, final int index2) {
        final int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }


    /**
     * 结果：
     * <pre>
     *                      0
     *                2           2
     *            3       3   4       9
     *         11   18  7
     * </pre>
     *
     */
    public static void main(final String[] args) {

       // final int[] a = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        final int[] a = {18, 17, 12, 11, 3, 4, 9, 2, 1, 0};

        System.out.println("Input: " + Arrays.toString(a));
        heapSort(a);
        System.out.println("Output: " + Arrays.toString(a));
    }
}
