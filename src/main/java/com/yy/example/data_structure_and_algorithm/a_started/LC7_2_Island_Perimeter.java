package com.yy.example.data_structure_and_algorithm.a_started;

/**
 * Description: LeetCode 463. Island Perimeter(岛屿的周长)（Easy）
 * <pre>
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地，0 表示海洋。网格中的格子水平和垂直方向相连（对角线方向不相连）。
 * 整个网格被水完全包围，但其中恰好有一个岛屿（一个或多个表示陆地的格子相连组成岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。计算这个岛屿的周长。
 *
 * https://mp.weixin.qq.com/s?__biz=MzA5ODk3ODA4OQ==&mid=2648167208&idx=1&sn=d8118c7c0e0f57ea2bdd8aa4d6ac7ab7&chksm=88aa236ebfddaa78a6183cf6dcf88f82c5ff5efb7f5c55d6844d9104b307862869eb9032bd1f&token=1064083695&lang=zh_CN#rd
 * </pre>
 */
public class LC7_2_Island_Perimeter {

    /**
     * 求岛屿的周长，通过画图，你会发现，周长的边是在海洋与陆地的交界处和小格子是陆地又是边界的加和
     */
    public int perimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 1) {
                    int perimeter = doPerimeter(grid, r, c);
                    return perimeter;
                }
            }
        }
        return 0;
    }

    public int doPerimeter(int[][] grid, int r, int c) {
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
        return doPerimeter(grid, r-1,c)
        + doPerimeter(grid, r+1,c)
        + doPerimeter(grid, r,c-1)
        + doPerimeter(grid, r,c+1);
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

        int max = new LC7_2_Island_Perimeter().perimeter(grid);
        System.out.println("perimeter:" + max);
        // res.forEach(i -> System.out.println(i));
    }
}
