package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c6_dynamic_programing;

import java.util.Arrays;

/**
 * Description: 最大子序和
 * <pre>
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn3cg3/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/18/22 at 5:07 PM
 */
public class LC3_01_MaxSubSum {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // dp[i]：前 i 个元素构成的最大子序和
        // 分析：计算dp[i]，只需要计算dp[i - 1]的最大子序和的值，
        // 如果dp[i - 1] > 0；则 dp[i] = dp[i - 1] + nums[i]；
        // 如果dp[i - 1] < 0；则 dp[i] = nums[i]
        // 所以，状态转移方程：dp[i] = max{dp[i - 1] + nums[i], nums[i]}
        int[] dp = new int[nums.length + 1];
        // base case
        dp[0] = nums[0];
        int maxSum = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i] < nums[i] ? nums[i] : dp[i - 1] + nums[i];
            maxSum = Math.max(dp[i], maxSum);
        }

        Arrays.stream(dp).forEach(o -> System.out.print(o + " "));
        return maxSum;
    }

    /**
     * 动态规划：代码优化版
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int maxTmp = nums[0];
        int maxSum = maxTmp;
        for (int i = 1; i < nums.length; i++) {
            maxTmp = maxTmp + nums[i] < nums[i] ? nums[i] : maxTmp + nums[i];
            maxSum = Math.max(maxTmp, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        LC3_01_MaxSubSum maxSubSum = new LC3_01_MaxSubSum();
        int maxSum = maxSubSum.maxSubArray(nums);
        System.out.println("maxSum:" + maxSum);
    }
}
