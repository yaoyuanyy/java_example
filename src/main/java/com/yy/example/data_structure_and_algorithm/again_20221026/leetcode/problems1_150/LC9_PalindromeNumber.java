package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.problems1_150;

/**
 * Description: 9. 回文数
 * <pre>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * https://leetcode.cn/problems/palindrome-number/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC9_PalindromeNumber {

    /**
     * 将数字反转，然后对比是否相等即可
     * @return
     */
    public boolean isPalindrome(int x) {
        int origin = x;
        // 以0结尾且不是0的数字
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 反转
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            res = res * 10 + tail;
            x = x / 10;
        }
        // 此时x 为0，反转完成
        return res == origin;
    }

    /**
     * 方法一有个缺陷，反转后的数可能超出int，从而溢出
     * 改善方法：反转一半，然后比较是否相等
     * @return
     */
    public boolean isPalindrome2(int x) {
        // 以0结尾且不是0的数字
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 反转一半
        int res = 0;
        while (x > res) {
            int tail = x % 10;
            res = res * 10 + tail;
            x = x / 10;
        }
        // 此时x<=res；奇数是<；偶数是=
        // 举例：奇数：12321：x=12;res=123；偶数：1221：x=12;res=12
        return x == res || x == res / 10;
    }

    public static void main(String[] args) {
//        int x = -23400;
        int x = 1211;
        boolean res = new LC9_PalindromeNumber().isPalindrome(x);
        System.out.println("res:" + res);
    }
}
