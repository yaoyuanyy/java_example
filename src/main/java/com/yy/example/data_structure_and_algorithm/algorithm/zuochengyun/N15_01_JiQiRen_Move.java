package com.yy.example.data_structure_and_algorithm.algorithm.zuochengyun;

/**
 * Description: 动态规划面试题之机器人运动问题
 * <pre>
 * 给你几个参数：
 * N：代表总共有多少个位置。
 * S：机器人的出发位置。
 * E：机器人的目的地。
 * K：机器人必须走K步。
 * 问题：请你求出机器人从S起始位置走K步到达终止位置E，一共有多少种走法？注意，每次机器人必须走一步，不能留在原地，每次只能走一格，可以向右或者向左。
 *
 * https://www.bilibili.com/video/BV13g41157hK?p=17
 * https://icode.best/i/12676841595346
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/11/22 at 2:21 PM
 */
public class N15_01_JiQiRen_Move {

    /**
     * 暴力递归法
     *
     * @param N 一共1~n个位置
     * @param E 目的地
     * @param K 走多少步
     * @param S 当前位置
     * @return 在cur位置，还有rest步可以到达E，有多少种方法
     */
    public int walkWays1(int N, int E, int K, int S) {
        return move1(N, E, K, S);
    }

    /**
     * 暴力递归法
     *
     * @param N    一共1~n个位置
     * @param E    目的地
     * @param rest 还剩多少步要走
     * @param cur  当前位置
     * @return 在cur位置，还有rest步可以到达E，有多少种方法
     */
    public int move1(int N, int E, int rest, int cur) {
        /// 递归的 base case
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        /// 说明还有步可以走
        if (cur == 1) {
            // 此时，左侧没路，只能往右侧走
            return move1(N, E, rest - 1, 2);
        }
        if (cur == N) {
            // 此时，右侧没路，只能往左侧走
            return move1(N, E, rest - 1, N - 1);
        }
        // 可以向右走 or 可以向左走
        return move1(N, E, rest - 1, cur + 1) + move1(N, E, rest - 1, cur - 1);
    }

    /**
     * 记忆化搜索
     *
     * @param N 一共1~n个位置
     * @param E 目的地
     * @param K 走多少步
     * @param S 当前位置
     * @return 在cur位置，还有rest步可以到达E，有多少种方法
     */
    public int walkWays2(int N, int E, int K, int S) {
        int[][] arr = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                arr[i][j] = -1;
            }
        }
        return move2(N, E, K, S, arr);
    }

    public int move2(int N, int E, int rest, int cur, int[][] arr) {
        /// 用缓存，缓存中有值就直接返回
        if (arr[rest][cur] != -1) {
            return arr[rest][cur];
        }
        /// 递归的 base case & 建缓存
        if (rest == 0) {
            arr[rest][cur] = (cur == E ? 1 : 0);
            return arr[rest][cur];
        }
        /// 说明还有步可以走
        if (cur == 1) {
            // 此时，左侧没路，只能往右侧走
            arr[rest][cur] = move2(N, E, rest - 1, 2, arr);
        } else if (cur == N) {
            // 此时，右侧没路，只能往左侧走
            arr[rest][cur] = move2(N, E, rest - 1, N - 1, arr);
        } else {
            // 可以向右走 or 可以向左走
            arr[rest][cur] = move2(N, E, rest - 1, cur + 1, arr) + move2(N, E, rest - 1, cur - 1, arr);
        }
        return arr[rest][cur];
    }

    public static void main(String[] args) {
        N15_01_JiQiRen_Move jiQiRen_move = new N15_01_JiQiRen_Move();
        System.out.println("jiQiRen_move.move(5, 4, 4, 1) => " + jiQiRen_move.move1(5, 4, 4, 1));
        System.out.println("jiQiRen_move.move(5, 4, 4, 2) => " + jiQiRen_move.move1(5, 4, 4, 2));
    }
}
