package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc4_path;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 63. 不同路径 II
 * <pre>
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <img src="https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg"/>
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_7_1_DiffPath2 {

    /**
     * 动态规划
     * 参考不同路径 {@link LC2_7_0_100_DiffPath}，现在某个格式有障碍物了。
     * 所以，有障碍物的 dp[ii][jj] 的数量就不能加到 dp[i][j] 中了，即 dp[ii][jj]=0;
     * 注意边界问题：如果障碍物在边界上，那么障碍物及其后的格子的到达路径总数就是 0 了
     *
     * https://leetcode.cn/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/ @行如火
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            // 0 列上如果有格子时障碍物，那么障碍物以后的格子都无法到达，所以，保持默认值 0 即可
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            // 0 行上如果有格子时障碍物，那么障碍物以后的格子都无法到达，所以，保持默认值 0 即可
            if(obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] != 1) {
                    // 一旦遇到障碍物，说明到达障碍物的路径都是不通的，所以路径总数赋值为 0
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[3][7];
        int sum = new LC2_7_1_DiffPath2().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(sum);
    }
}
