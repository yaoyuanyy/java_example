package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c2_string;

/**
 * Description: 最长公共前缀
 * <pre>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-29 at 09:12
 */
public class LC9_LongestPublicPrefix {

    /**
     * 纵向扫描 最容易想到的方法
     *
     * 外层for是列，内层for是行
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        // todo 明天
        return null;
    }

    /**
     * 纵向扫描
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if(0 == strs.length) {
            return "";
        }
        if(1 == strs.length) {
            return strs[0];
        }

        String s1 = strs[0];
        // i代表纵向的字符的遍历
        for (int i = 0; i < s1.length(); i++) {
            // j代表数组的每个元素的遍历
            char c = s1.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return s1.substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 横向扫描
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(0 == strs.length) {
            return "";
        }
        if(1 == strs.length) {
            return strs[0];
        }
        String longestStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longestStr = getLongestStr(longestStr, strs[i]);
            if(0 == longestStr.length()) {
                return "";
            }
        }
        return longestStr;
    }

    private String getLongestStr(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if(i >= s2.length() || s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1;
    }

    /**
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnmav1/
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if(0 == strs.length) {
            return "";
        }
        if(1 == strs.length) {
            return strs[0];
        }
        String longestStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(longestStr) != 0){
                // 不断的截取
                longestStr = longestStr.substring(0, longestStr.length() - 1);
            }
        }
        return longestStr;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flo","floght"};
        // "flower","flow","flight"
        // "dog","racecar","car"
        LC9_LongestPublicPrefix longestSamePrefix = new LC9_LongestPublicPrefix();
        String str = longestSamePrefix.longestCommonPrefix3(strs);
        System.out.println(str);
    }
}
