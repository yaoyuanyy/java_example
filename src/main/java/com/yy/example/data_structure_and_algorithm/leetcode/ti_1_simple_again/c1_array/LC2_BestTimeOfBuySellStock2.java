package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c1_array;

import java.util.Objects;

/**
 * Description:
 * <pre>
 *    买卖股票的最佳时机 II -> 你能获得的 最大利润(注释：这几天怎么操作，然后累加的利润最大)
 *    示例 1:
 *       输入: prices = [7,1,5,3,6,4]
 *       输出: 7
 *       解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *       随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 *    from https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-14 at 19:04
 */
public class LC2_BestTimeOfBuySellStock2 {

    /**
     * 相邻两个元素，右侧减去左侧的，大于0的结果累加，得到最终的利润
     * 如果数据是 7, 1, 5, 3, 6, 4。那这个方法好理解；如果是 0, 1, 5, 3, 6, 4。这个方法就感觉不是最优的，反而方法{@link #maxProfit2(int[])} 好理解
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0) return 0;

        int tatol = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                tatol += prices[i + 1] - prices[i];
            }
        }
        return tatol;
    }

    /**
     * 贪心算法
     * <img src="https://pic.leetcode-cn.com/1610414787-FKOtDL-image.png"/>
     * <p/>
     * 计算整个数组上升段的累加值，就是最终的利润
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0) return 0;

        int tatol = 0;
        int index = 0;
        while (index < prices.length) {
            // \
            //  \  /
            //   \   这样的趋势，找最低点
            while (index < prices.length - 1 && prices[index] >= prices[index + 1]) {
                index ++;
            }
            int min = prices[index];

            //     /
            //    /  \
            //   /   这样的趋势，找最高点
            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) {
                index ++;
            }

            tatol += prices[index] - min;

            // index此时已经比较完了，所以要从下一个元素开始
            index ++;
        }

        return tatol;
    }

    public static void main(String[] args) {
        LC2_BestTimeOfBuySellStock2 bestTimeOfBuySellStock = new LC2_BestTimeOfBuySellStock2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = bestTimeOfBuySellStock.maxProfit2(prices);
        System.out.println("maxProfit:" + maxProfit);
    }
}
