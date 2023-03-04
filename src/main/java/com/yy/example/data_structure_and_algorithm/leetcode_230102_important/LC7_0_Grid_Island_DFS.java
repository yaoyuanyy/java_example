package com.yy.example.data_structure_and_algorithm.leetcode_230102_important;

/**
 * Description: DFS 在网格遍历 - 岛屿问题中的应用思路和实战
 *
 * <pre>
 *
 * https://mp.weixin.qq.com/s?__biz=MzA5ODk3ODA4OQ==&mid=2648167208&idx=1&sn=d8118c7c0e0f57ea2bdd8aa4d6ac7ab7&chksm=88aa236ebfddaa78a6183cf6dcf88f82c5ff5efb7f5c55d6844d9104b307862869eb9032bd1f&token=1064083695&lang=zh_CN#rd
 * </pre>
 */
public class LC7_0_Grid_Island_DFS {

    /**
     * 网格问题 dfs 的通用遍历方法
     *
     * 前提：dfs 是近邻着向外扩散的
     * 二叉树遍历的 dfs 思路完全可以应用到网格遍历
     * 所以，对于网格遍历，我们也可以从两个条件入手
     * 遍历方向：二叉树是左右子节点两个方向；而网格是四个方向，对于小格子(r,c)来说，它的上下左右的相邻格子为：
     * (r-1,c) (r+1,c) (r,c-1) (r,c+1)
     * base case: 二叉树是root = null; 而网格是边界+访问过的格子
     */
    public void dfs(int[][] grid, int r, int c) {
        /// 大前提，格子已经初始化完成：海洋格子值为0；陆地格子值为1；
        /// base case
        // 超出网格边界，直接返回
        if(!isArea(grid, r, c)) {
            return;
        }
        // 此格子为海洋格子，非陆地格子，扩散终止，直接返回
        if(grid[r][c] == 0) {
            return;
        }

        // 此格子已经被访问过，直接返回
        if(grid[r][c] == 2) {
            return;
        }

        // 标明已访问
        grid[r][c] = 2;

        // 访问上，下，左，右相邻格子
        dfs(grid, r-1,c); // 向上扩散
        dfs(grid, r+1,c); // 向下扩散
        dfs(grid, r,c-1); // 向左扩散
        dfs(grid, r,c+1); // 向右扩散
    }

    private boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
}
