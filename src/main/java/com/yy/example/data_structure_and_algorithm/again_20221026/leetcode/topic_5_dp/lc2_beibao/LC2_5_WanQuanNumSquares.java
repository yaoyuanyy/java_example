package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc2_beibao;

/**
 * Description: 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * https://leetcode.cn/problems/perfect-squares/
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_5_WanQuanNumSquares {

    /**
     *
     * 背包问题讲解大牛：https://leetcode.cn/u/flix/
     * 此题：https://leetcode.cn/problems/perfect-squares/solution/by-flix-sve5/
     * 零钱兑换1:https://leetcode.cn/problems/coin-change/solution/by-flix-su7s/
     * @return
     */
    public int numSquares(int n) {
        return 0;
    }

    public static void main(String[] args) {
        int amount = 5;
        int res = new LC2_5_WanQuanNumSquares().numSquares(amount);
        System.out.println(res);
    }
}
