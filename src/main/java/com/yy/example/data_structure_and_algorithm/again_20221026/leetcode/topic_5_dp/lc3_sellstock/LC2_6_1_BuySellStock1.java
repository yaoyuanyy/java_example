package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc3_sellstock;

/**
 * Description: 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_6_1_BuySellStock1 {

    /**
     * 动态规划
     *
     * 买卖股票问题的通解：https://leetcode.cn/circle/article/qiAgHn/
     */
    public int maxProfit3(int[] prices) {
        if(prices == null || prices.length == 1) {
            return 0;
        }
        /// 通用公式：
        /// 持有 0 份股票     休息          卖出
        /// T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1] + prices[i]);
        /// 持有 1 份股票     休息          买入
        /// T[i][k][1] = max(T[i-1][k][1],T[i-1][k-1][0] - prices[i]);
        // k=1 时
        /// T[i][1][0] = max(T[i-1][1][0],T[i-1][1][1] + prices[i]);
        /// T[i][1][1] = max(T[i-1][1][1],T[i-1][0][0] - prices[i]) = max(T[i-1][1][1], -prices[i]); // T[i-1][0][0]=0;

        int N = prices.length;
        int[][] dp = new int[N][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i < N; i++) {
            // 第 i 天，剩 0 份股票  休息      卖出：前一天持有 1 份，今天才能卖出
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            // 第 i 天，剩 1 份股票，休息      买入
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[N-1][0];
    }

    // 压缩：i 只与 i-1 有关，所以可以压缩
    public int maxProfit33(int[] prices) {
        if(prices == null || prices.length == 1) {
            return 0;
        }

        int N = prices.length;
        int[] dp = new int[2];
        dp[0]=0;
        dp[1]=-prices[0];
        for (int i = 1; i < N; i++) {
            // 第 i 天，剩 0 份股票  休息      卖出：前一天持有 1 份，今天才能卖出
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            // 第 i 天，剩 1 份股票，休息      买入
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }

    /**
     * 一次遍历
     */
    public int maxProfit2(int[] prices) {
        // 定义一个最小值，和数组的每个元素比较大小，保持最小值
        // 数组指针右移，如果当前值大于最小值，求差值，与最大值比较，保持最大值
        int minValue = Integer.MAX_VALUE;
        int maxDuration = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i] < minValue) {
                minValue = prices[i];
            }else if(prices[i] - minValue > maxDuration){
                maxDuration = prices[i] - minValue;
            }
        }
        return maxDuration;
    }

    /**
     * 暴力方法
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j]-prices[i] > 0) {
                    max = Math.max(max, prices[j]-prices[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int sum = new LC2_6_1_BuySellStock1().maxProfit33(prices);
        System.out.println(sum);
    }
}
