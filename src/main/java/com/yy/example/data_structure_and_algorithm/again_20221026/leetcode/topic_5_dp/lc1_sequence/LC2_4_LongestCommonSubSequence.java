package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc1_sequence;

/**
 * Description: 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 *   输入：text1 = "abcde", text2 = "ace"
 *   输出：3
 *   解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * https://mirrors.gitcode.host/labuladong/fucking-algorithm/dynamic_programming/LongestCommonSubsequence.html
 * https://leetcode.cn/problems/longest-common-subsequence/
 *
 * 最长公共子序列（Longest Common Subsequence，简称 LCS）是一道非常经典的面试题目，
 * 因为它的解法是典型的二维动态规划，大部分比较困难的字符串问题都和这个问题一个套路，比如说编辑距离。
 * 而且，这个算法稍加改造就可以用于解决其他问题，所以说 LCS 算法是值得掌握的。
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_4_LongestCommonSubSequence {

    /**
     * 迭代 - 自底向上
     * 两个字符串的子序列问题都可以使用 dp[][] 的动态规划来解决。典型的二维动态规划
     * 首先画出二维数组表，如下
     * <img src="https://mirrors.gitcode.host/labuladong/fucking-algorithm/pictures/LCS/dp.png"/>
     *
     * 第一步：一定要明确 dp 数组的含义
     * dp[i][j] 的含义是：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]。
     *
     * 第二步，定义 base case。
     * 我们专门让索引为 0 的行和列表示空串，dp[0][..] 和 dp[..][0] 都应该初始化为 0，这就是 base case。
     *
     * 第三步，找状态转移方程。
     * 得到状态转移方程的过程：https://leetcode.cn/problems/longest-common-subsequence/solution/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/
     *
     *    dp[i][j] = { dp[i−1][j−1]+1              if text1[i] =text2[j]
     *               { max(dp[i-1][j], dp[i][j-1]) if text1[i]!=text2[j]
     * <p>
     *
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M+1][N+1];
        // base case dp[0][..]=0; dp[..][0]=0;
        // 默认已经是 0 了
        // 0 位置已经是 base case 了
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        int sum = new LC2_4_LongestCommonSubSequence().longestCommonSubsequence("abcde", "ace");
        System.out.println(sum);
    }
}
