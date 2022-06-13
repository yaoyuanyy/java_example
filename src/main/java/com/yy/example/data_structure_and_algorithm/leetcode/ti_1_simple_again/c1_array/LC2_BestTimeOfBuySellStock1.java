package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c1_array;

import java.util.Objects;

/**
 * Description:
 * <pre>
 *    121. 买卖股票的最佳时机 I -> 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 *    设计一个算法来计算你所能获取的最大利润。
 *    示例 1：
 *      输入：[7,1,5,3,6,4]
 *      输出：5
 *      解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 *    from https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-14 at 19:47
 */
public class LC2_BestTimeOfBuySellStock1 {

    public int maxProfit(int[] prices) {
        if(Objects.isNull(prices) || prices.length ==0) return 0;

        // 保持它最小
        int min = prices[0];

        // 保持它最大
        int max_duration = 0;

        for (int i = 1; i < prices.length; i++) {
            // 比最小的还小
            if(prices[i] < min) {
                min = prices[i];
            }
            // 比最大的还大
            if(prices[i] - min > max_duration) {
                max_duration = prices[i] - min;
            }
        }

        return max_duration;
    }

    public static void main(String[] args) {
        LC2_BestTimeOfBuySellStock1 bestTimeOfBuySellStock1 = new LC2_BestTimeOfBuySellStock1();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = bestTimeOfBuySellStock1.maxProfit(prices);
        System.out.println("maxProfit:" + maxProfit);
    }
}
