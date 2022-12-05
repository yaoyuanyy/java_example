package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc0;

/**
 * Description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * https://leetcode.cn/problems/climbing-stairs/
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_3_01ClimbStairs {

    /**
     * 根据题意，我们可以拿个具体的数画出爬楼梯的二叉树
     * 假如 n=6，画出爬楼梯的二叉树，你会发现 爬6阶的方式 = 爬5 + 爬4
     * 所以，我们可以得出公式：f(6)=f(5)+f(4)，
     * 推出一般的形式：f(n)=f(n-1)+f(n-2); if n>2
     * 可以使用递归，也可以使用 dp table
     * @param n
     * @return
     */

    /**
     * 暴力递归 自顶向下
     *
     * 在 leetcode 运行时会提示超时。所以要优化，使用备忘录
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 备忘录递归 自顶向下
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] memo = new int[n+1];
        return climbStairs2(memo, n);
    }

    public int climbStairs2(int[] memo, int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(memo[n] != 0) {
            return memo[n];
        }
        memo[n] = climbStairs2(n-1) + climbStairs2(n-2);
        return memo[n];
    }

    /**
     * 使用 dp 数组
     * 迭代 自底向上
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if(n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int sum = new LC2_3_01ClimbStairs().climbStairs2(6);
        System.out.println(sum);
    }
}
