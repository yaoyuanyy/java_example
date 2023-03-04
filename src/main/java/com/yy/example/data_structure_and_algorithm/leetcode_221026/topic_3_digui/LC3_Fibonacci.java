package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_3_digui;

/**
 * Description: 斐波那契数
 * <pre>
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 *
 * 链接：https://leetcode.cn/leetbook/read/di-gui-yu-fen-zhi/wryf36/
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC3_Fibonacci {

    /**
     * 一般方法
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        for (int i = 3; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        int res = fib2(n - 1) + fib2(n - 2);
        return res;
    }

    public static void main(String[] args) {
        int sum = new LC3_Fibonacci().fib(4);
        System.out.println(sum);
    }
}
