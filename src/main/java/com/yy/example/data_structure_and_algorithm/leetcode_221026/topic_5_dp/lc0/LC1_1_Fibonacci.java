package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_5_dp.lc0;

/**
 * Description: 斐波那契数
 * <pre>
 * https://labuladong.github.io/algo/3/25/69/
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC1_1_Fibonacci {

    /**
     * 暴力递归
     * 存在的问题：重叠子问题 f(x) 计算多次。解决方案：dp 数组，查看 {@link this#fib2(int[], int, String)}
     * @param n
     * @return
     */
    public int fib(int n) {
        // base case
        if(n == 1 || n == 2) {
            return 1;
        }
        // 状态转移，n 从 3 开始
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 递归：定义一个备忘录：数组，防止重复计算
     * 这是自顶向下」进行「递归」求解
     *
     * 备忘录启发：dp 专门的备忘录：dp table
     * dp table 结合「迭代」形成「自底而上」的「递推」，查看 {@link this#fib3(int[], int, String)}
     * @param n
     * @return
     */
    public int fib2(int[] memo, int n, String helperStr) {
        // base case
        if(n == 1 || n == 2) {
            return 1;
        }
        if(memo[n] != 0) {
            System.out.println("计算过的n值" + n + " =" + memo[n]);
            return memo[n];
        }
        memo[n] = fib2(memo, n - 1, "第一个fib")
                + fib2(memo, n - 2, "第二个fib");
        // 状态转移，n 从 3 开始
        return memo[n];
    }

    /**
     * dp 数组的迭代（递推）解法
     * dp table 结合「迭代」形成「自底而上」的「递推」
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 状态转移方程
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 斐波那契数列的状态转移方程，当前状态只和之前的两个状态有关，其实并不需要那么长的一个 DP table 来存储所有的状态，只要想办法存储之前的两个状态就行了。
     * 所以，可以进一步优化，把空间复杂度降为 O(1)。这也就是我们最常见的计算斐波那契数的算法：
     *
     * @param n
     * @return
     */
    public int fib4(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            // 滚动更新
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }

    public static void main(String[] args) {
        // int sum = new LC1_Fibonacci().fib(4);
//        int[] memo = new int[10+1];
//        int sum = new LC1_Fibonacci().fib2(memo, 6, "首次");
        int sum = new LC1_1_Fibonacci().fib3(6);
        System.out.println(sum);
    }
}
