package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c1_array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <pre>
 *  两个数组的交集 I
 *
 *  给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *   示例 1：
 *   输入：nums1 = [1,2,2,1], nums2 = [2,2]
 *   输出：[2]
 *
 *   from：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-16 at 20:32
 */
public class LC6_JiaoJiOfTwoArray1 {

    /**
     * 使用两个Set集合
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }

        for (int num2 : nums2) {
            set2.add(num2);
        }

        return getIntersection(set1, set2);
    }

    private int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> tmpSet = new HashSet<>();
        if(set1.size() > set2.size()) {
            getIntersection(set2, set1);
        }

        for (Integer num : set1) {
            if(!set2.add(num)){
                tmpSet.add(num);
            }
        }

        int[] result = new int[tmpSet.size()];
        int index = 0;
        for (Integer num : tmpSet) {
            result[index++] = num;
        }

        return result;
    }

    /**
     * 先排序，再使用双指针 todo
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        return null;
    }

    public static void main(String[] args) {
        LC6_JiaoJiOfTwoArray1 jiaoJiOfTwoArray1 = new LC6_JiaoJiOfTwoArray1();
        int[] nums1 = {4,1,2,1,2};
        int[] nums2 = {1,2,1,2};
        int[] nums = jiaoJiOfTwoArray1.intersection(nums1, nums2);

        for (int num : nums) {
            System.out.println("num:" + num);
        }
    }
}
