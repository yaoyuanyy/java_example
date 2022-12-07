package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc2_beibao;

/**
 * Description: 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 * https://labuladong.github.io/algo/3/27/82/
 *
 * 解题：题目转换
 * 这道题可以换一种表述：给定一个只包含正整数的非空数组 nums，请你判断是否可以从数组中选出一些数字，使得这些数字的和等于整个数组的元素和的一半。
 * 因此这个问题可以转换成「0−1 背包问题」。这道题与传统的「0−1 背包问题」的区别在于，
 * 传统的「0−1 背包问题」要求选取的物品的重量之和不能超过背包的总容量，
 * 这道题则要求选取的数字的和恰好等于整个数组的元素和的一半。
 * 类似于传统的「0−1 背包问题」，可以使用动态规划求解。
 *
 * 链接：https://leetcode.cn/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-by-leetcode-solution/
 *
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_4_01BeiBaoSubPartition {

    /**
     * 题目转换后
     * dp[n][w] 表示前 n 个物品，是否可以填满 w 重量的背包，填满则是 true，不满则为 false;
     * 1. 确定状态
     * 根据题目，状态是背包的容量 w，可选择物品 n
     * <p>
     * 2. 确定选择
     * 对每个物品，选择有两个：装进背包，不装进背包
     * <p>
     * 3. 状态转移方程
     * dp[i][w] 表示将前 i 个物品放进一个容量为 w 背包中，可以获取的最大价值
     * 选择1: 第 i 个物品放进背包， 那么  dp[i][w] = dp[i-1][w-wArr[i-1]] + valArr[i]
     * 选择2: 第 i 个物品不放进背包，那么 dp[i][w] = dp[i-1][w]
     * 最后，max(选择1，选择2)
     *
     * @return
     */
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 总数是奇数，则无法等半分
        if(sum%2 != 0) {
            return false;
        }

        int N = nums.length;
        int W = sum/2;
        boolean[][] dp = new boolean[N+1][W+1]; // 每个元素默认都是 false;
        // base case
        for (int i = 0; i <= N; i++) {
            // 没有空间可装，即为装满
            dp[i][0] = true;
        }
        for (int i = 1; i <=N; i++) {
            for (int w = 1; w <= W; w++) {
                // 目标重量减去 i-1 位置的重量：剩余重量
                int remainW = w - nums[i - 1];
                if (remainW < 0) {
                    // 背包容量不足，不能装下第 i 个物品
                    dp[i][w] = dp[i - 1][w];
                }else {
                    // 装入或者不装入
                    dp[i][w] = dp[i-1][remainW] || dp[i-1][w];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 压缩方式：
     * 二维数组压缩为一维数组
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean res = new LC2_4_01BeiBaoSubPartition().canPartition(nums);
        System.out.println(res);
    }
}
