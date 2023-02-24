package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.problems1_150;

/**
 * Description: 7. 整数反转
 * <pre>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * https://leetcode.cn/problems/reverse-integer/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC7_ReverseNumber {

    /**
     * 只要一提到反转，就要想到 取模和除数
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tail = x % 10; // 余数
            // 除以10的原因，while退出的最后一遍时，原数首位还没有加到res 中，也就是res 此时少一位，所以要除以10
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)  {
                return 0;
            }
            // 开始反转
            res = res * 10 + tail;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
//        int x = -23400;
        int x = 1534236469;
        int res = new LC7_ReverseNumber().reverse(x);
        System.out.println("res:" + res);
    }
}
