package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c6_dynamic_programing;

import java.util.Arrays;

/**
 * Description: 爬楼梯
 * <pre>
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * 链接：
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn854d/
 *
 * 爬楼梯为例：
 * 动态规划详解
 * https://m.imooc.com/wiki/algorithmlesson-dynamicprogrammingintro
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/15/22 at 8:10 AM
 */
public class LC1_01_Climb_Staris {

    /**
     * 暴力递归：有重复计算的缺点。改良：记忆化递归(搜索)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            // 两种：1 1 or 0 2
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    /**
     * 记忆化递归(搜索)
     * 递归调用树解释记忆化递归怎么避免重复的调用
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] arr = new int[n + 1];
        int res = doClimbStairs(n, arr);
        Arrays.stream(arr).forEach(o -> System.out.print(o + " "));
        return res;
    }

    public int doClimbStairs(int n, int[] arr) {
        if(arr[n] != 0) {
            return arr[n];
        }
        if(n == 1) {
            arr[n] = 1;
        } else if(n == 2) {
            // 两种：1 1 or 0 2
            arr[n] = 2;
        }else {
            arr[n] = doClimbStairs(n - 1, arr) + doClimbStairs(n - 2, arr);
        }
        return arr[n];
    }

    /**
     * 动态规划
     * 此时，空间复杂度为O(n) -> 空间复杂度能否为O(1)呢 see {@link #climbStairs4(int)} }
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if(n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        Arrays.stream(dp).forEach(o -> System.out.print(o + " "));
        return dp[n];
    }

    /**
     * 动态规划：通用方法
     *
     * 零钱兑换II和爬楼梯问题到底有什么不同？
     * https://leetcode.cn/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
     *
     * 爬楼梯问题与硬币找零问题的区别：
     * coins数组在外，n 在内是组合数
     * coins数组在内，n 在外是排列数，排列数有顺序
     * @param n
     * @return
     */
    public int climbStairs3(int n, int[] coins) {
        if(n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int coin : coins) {
                if(i >= coin) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }
        Arrays.stream(dp).forEach(o -> System.out.print(o + " "));
        return dp[n];
    }

    /**
     * 变量计算
     *
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        if(n < 1) {
            return 0;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        LC1_01_Climb_Staris climb_staris = new LC1_01_Climb_Staris();
//        System.out.println("爬3层时，爬的方式种数：" + climb_staris.climbStairs(3));
        System.out.println("爬4层时，爬的方式种数：" + climb_staris.climbStairs4(4));

        System.out.println();
        System.out.println("爬4层时，爬的方式种数：" + climb_staris.climbStairs3(4, new int[]{1, 2}));

    }
}
