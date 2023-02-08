package com.yy.example.data_structure_and_algorithm.a_started;

/**
 * Description: LeetCode 827. Making A Large Island(填海造陆问题)（Hard）
 * <pre>
 *
 * https://mp.weixin.qq.com/s?__biz=MzA5ODk3ODA4OQ==&mid=2648167208&idx=1&sn=d8118c7c0e0f57ea2bdd8aa4d6ac7ab7&chksm=88aa236ebfddaa78a6183cf6dcf88f82c5ff5efb7f5c55d6844d9104b307862869eb9032bd1f&token=1064083695&lang=zh_CN#rd
 * </pre>
 */
public class LC7_3_Making_A_Large_Island {

    /**
     * 求岛屿的周长，通过画图，你会发现，周长的边是在海洋与陆地的交界处和小格子是陆地又是边界的加和
     */
    public int makingALargeIsland(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 1) {
                    int perimeter = doMakingALargeIsland(grid, r, c);
                    return perimeter;
                }
            }
        }
        return 0;
    }

    public int doMakingALargeIsland(int[][] grid, int r, int c) {
        // todo
        /// 大前提，格子已经初始化完成：海洋格子值为0；陆地格子值为1；
        /// base case
        // 是大网格边界，即是周长的组成部分
        if(!isArea(grid, r, c)) {
            return 1;
        }
        // 是海洋与陆地的交界处，即是周长的一部分
        if(grid[r][c] == 0) {
            return 1;
        }

        // 此格子已经被访问过，直接返回
        if(grid[r][c] == 2) {
            return 0;
        }

        // 标明已访问
        grid[r][c] = 2;

        // 访问上，下，左，右相邻格子
        return doMakingALargeIsland(grid, r-1,c)
        + doMakingALargeIsland(grid, r+1,c)
        + doMakingALargeIsland(grid, r,c-1)
        + doMakingALargeIsland(grid, r,c+1);
    }

    private boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};

        int max = new LC7_3_Making_A_Large_Island().makingALargeIsland(grid);
        System.out.println("makingALargeIsland:" + max);
    }
}
