package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c6_dynamic_programing;

import java.util.Arrays;

/**
 * Description: 零钱兑换 I - 完全背包问题
 * <pre>
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * https://leetcode.cn/problems/coin-change/
 * https://leetcode.cn/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/20/22 at 8:47 AM
 */
public class LC5_01_CoinChange_1 {

    /**
     * 递归
     * https://leetcode.cn/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return 0;
    }

    /**
     * 记忆法搜索
     * https://leetcode.cn/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        return 0;
    }

    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if(amount < 1) {
            return 0;
        }
        // dp[i] 表示 金额为 i 时，需要的最少硬币数
        // 所以，dp[i] = min{dp[i - c]} + 1 // c为硬币的几种面额，本题为 1 2 5
        // 所以，dp[i] = min{dp[i], dp[i - c] + 1}
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(i + " 最小硬币数:" + dp[i]);
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        LC5_01_CoinChange_1 coinChange = new LC5_01_CoinChange_1();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int min = coinChange.coinChange(coins, amount);
        System.out.println("min:" + min);
    }
}
