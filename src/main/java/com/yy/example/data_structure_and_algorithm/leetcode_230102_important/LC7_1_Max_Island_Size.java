package com.yy.example.data_structure_and_algorithm.leetcode_230102_important;

/**
 * Description: LeetCode 695. Max Area of Island （Medium）
 *
 * <pre>
 *
 * https://mp.weixin.qq.com/s?__biz=MzA5ODk3ODA4OQ==&mid=2648167208&idx=1&sn=d8118c7c0e0f57ea2bdd8aa4d6ac7ab7&chksm=88aa236ebfddaa78a6183cf6dcf88f82c5ff5efb7f5c55d6844d9104b307862869eb9032bd1f&token=1064083695&lang=zh_CN#rd
 * </pre>
 */
public class LC7_1_Max_Island_Size {

    /**
     * LeetCode 695. Max Area of Island （Medium）
     * 求出每个岛屿的面积，找出最大的那个，返回即可
     *
     * 思路：遍历每个格子，如果是陆地格子，则从它向外扩散，执行 dfs 遍历，加上相应逻辑即可
     */
    public int maxAreaOfLand(int[][] grid) {
        int max = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 1) {
                    int size = doMaxAreaOfLand(grid, r, c);
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    public int doMaxAreaOfLand(int[][] grid, int r, int c) {
        /// 大前提，格子已经初始化完成：海洋格子值为0；陆地格子值为1；
        /// base case
        // 超出网格边界，直接返回
        if(!isArea(grid, r, c)) {
            return 0;
        }
        // 此格子为海洋格子，非陆地格子，扩散终止，直接返回
        if(grid[r][c] == 0) {
            return 0;
        }

        // 此格子已经被访问过，直接返回
        if(grid[r][c] == 2) {
            return 0;
        }

        // 标明已访问
        grid[r][c] = 2;

        // 访问上，下，左，右相邻格子
        return 1 + doMaxAreaOfLand(grid, r-1,c)
        + doMaxAreaOfLand(grid, r+1,c)
        + doMaxAreaOfLand(grid, r,c-1)
        + doMaxAreaOfLand(grid, r,c+1);
    }

    private boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,0,1,1},
                {1,1,1,0,0},
                {1,1,0,0,1},
                {0,1,0,1,1}};

        int max = new LC7_1_Max_Island_Size().maxAreaOfLand(grid);
        System.out.println("max:" + max);
        // res.forEach(i -> System.out.println(i));
    }
}
