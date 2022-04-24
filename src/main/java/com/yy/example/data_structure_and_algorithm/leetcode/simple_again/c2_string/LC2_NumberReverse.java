package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c2_string;

/**
 * Description:
 * <pre>
 * 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹,  2³¹ − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * from：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-19 at 17:25
 */
public class LC2_NumberReverse {

    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            int m = x % 10;
            x = x / 10;
            r = r * 10 + m;
        }

        return r;
    }

    public static void main(String[] args) {
        LC2_NumberReverse numberReverse = new LC2_NumberReverse();
        int result = numberReverse.reverse(123);
        System.out.println(result);
    }
}
