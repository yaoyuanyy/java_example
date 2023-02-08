package com.yy.example.data_structure_and_algorithm.a_started;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: BFS 的使用场景：层序遍历、最短路径问题
 * <pre>
 *
 * 本章主要涉及最短路径问题，即用BFS 遍历网格问题
 * https://mp.weixin.qq.com/s?__biz=MzA5ODk3ODA4OQ==&mid=2648167212&idx=1&sn=6af5ffe5b69075b21bb4743ddcee4e7c&chksm=88aa236abfddaa7cae70b42edb299d0a52d9f1cc4fc1fdba1116972fc0ca0275b8bfdf10851b&cur_album_id=1338094723818668033&scene=189#wechat_redirect
 * https://leetcode.cn/problems/as-far-from-land-as-possible/solution/li-qing-si-lu-wei-shi-yao-yong-bfs-ru-he-xie-bfs-d/
 * </pre>
 */
public class LC10_Grid_Island_BFS {

    public int maxDistance(int[][] grid) {
        int N = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有的陆地格子加入队列
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // 如果我们的地图上只有陆地或者海洋，请返回 -1。
        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }

        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            // 这里一口气取出 n 个结点，以实现层序遍历
            for (int i = 0; i < n; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                // 遍历上方单元格
                if (r-1 >= 0 && grid[r-1][c] == 0) {
                    grid[r-1][c] = 2;
                    queue.add(new int[]{r-1, c});
                }
                // 遍历下方单元格
                if (r+1 < N && grid[r+1][c] == 0) {
                    grid[r+1][c] = 2;
                    queue.add(new int[]{r+1, c});
                }
                // 遍历左边单元格
                if (c-1 >= 0 && grid[r][c-1] == 0) {
                    grid[r][c-1] = 2;
                    queue.add(new int[]{r, c-1});
                }
                // 遍历右边单元格
                if (c+1 < N && grid[r][c+1] == 0) {
                    grid[r][c+1] = 2;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        return distance;
    }

//    private boolean isArea(int[][] grid, int r, int c) {
//        return 0 <= r && r < grid.length
//                && 0 <= c && c < grid[0].length;
//    }

    public static void main(String[] args) {
        // 0:海洋 1:陆地
        int[][] grid = new int[][]{
                 {0,1,0,0}
                ,{0,0,0,0}
                ,{0,0,0,0}
//                ,{1,0,0,0}
        };

        int max = new LC10_Grid_Island_BFS().maxDistance(grid);
        System.out.println("maxDistance:" + max);
    }
}
