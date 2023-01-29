package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc4_path;

import java.util.Arrays;

/**
 * Description: 最小路径和
 * <pre>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * https://leetcode.cn/problems/minimum-path-sum/
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_7_2_100_MinPathSum {

    /**
     * 暴力递归
     * <p>
     * https://labuladong.github.io/algo/3/28/86/
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        return pathSum(grid, r - 1, c - 1);
    }

    private int pathSum(int[][] grid, int row, int clo) {
        System.out.println("row:" + row + " clo:" + clo);
        if (row == 0 && clo == 0) {
            return grid[0][0];
        }
        if (row < 0 || clo < 0) {
            return Integer.MAX_VALUE;
        }
        return Math.min(pathSum(grid, row - 1, clo), pathSum(grid, row, clo - 1)) + grid[row][clo];
    }

    /**
     * 备忘录递归
     * <p>
     * https://labuladong.github.io/algo/3/28/86/
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        return 0;
    }

    /**
     * 动态规划
     * 题目求最小值，有两条路可到达。所以求两条路的最小值
     * dp[i][j]为到达 i,j 的最小值
     * 则：dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + arr[i][j]
     * base case:
     * 当 i=0，j=0时， dp[0][0] = arr[0][0]
     * 当 i=0，j!=0时，dp[0][j] = dp[0][j-1] + arr[0][j] // 第一行的各列
     * 当 i!=0，j=0时，dp[i][0] = dp[i-1][0] + arr[i][0] // 第一列的各行
     * 当 i>0，j>0时， dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + arr[i][j]
     * <p>
     * https://leetcode.cn/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode-solution/
     *
     * @param grid
     * @return
     */
    public int minPathSum3(int[][] grid) {
        int row = grid.length;
        int clo = grid[0].length;
        int[][] dp = new int[row][clo];
        // base case
        dp[0][0] = grid[0][0];
        // 各行第一列
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        // 各列第一行
        for (int j = 1; j < clo; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < clo; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][clo-1];
    }

    public static void main(String[] args) {
        int[][] prices = {{1, 3, 1}, {1, 5, 1}, {4,2,1}};
        int sum = new LC2_7_2_100_MinPathSum().minPathSum(prices);
        System.out.println(sum);
    }
}
