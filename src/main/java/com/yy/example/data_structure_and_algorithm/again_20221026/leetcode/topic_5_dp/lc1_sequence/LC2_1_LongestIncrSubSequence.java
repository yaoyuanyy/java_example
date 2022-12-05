package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.sequence;

import java.util.Arrays;

/**
 * Description: 最长递增子序列
 * <pre>
 * https://labuladong.github.io/algo/3/25/70/
 *
 * 动态规划之子序列问题解题模板 https://mirrors.gitcode.host/labuladong/fucking-algorithm/dynamic_programming/StrategiesForSubsequenceProblem.html
 * localhost: 动态规划之子序列问题解题模板.pdf
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_1_LongestIncrSubSequence {

    /**
     * 迭代 - 自底向上
     * 在计算 dp[i] 之前，假设我们已经计算出 dp[0 .. i-1] 的值，
     * 则：确定转台转移方程：dp[i]表示以nums[i]结尾的数组的最长递增子序列的长度   => 这是错误的表述
     * 则：确定转台转移方程：dp[i]表示以第 i 个数字结尾的最长上升子序列的长度     => 这是正确的表述，注意：这个序列的组成一定要包含第 i 个数字
     * 数学形式：dp[i] = max{dp[i], dp[j] + 1}, 0 < j < i，且 nums[j] < nums[i]
     *
     * 1. base case: 当金额为0时，返回0
     * 2. 确定状态：所谓状态即原问题与子问题之间变化的变量。本题金额在不断的向0值靠近，状态为金额
     * 3. 确定选择：所谓选择即导致 「状态」产生变化的「行为」，本题每选择一个硬币，相当于减少了目标金额
     * 4. 状态转移方程：
     * 4. 确定dp 函数/dp table: 本题可以自顶向下，所以使用 dp 函数，入参为金额 n，出参为凑出金额 n 所需要的最少的硬币数量
     * <p>
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // base case
        int[] dp = new int[nums.length + 1];
        // 为什么要初始化为 1 呢，todo
        Arrays.fill(dp, 1);
        // i 位置数结尾递增子序列的长度
        for (int i = 0; i<nums.length; i++) {
            for (int j = 0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        // 找出最大的 dp[i]
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        // 10,9,2,5,3,7,101,18 - 4
        // 0,1,0,3,2,3 - 4
        int[] coins = new int[]{0,1,0,3,2,3};
        int sum = new LC2_1_LongestIncrSubSequence().lengthOfLIS(coins);
        System.out.println(sum);
    }
}
