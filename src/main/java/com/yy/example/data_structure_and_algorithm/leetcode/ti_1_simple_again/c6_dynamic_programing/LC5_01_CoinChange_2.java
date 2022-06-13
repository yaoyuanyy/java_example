package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c6_dynamic_programing;

/**
 * Description: 518. 零钱兑换 II - 组合背包问题
 * <pre>
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 *
 * 示例 1：
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 示例 2：
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3
 *
 * 示例 3：
 * 输入：amount = 10, coins = [10]
 * 输出：1
 *
 * https://leetcode.cn/problems/coin-change-2/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/20/22 at 8:47 AM
 */
public class LC5_01_CoinChange_2 {

    /**
     * 动态规划
     *
     * see LC1_01_Climb_Staris#climbStairs3(int, int[])
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // dp[i]：
        int[] dp = new int[amount + 1];
        //
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if(i >= coin) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        LC5_01_CoinChange_2 coinChange = new LC5_01_CoinChange_2();
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        int count = coinChange.coinChange(coins, amount);
        System.out.println("总金额为"+amount+" 的组合数为：" + count);
    }
}
