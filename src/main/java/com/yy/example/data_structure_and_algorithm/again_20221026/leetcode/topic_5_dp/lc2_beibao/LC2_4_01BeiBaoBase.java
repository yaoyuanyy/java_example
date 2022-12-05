package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc2_beibao;

/**
 * Description: 0-1 背包问题
 * 给你一个可装载重量为 W 的背包和 N 个物品，其中第 i 个物品的重量为 wArr[i]，价值为 valArr[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * N = 3, W = 4
 * wArr = [2, 1, 3]
 * valArr = [4, 2, 3]
 *
 * https://labuladong.github.io/algo/3/27/81/
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_4_01BeiBao {

    /**
     * 1. 确定状态
     * 根据题目，状态是背包的容量 w，可选择物品 n
     *
     * 2. 确定选择
     * 对每个物品，选择有两个：装进背包，不装进背包
     *
     * 3. 状态转移方程
     * dp[i][w] 表示将前 i 个物品恰放进一个容量为 w 背包中，可以获取的最大价值
     * 选择1: 第 i 个物品放进背包， 那么  dp[i][w] = dp[i-1][w-wArr[i-1]] + valArr[i]
     * 选择2: 第 i 个物品不放进背包，那么 dp[i][w] = dp[i-1][w]
     * 最后，max(选择1，选择2)
     *
     * @return
     */
    public int knapsack(int N, int[] wArr, int[] valArr, int W) {
        int[][] dp = new int[N+1][W+1];
        // dp[0][0..N] = 0;
        // for 边界从 1 开始
        for (int i = 1; i <=N; i++) {
            for (int w = 1; w <= W; w++) {
                // 目标重量减去 i-1 位置的重量：剩余重量
                int remainW = w - wArr[i - 1];
                if (remainW < 0) {
                    // 这种情况下只能选择不装入背包：
                    // 扩展：01背包问题的思路和策略是装或不装；完全背包问题的思路策略是装0件，装1件，装n件
                    dp[i][w] = dp[i - 1][w];
                }else {
                    System.out.println(i + " " + w);
                    dp[i][w] = Math.max(dp[i-1][remainW] + valArr[i-1] , dp[i-1][w]);
                }
            }
        }
        return dp[N][W];
    }

    public int knapsack2(int N, int[] wArr, int[] valArr, int W) {
        // 压缩方式
        return 0;
    }

    public static void main(String[] args) {
        int[] wArr = {2, 1, 3};
        int[] valArr = {4, 2, 3};
        int sum = new LC2_4_01BeiBao().knapsack(3, wArr, valArr, 4);
        System.out.println(sum);
    }
}
