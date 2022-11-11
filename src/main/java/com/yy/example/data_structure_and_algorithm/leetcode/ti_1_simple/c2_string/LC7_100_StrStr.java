package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c2_string;

/**
 * Description: 实现 strStr() 函数。
 * <pre>
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
 *
 * 这是经典的子字符串查找问题，参见算法4 P493
 * 方法有暴力计算、KMP
 * ＊ 符号表示重要
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-23 at 08:42
 */
public class LC7_100_StrStr {

    /**
     * 暴力法：
     * 两层for i for j
     * 拿着子串，从大串的开头一个一个字符的比较。
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_baoli1(String haystack, String needle) {
        if("".equals(haystack) || "".equals(needle)) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i < m - n; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if(needle.charAt(j) != haystack.charAt(i+j)) {
                   break;
                }
                tmp++;
            }

            if(tmp == n) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 暴力法2：进阶
     * 一层for
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_baoli2_for(String haystack, String needle) {
        if("".equals(haystack) || "".equals(needle)) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();

        for (int i = 0, j = 0; i < m && j < n; i++) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }else {
                i = i - j;
                j = 0;
            }

            if(j == n) {
                return i - n + 1;
            }
        }

        return -1;
    }

    /**
     * 暴力法2：进阶
     * 使用一层while
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_baoli2_while(String haystack, String needle) {
        if("".equals(haystack) || "".equals(needle)) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }

            if(j == n) {
                return i - n;
            }

            if(j == needle.length()) {
                return i - j;
            }
        }

        return -1;
    }

    /**
     * 使用 KMP 算法。kmp算法关键词：最长前缀，最长后缀，next[]数组
     * 左程云 https://www.bilibili.com/video/BV13g41157hK?p=12 kmp讲解：1:28:18
     * @return
     */
    public int strStr_kmp(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] next = getNextArray(needle);
        while (i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }else if(next[j] == -1) {
                i++;
            } else{
                j = next[j];
            }

            if(j == needle.length()) {
                return i - j;
            }
        }
        return 0;
    }

    private int[] getNextArray(String needle) {
        char[] arr = needle.toCharArray();
        if(arr.length == 0) {
            return new int[]{-1};
        }

        int[] next = new int[arr.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; // next数组的位置
        int cn = 0; // 两个含义：1. 回退的位置 2.和n - 1比较的位置

        while (i < next.length) {
            if(next[i - 1] == next[cn]) {
                next[i++] = ++cn;
            }else if(cn > 0) { // 走这个分支：当前跳到cn位置的字符，与n - 1位置的字符不匹配
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }

        return next;
    }

    public static void main(String[] args) {
        LC7_100_StrStr strStr = new LC7_100_StrStr();
        // mississippi
        String s1 = "issiissippi";
        String s2 = "issip";
        int index = strStr.strStr_kmp(s1, s2);
        System.out.println(index);
    }
}
