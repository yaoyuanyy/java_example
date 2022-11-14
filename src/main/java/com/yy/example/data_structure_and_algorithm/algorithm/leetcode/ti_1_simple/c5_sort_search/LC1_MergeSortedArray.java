package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c5_sort_search;

import java.util.Arrays;

/**
 * Description: 合并两个有序数组
 * <pre>
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 *
 * 示例 3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-17 at 22:09
 */
public class LC1_MergeSortedArray {

    /**
     * 暴力版本
     *
     * @param nums1
     * @param m nums1的元素数目
     * @param nums2
     * @param n nums2的元素数目
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(nums1);
    }


    /**
     * 双指针版本
     * 需要一个长度为 m + n 的数组
     * 方式：两个数组从头开始比较，哪个小放入新数组中
     *
     * @param nums1
     * @param m nums1的元素数目
     * @param nums2
     * @param n nums2的元素数目
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = 0;
        int nIndex = 0;
        int sortedIndex = 0;
        int[] sorted = new int[n + m];
        while (mIndex < m && nIndex < n) {
            if(nums1[mIndex] < nums2[nIndex]) {
                sorted[sortedIndex++] = nums1[mIndex++];
            }else {
                sorted[sortedIndex++] = nums2[nIndex++];
            }
        }
        if(mIndex < m) {
            for (int i = mIndex; i < m; i++) {
                sorted[sortedIndex++] = nums1[i];
            }
        }
        if(nIndex < n) {
            for (int i = nIndex; i < n; i++) {
                sorted[sortedIndex++] = nums2[i];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 双指针版本
     * 方式：指针从后往前遍历
     *
     * @param nums1
     * @param m nums1的元素数目
     * @param nums2
     * @param n nums2的元素数目
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        int sortedIndex = n + m - 1;
        while (nIndex >= 0) {
            if(mIndex >= 0 && nums1[mIndex] > nums2[nIndex]) {
                nums1[sortedIndex--] = nums1[mIndex--];
            }else {
                nums1[sortedIndex--] = nums2[nIndex--];
            }
        }
    }

    public static void main(String[] args) {
        LC1_MergeSortedArray mergeSortedArray = new LC1_MergeSortedArray();
//        int[] nums1 = {1,3,0,0,0};
//        int m = 2;
//        int[] nums2 = {2,5,6};
//        int n = 3;
        //mergeSortedArray.merge1(nums1, m, nums2, n);

//        int[] nums1 = {0,0,0};
//        int m = 0;
        int[] nums1 = {1,3,0,0,0};
        int m = 2;
        int[] nums2 = {2,5,6};
        int n = 3;
        mergeSortedArray.merge3(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(o -> System.out.print(o + " "));
    }
}
