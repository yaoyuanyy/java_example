package com.yy.example.data_structure_and_algorithm.algorithm.zuochengyun;

/**
 * Description: 贪心算法 - N皇后问题
 * <pre>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 链接：https://leetcode-cn.com/problems/n-queens
 *
 * https://www.bilibili.com/video/BV13g41157hK?p==9 02:30:00
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/3/22 at 9:46 PM
 */
public class P9_04_NHuangHou {

    /**
     * 暴力解法
     * @param n
     * @return
     */
    public int num0(int n) {
        // todo
        return 0;
    }

    public int num1(int n) {
        if(n < 1) {
            return 0;
        }

        int[] records = new int[n]; // record[i] => i 行的皇后，放在第几列
        return process(records, 0, n);
    }

    private int process(int[] records, int i, int n) {
        if(i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if(this.isValid(records, i, j)) {
                records[i] = j;
                res += process(records, i + 1, n);
            }
        }
        return res;
    }

    private boolean isValid(int[] records, int i, int j) {
        for (int k = 0; k < i; k++) { // 之前的某个k行的皇后
            //                    // 行号减的差值 = 列号减的差值
            if(records[k] == j || Math.abs(records[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P9_04_NHuangHou nHuangHou = new P9_04_NHuangHou();
        System.out.println(nHuangHou.num1(4));
    }
}
