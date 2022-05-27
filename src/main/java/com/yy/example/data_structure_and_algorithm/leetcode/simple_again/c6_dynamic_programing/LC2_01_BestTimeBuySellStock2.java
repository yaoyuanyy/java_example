package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c6_dynamic_programing;

import java.util.Arrays;

/**
 * Description: 122. 买卖股票的最佳时机 II
 * <pre>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 *
 * 示例 1：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 *
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 *
 * 示例 3：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 *
 * 链接：
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/17/22 at 8:22 AM
 */
public class LC2_01_BestTimeBuySellStock2 {


    /**
     * 动态规划
     * 分析：
     * 第 i 天手里最多有一直股票，所以，第 i 天的最大利润有两种情况：1.第 i 天手里有股票；2. 第 i 天手里没有股票，最终的最大利润为两种情况的最大值
     * 状态转移方程：
     * 如果第 i 天有股票
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // dp[i][0]：第 i 天交易后没有股票
        // dp[i][1]：第 i 天交易后有股票
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(i + "行 0列：" + dp[i][0]);
            System.out.print(" 1列：" + dp[i][1]);
            System.out.println();
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 贪心
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        return 0;
    }

    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int index = 0;
        int max = 0;
        while (index < prices.length - 1) {
            while (index < prices.length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            int low = prices[index];

            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }

            max += prices[index] - low;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        LC2_01_BestTimeBuySellStock2 bestTimeBuySellStock2 = new LC2_01_BestTimeBuySellStock2();
        int maxProfit = bestTimeBuySellStock2.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
