package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c8_math;

/**
 * Description:
 * <pre>
 * 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 *
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnzlu6/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 6/2/22 at 9:02 AM
 */
public class LC1_02_ZhiShu {

    /**
     *
     * leetcode 会执行超时
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) return 0;
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean is = true;
            for (int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    is = false;
                    break;
                }
            }
            if(is) {
                System.out.print(" i:" + i);
               count++;
            }
        }

        return ++count;
    }

    public static void main(String[] args) {
        LC1_02_ZhiShu zhiShu = new LC1_02_ZhiShu();
        int count = zhiShu.countPrimes(20);
        System.out.println("count:" + count);
    }
}
