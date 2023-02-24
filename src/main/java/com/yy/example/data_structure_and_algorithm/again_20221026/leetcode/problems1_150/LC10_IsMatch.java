package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.problems1_150;

/**
 * Description: 10. 正则表达式匹配
 * <pre>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * https://leetcode.cn/problems/regular-expression-matching/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC10_IsMatch {

    /**
     *
     * https://leetcode.cn/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/
     * @return
     */
    public boolean isMatch(String s, String p) {
        // todo
        return true;
    }

    public static void main(String[] args) {
        boolean res = new LC10_IsMatch().isMatch("","");
        System.out.println("res:" + res);
    }
}
