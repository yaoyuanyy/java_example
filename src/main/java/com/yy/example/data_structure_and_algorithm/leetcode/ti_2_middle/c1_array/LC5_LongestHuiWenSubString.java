package com.yy.example.data_structure_and_algorithm.leetcode.ti_2_middle.c1_array;

/**
 * Description: 最长回文子串
 * <pre>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvn3ke/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 6/8/22 at 9:30 AM
 */
public class LC5_LongestHuiWenSubString {

    /**
     * 暴力方法
     * 核心思路：依次从每个元素开始，计算每个元素与后面的每个元素之间的子串是否为回文串，并记录一个max值下标和起始点下标，最后结果就是题解
     *
     * 其他方法还有动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int max_begin = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if(j - i > max && isPalindrome(chars, i, j)) {
                    max = Math.max(max, j - i);
                    max_begin = i;
                }
            }
        }
        return s.substring(max_begin, max_begin + max + 1);
    }

    /**
     * i 与 j 之间的数组元素是否为回文字符串
     *
     * @param chars
     * @param i
     * @param j
     * @return
     */
    public boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if(chars[i] != chars[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
//        String s = "cbbd";
        LC5_LongestHuiWenSubString longestHuiWenSubString = new LC5_LongestHuiWenSubString();
        String longestHuiWenSunString = longestHuiWenSubString.longestPalindrome(s);
        System.out.println(longestHuiWenSunString);
    }
}
