package com.yy.example.data_structure_and_algorithm.leetcode.simple.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 * Description: 两个数组的交集
 * <pre>
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-10 at 15:45
 */
public class LC6_IntersectionOf2Array {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        method2_Hash(nums1, nums2);
    }

    /**
     * 因为是求交集，所以以长度较小的那个为准
     *
     * @param nums1
     * @param nums2
     */
    private static void method1_Hash(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            method1_Hash(nums2, nums1);
            return;
        }

        HashMap<Integer, Integer> nums1OfMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            // int value = nums1OfMap.getOrDefault(nums1[i], 0);
            nums1OfMap.compute(nums1[i], (k, v) -> Objects.isNull(v) ? 1 : v + 1);
        }

        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            Integer value = nums1OfMap.get(num);
            if (Objects.nonNull(value)) {
                intersection[index++] = num;
                nums1OfMap.put(num, value - 1);
            }
        }
        for (int i : intersection) {
            System.out.print(i + " ");
        }

    }

    /**
     * 排序 + 双指针方法
     *
     * NOTE：双指针时循环使用while更方便
     *
     * @param nums1
     * @param nums2
     */
    private static void method2_Hash(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            method2_Hash(nums2, nums1);
            return;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] intersection = new int[nums1.length];
        int index = 0;

        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if(nums1[index1] < nums2[index2]) {
                index1++;
            }else if(nums1[index1] > nums2[index2]) {
                index2++;
            }else {
                intersection[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }

        for (int i : intersection) {
            System.out.print(i + " ");
        }
    }
}
