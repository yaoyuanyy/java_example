package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_3_digui;

/**
 * Description: 2 的幂
 * <pre>
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 *
 * 链接：https://leetcode.cn/problems/power-of-two
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC4_PowOfTwo {

    /**
     * 递归 从下向上
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return doPowerOfTwo(0, n);
    }

    public boolean doPowerOfTwo(int x, int n) {
        if(Math.pow(2, x) > n) return false;
        if(Math.pow(2, x) == n) return true;
        boolean res = doPowerOfTwo(++x, n);
        return res;
    }

    /**
     * 递归 从上向下
     *
     * 判断该数是否可以整除2，若可以，再判断除以2后得到的数是否也可以整除2
     * 若可以一直下去直到结果为1，则返回True
     * 其他情况则返回False
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        if(n % 2 != 0) return false;
        return isPowerOfTwo2(n/2);
    }

    public static void main(String[] args) {
        boolean isPow = new LC4_PowOfTwo().isPowerOfTwo2(5);
        System.out.println(isPow);
    }
}
