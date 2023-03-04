package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_1_2_string;

/**
 * Description: 最长公共前缀
 * <pre>
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/ceda1/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC1_LongestPublicPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String baseStr = strs[0];
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length() == i || strs[j].charAt(i) != c) {
                    return baseStr.substring(0, i);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {

//        String[] strArray = new String[]{"flower","flow","flight"};
        String[] strArray = new String[]{"flower","flower","flower","flower"};
        LC1_LongestPublicPrefix longestPublicPrefix = new LC1_LongestPublicPrefix();
        String longestCommonPrefix = longestPublicPrefix.longestCommonPrefix(strArray);
        System.out.println("longestCommonPrefix:" + longestCommonPrefix);
    }
}
