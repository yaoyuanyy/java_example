package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.problems1_150;

import java.util.Arrays;

/**
 * Description: 167. 两数之和 II - 输入有序数组
 * <pre>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 *
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC167_TwoSum2 {

    /**
     * {@link com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_1_2_string.double_point.LC3_TwoSum2#twoSum(int[], int)}
     * @param nums
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // todo
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        int[] ans = new LC167_TwoSum2().twoSum(arr, target);
        Arrays.stream(ans).forEach(a -> System.out.println(a));

    }
}
