package com.yy.example.data_structure_and_algorithm.leetcode_230102_important;

import com.yy.example.data_structure_and_algorithm.sort_8big.Example;

/**
 * 快速排序
 *
 * @author skyler_11@163.com
 * Created by on 1/2/23 at 10:26 AM
 */
public class LC1_Quick extends Example {

    /**
     * <pre>
     * 快速排序的代码框架可看作是二叉树的前序遍历；
     * 归并排序的代码框架可看作是二叉树的后序遍历；
     * 快速排序功能方法中双指针移动方向:|->      <-|   |表示收尾位置
     * 快速排序功能方法中双指针移动方向:|->  ->    |
     *
     *
     * 快速排序的整体思路：
     *    1.先找到一个位置，这个位置的左边的值小于这个位置，右边的值都大于这个位置。如何找到呢？
     *    2.以这个位置作为边界，形成两部分，分别递归的进行第一步的操作。
     *    1.1.第一步的如何找到呢？
     *      a.随机取一个元素作为target，从收尾两方相对方向(-> <-)，与target 比较：左边找比target 大的，右边找比target 小的，位置互换。
     *      比完一趟后，返回左边位置(为什么返回左边位置呢)
     *
     * 归并排序的整体思路：
     *    1.先找到一个位置，这个位置是正中间的位置，
     *    2.以这个位置作为边界，形成两部分，分别递归的进行第一步的操作
     *    3.最后合并这两部分，合并时需要一个额外的临时数组，从左向右的，一个从头开始，一个从中间位置开始，相互比较，小的那个赋值到原数组的对应位置，一直末尾。
     *
     * 我统一使用 while 循环，不使用 for，以便统一好记
     * </pre>
     *
     * @param arr
     */
    @Override
    public void sort(Comparable[] arr) {
        sort((Integer[]) arr , 0, arr.length - 1);
    }

    private void sort(Integer[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int position = partation(arr, lo, hi);
        // 由于position 的位置已经排好序了，所以，下面的sort 方法一个是 position-1，一个是 position+1。
        sort(arr, lo, position - 1);
        sort(arr, position + 1, hi);
    }

    /**
     * 从头尾开始相对方向移动，左侧找大于 target的位置，右侧找小于 target的位置
     */
    private int partation(Integer[] arr, int lo, int hi) {
        int target = arr[lo];
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            // i 向右移动，直到找到大于 target的位置
            while (i < hi && less(arr[i], target)) {
                i++;
            }
            // j 向左移动，直到找到小于 target的位置
            while (j > lo && less(target, arr[j])) {
                j--;
            }
            // 代码执行到此时，[lo..i) <= target < (j..hi]，
            // 且 arr[i]>target>arr[j]。即：i位置的值>target，j位置的值<=target，这句很重要

            // 如果没有这行代码，就会出现i > j的情况，此时，就会把右侧较大的值与左侧较小的值互换位置。
            // 如：j   i     互换后   j   i
            //    30  90            90  30
            // 所以要有这行代码
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
        // 此时，i位置的值 >target，j位置的值<=target。所以用j位置值与lo位置值互换。用i位置的话就把较大的值换左侧去了嘛，就不对了
        // 将 target 放到合适的位置，即 target 左边元素较小，右边元素较大
        exch(arr, lo, j);
        return j;
    }

    public static void main(String[] args) {

        LC1_Quick quick = new LC1_Quick();
        Integer[] array = new Integer[]{65, 30, 90, 60, 40, 50, 70, 10};
        quick.sort(array);
        show(array);
    }
}
