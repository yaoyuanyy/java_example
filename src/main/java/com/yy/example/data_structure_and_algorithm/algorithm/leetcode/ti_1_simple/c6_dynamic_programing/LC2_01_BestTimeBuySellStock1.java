package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c6_dynamic_programing;

/**
 * Description: 买卖股票的最佳时机 1
 * <pre>
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn8fsh/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/17/22 at 8:22 AM
 */
public class LC2_01_BestTimeBuySellStock1 {

    /**
     * 动态规划分析
     * 1. 找出特征结构：题目要求整个数组的最大差值。所以我们分析的特征为：确定每个数组下标的最大差值
     * 2. 转为同类子问题：计算每个下标的最大差值
     * 3. 确定 base case：
     * 4. 进行决策过程：通过每个数组下标的最大差值，从而确定整个数组的最大差值
     *
     * 动态规划算法步骤。以本题为例
     * step1：刻画一个最优解的结构特征：求解时，需要满足最优子结构的特征。一般是数学方法来描述求解问题，用数学公式表明 最优子结构 求解的结构特征
     *   针对本题：
     *   考虑每次如何获取最大收益？第 i 天的最大收益只需要知道 前 i 天的最低点就可以算出来了，
     *   而前 i 天的最低点 与 第 i - 1 天的最低点有关。至此，我们的动态方程就出来了
     *   dp[i] = min{dp[i-1], prices[i]}
     * step2：递归的定义最优解的值：
     *   dp[0] = prices[0]
     *   然后动态计算就好了
     * step3：计算最优解的值：
     *   动态计算，求出 dp 每个元素的值
     * step4：利用计算出的信息构造最优解：
     *   得到了前i天的最低点以后，只需要维护一个max用来保存最大收益就可以了。
     *
     * refer to https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/
     * 中的 @94酱紫 作者的阐述
     */
    public int maxProfit(int[] prices) {
        // dp[i] 表示 截止到 i，价格的最低点是多少
        int[] dp = new int[prices.length + 1];
        dp[0] = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = dp[i - 1] < prices[i] ? dp[i - 1]: prices[i];
            max = prices[i] - dp[i] < max ? max : prices[i] - dp[i];
        }
        return max;
    }

    /**
     * 暴力解法
     *
     * @param prices
     * @return
     */
    public int maxProfit0(int[] prices) {
        // todo
        return 0;
    }

    /**
     * 双指针解法
     * <p>
     * 使用两个记录
     * 1. 下标：最小值的下标
     * 2. 数组：每个下标的最大差值
     *
     * @param prices
     * @return
     */
    public int maxProfit1_0(int[] prices) {
        int indexMinValue = 0;
        int[] difPrices = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[indexMinValue]) {
                indexMinValue = i;
            }
            if (prices[i] > prices[indexMinValue]) {
                difPrices[i] = prices[i] - prices[indexMinValue];
            }
        }

        int max = 0;
        for (int i = 0; i < difPrices.length; i++) {
            if (difPrices[i] > max) {
                max = difPrices[i];
            }
        }

        return max;
    }

    /**
     * 双指针解法
     * <p>
     * 使用两个记录
     * 1. 最小值的下标
     * 2. 最大差值
     *
     * @param prices
     * @return
     */
    public int maxProfit1_1(int[] prices) {                 
        int indexMinValue = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[indexMinValue]) {
                indexMinValue = i;
            }
            if (prices[i] > prices[indexMinValue]) {
                max = Math.max(prices[i] - prices[indexMinValue], max);
            }
        }

        return max;
    }

    /**
     * 单调栈解法
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        // todo
        return 0;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        LC2_01_BestTimeBuySellStock1 bestTimeBuySellStock1 = new LC2_01_BestTimeBuySellStock1();
        int maxProfit = bestTimeBuySellStock1.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
