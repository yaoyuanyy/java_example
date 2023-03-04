package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_1_2_string;

/**
 * Description: 实现 strStr()
 * <pre>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/cm5e2/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC3_StrStr {

    public int strStr(String haystack, String needle) {
        int strIndex = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(strIndex)) {
                strIndex++;
            }else {
                i = i - strIndex;
                strIndex = 0;
            }

            if(strIndex == needle.length()) {
                return i - strIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";

//        String haystack = "hello";
//        String needle = "ll";
        LC3_StrStr strStr = new LC3_StrStr();
        int index = strStr.strStr(haystack, needle);
        System.out.println("index:" + index);
    }
}
