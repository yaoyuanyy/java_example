package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_5_dp.lc1_sequence;

/**
 * Description: 最大子数组和
 * <pre>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * https://labuladong.github.io/algo/3/26/77/
 * https://leetcode.cn/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
 * 关于「状态」定义的讲述很好
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_2_MaxSumSubArray {

    /**
     * 定义 dp 数组：dp[i] 表示以 nums[i] 为「结尾」的「连续」子数组的最大和。整个 nums 的最大子数组和就是 max(dp[i])
     * 分析思路：
     * 举例：假设现在数组是 [-1,3]，3结尾的子数组有 -1,3 和 3，那么最大的子数组显然是3。
     * 推广开就是 dp[i] = {nums[i], nums[i] + dp[i-1]}
     * 状态转移方程：
     * dp[i]={  dp[i−1]+nums[i], if dp[i−1] > 0
     *       {  nums[i]        , if dp[i−1] <=0
     *
     * 1. base case: dp[0]=nums[0]
     * 2. 确定状态：所谓状态为原问题与子问题之间变化的变量。也可理解为如何定义子问题。dp[i] 与 dp[i-1] 的关系
     * 3. 确定选择：「状态」变化的「行为」。dp[i] 与 dp[i-1] 之间如何变化的
     * 4. 确定状态转移方程：如上定义
     * 5. 确定状态转移方程的数组形式：dp[i] = max(nums[i], nums[i] + dp[i-1])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        // base case
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
//            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 进阶版：压缩空间的版本
     *
     * 可以优化空间吗 https://leetcode.cn/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int sum = new LC2_2_MaxSumSubArray().maxSubArray(nums);
        System.out.println(sum);
    }
}
