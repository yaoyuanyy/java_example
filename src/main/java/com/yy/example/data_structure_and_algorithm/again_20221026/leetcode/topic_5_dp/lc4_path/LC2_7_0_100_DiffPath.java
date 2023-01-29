package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc4_path;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 不同路径
 * <pre>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * <img src="https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png"/>
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_7_0_100_DiffPath {

    /**
     * 暴力递归：自顶向下
     * https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/rtwu06/
     * @param m
     * @param n
     * @return
     */
    Map<String, Integer> map = new HashMap<>();
    public int uniquePaths0(int m, int n) {
//        if(m == 1 || n ==1) {
//            return 1;
//        }
//        int sum = uniquePaths0(m-1, n) + uniquePaths0(m, n-1);
//        return sum;
        if(m == 1 || n ==1) {
            return 1;
        }
        if(map.containsKey(m + "_" + n)) {
            System.out.println(m + "_" + n);
            return map.get(m + "_" + n);
        }
        int sum = uniquePaths0(m-1, n) + uniquePaths0(m, n-1);
        map.put(m + "_" + n, sum);
        return sum;
    }

    /**
     * 暴力递归：自底向上
     * https://leetcode.cn/problems/unique-paths/solution/san-chong-shi-xian-xiang-xi-tu-jie-62-bu-4jz1/
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths00(int m, int n) {
        return 0;
    }

    /**
     * 动态规划：
     * <pre>
     * 按照题目分析：
     * 每个格都可从右侧和下侧的路径到达，即 f(i,j) = f(i-1,j) + f(i,j-1)
     * 所以，我们可以定义：dp[i][j] 表示到达 i,j 的路径总数
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 由于边界处只能从下侧或右侧走，所以 dp[0][j] = 0, dp[i][0]=0
     * </pre>
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            // 0 列：到达 0 列上的格子的路径只有一条：只能向下，所以值为 1
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            // 0 行：到达 0 行上的格子的路径只有一条：只能向右，所以值为 1
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 压缩空间
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int sum = new LC2_7_0_100_DiffPath().uniquePaths0(7, 3);
        System.out.println(sum);
    }
}
