package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc2_beibao;

import java.util.Arrays;

/**
 * Description: 322. 零钱兑换
 * <pre>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
 *
 * 如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * https://labuladong.github.io/algo/3/25/69/
 * https://leetcode.cn/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 * 背包问题讲解大牛：https://leetcode.cn/u/flix/
 * 背包问题讲解：https://leetcode.cn/problems/coin-change/solution/by-flix-su7s/
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_5_WanQuanCoinChange1 {

    /**
     * 暴力递归 - 自顶向下
     * 确定转台转移方程
     * 1. base case: 当金额为0时，返回0
     * 2. 确定状态：所谓状态即原问题与子问题之间变化的变量。本题金额在不断的向0值靠近，状态为金额
     * 3. 确定选择：所谓选择即导致 「状态」产生变化的「行为」，本题每选择一个硬币，相当于减少了目标金额
     * 4. 确定dp 函数/dp table: 本题可以自顶向下，所以使用 dp 函数，入参为金额 n，出参为凑出金额 n 所需要的最少的硬币数量
     * <p>
     * 个人觉得：自顶向下的模式，不好理解
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        // base case
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subMin = coinChange(coins, amount - coin);
            if (subMin == -1) {
                continue;
            }
            min = Math.min(min, subMin + 1);
        }
        return min;
    }

    int[] memo = null;
    /**
     * 带有备忘录的递归 - 自顶向下
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        memo = new int[amount + 1];
        return doCoinChange(coins, amount);
    }
    public int doCoinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        // base case
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subMin = coinChange(coins, amount - coin);
            if (subMin == -1) {
                continue;
            }
            min = Math.min(min, subMin + 1);
        }
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }

    /**
     * 采用迭代 - 自底向上
     * 确定转台转移方程
     * 1. base case: 当金额为0时，返回0
     * 2. 确定状态：所谓状态即原问题与子问题之间变化的变量。本题金额在不断的向0值靠近，状态为金额
     * 3. 确定选择：所谓选择即导致 「状态」产生变化的「行为」，本题每选择一个硬币，相当于减少了目标金额
     * 4. 确定dp 函数/dp table: 本题可以自顶向下，所以使用 dp 函数，入参为金额 n，出参为凑出金额 n 所需要的最少的硬币数量
     * <p>
     * 状态转移方程：
     * 迭代使用 dp table，dp table含义：当目标金额为 i 时，至少需要 dp[i] 个硬币凑成
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        // 状态转移方程的数学形式：当目标金额为 i 时，至少需要 dp[i] 个硬币凑成
        // dp[i] = min{dp[i], dp[i - c] + 1} c 为硬币的面值 1 2 5
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                // 当总金额为 i 时，采用去掉哪个 coin 的方案时，用的硬币数量最少
                if(i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(i + " 最小硬币数:" + dp[i]);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange22(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        // 状态转移方程的数学形式：当目标金额为 i 时，至少需要 dp[i] 个硬币凑成
        // dp[i] = min{dp[i], dp[i - c] + 1} c 为硬币的面值 1 2 5
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // 当总金额为 i 时，采用去掉哪个 coin 的方案时，用的硬币数量最少
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(i + " 最小硬币数:" + dp[i]);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2};
        int amount = 5;
        int sum = new LC2_5_WanQuanCoinChange1().coinChange2(coins, amount);
        System.out.println(sum);
    }
}
