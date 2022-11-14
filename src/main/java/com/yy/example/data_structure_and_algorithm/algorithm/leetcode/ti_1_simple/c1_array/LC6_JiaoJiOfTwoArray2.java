package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c1_array;

import java.util.*;

/**
 * Description:
 * <pre>
 *  两个数组的交集 II
 *    给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 *    返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 *    可以不考虑输出结果的顺序。
 *    示例 2:
 *    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *    输出：[4,9]
 *
 *    进阶：
 *    如果给定的数组已经排好序呢？你将如何优化你的算法？
 *    如果 nums1 的大小比 nums2 小，哪种方法更优？
 *    如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 *    from https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-16 at 20:32
 */
public class LC6_JiaoJiOfTwoArray2 {

    /**
     * 官网的代码，值得研究和学习
     * 使用Map
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 先排序，再使用双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        List<Integer> result = new ArrayList<>();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                result.add(nums1[index1]);
                index1++;
                index2++;
            }else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        LC6_JiaoJiOfTwoArray2 jiaoJiOfTwoArray2 = new LC6_JiaoJiOfTwoArray2();
        int[] nums1 = {4,1,2,1,2};
        int[] nums2 = {1,1,2};
        int[] nums = jiaoJiOfTwoArray2.intersect2(nums1, nums2);

        for (int num : nums) {
            System.out.println("num:" + num);
        }
    }
}
