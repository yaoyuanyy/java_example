package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc1_sequence;

/**
 * Description: 最长回文子序列
 * <pre>
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 *
 * https://mirrors.gitcode.host/labuladong/fucking-algorithm/dynamic_programming/StrategiesForSubsequenceProblem.html
 * localhost: 动态规划之子序列问题解题模板.pdf
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_3_LongestHuiWenSubSequence {

    /**
     * 迭代 - 自底向上
     * 我们要求的是数组的回文字串，假设 arr[i+1..j-1] 是回文字串，要想知道 arr[i..j]，只要知道 arr[i+1]，arr[j-1]是否相等
     * if 相等，  那么 arr[i..j] 就是回文字串
     * if 不相等，那么 arr[i..j] 就是不是回文字串，就要看看 arr[i+1..j]，arr[i..j-1] 哪个是回文字串
     *
     * dp table 定义：dp[i][j] 表示 arr[i..j]的最长回文子序列的长度
     *
     * 状态转移方程：
     * dp[i][j] = { dp[i+1][j-1] + 2            if arr[i]=arr[j]
     *            { max(dp[i+1][j], dp[i][j-1]) if arr[i]!=arr[j]
     *
     * 1. base case: 当金额为0时，返回0
     * 2. 确定状态：所谓状态即原问题与子问题之间变化的变量。本题金额在不断的向0值靠近，状态为金额
     * 3. 确定选择：所谓选择即导致 「状态」产生变化的「行为」，本题每选择一个硬币，相当于减少了目标金额
     * 4. 状态转移方程：
     * 4. 确定dp 函数/dp table: 本题可以自顶向下，所以使用 dp 函数，入参为金额 n，出参为凑出金额 n 所需要的最少的硬币数量
     * <p>
     *
     * @return
     */
    public int longestPalindromeSubseq(char[] arr) {
        int size = arr.length;
        // base case
        // i 到 j 的位置，i=j 说明只有一个元素，dp[i][j]=1
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = 1;
        }
        // 只需要关注 i>j 的那些
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i + 1; j < size; j++) {
                // 状态转移方程
                if (arr[i] == arr[j])
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][size-1];
    }

    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(s.toCharArray());
    }

    public static void main(String[] args) {
        int sum = new LC2_3_LongestHuiWenSubSequence().longestPalindromeSubseq("fafdf");
        System.out.println(sum);
    }
}
