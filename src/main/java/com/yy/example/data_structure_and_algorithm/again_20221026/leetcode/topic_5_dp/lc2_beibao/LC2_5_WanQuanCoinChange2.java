package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc2_beibao;

/**
 * Description: 518. 零钱兑换 II
 * 给你一个整数数组 coins ，表示不同面额的硬币，以及一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。假设每一种面额的硬币有无限个。
 * <p>
 * 示例 1：
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * https://leetcode.cn/problems/coin-change-ii/
 *
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_5_WanQuanCoinChange2 {

    /**
     * 1. 确定状态和选择
     * 根据题目，状态是背包的容量 w，可选择物品 n
     * 2. 确定选择
     * 对每个物品，选择有两个：装进背包，不装进背包
     * for(状态1 in 状态1的所有取值) {
     * for(状态2 in 状态2的所有取值) {
     * dp[状态1][状态2] = 计算(选择1，选择2)
     * }
     * }
     * 3. 状态转移方程
     * dp[i][w] 表示将前 i 个物品放进一个容量为 w 背包中，装满有多少种方法
     * 若只考虑第 i 个物品的策略：
     * 选择1: 第 i 个物品放进背包，即组成的方法里包含这个物品，将这个物品的重量去掉。那么 dp[i][w] = dp[i-1][w-wArr[i-1]]
     * 选择2: 第 i 个物品不放进背包，即组成的方法中不包含这个物品，重量由其他物品构成。那么 dp[i][w] = dp[i-1][w]
     * 最后，题目求的组成有多少种方法，当然就是把两个选择加到一起。即 sum(选择1，选择2)
     *
     * @return
     */
    public int change(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        // base case 当背包容量为 0 时，即自然装满为一种方法，所以，值为 1
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= amount; w++) {
                int remainW = w - coins[i - 1];
                if (remainW < 0) {
                    // 剩余容量没有了，即不用装第 i 个物品了
                    dp[i][w] = dp[i - 1][w];
                } else {
                    //         不装第 i 个物品 + 装第 i 个物品
                    // 疑问：dp[i][remainW] 这里为什么是 i 而不是 i-1 呢？
                    // 答案：完全背包中第 i 个物品是可以重复的，而 01背包中第 i 个物品是不能重复的
                    // 所以，完全背包中是dp[i][remainW]，而 01背包中是dp[i-1][remainW]
                    dp[i][w] = dp[i - 1][w] + dp[i][remainW];
                }
            }
        }
        // 我们要求的答案即使所有的物品: N 个，装入容量为 amount 的背包中，有多少种方法
        return dp[N][amount];
    }

    /**
     * 空间压缩
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        return 0;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 5, 11, 5};
//        int amount = 0;

        int[] nums = {1, 2, 5};
        int amount = 5;
        int res = new LC2_5_WanQuanCoinChange2().change(amount, nums);
        System.out.println(res);
    }
}
