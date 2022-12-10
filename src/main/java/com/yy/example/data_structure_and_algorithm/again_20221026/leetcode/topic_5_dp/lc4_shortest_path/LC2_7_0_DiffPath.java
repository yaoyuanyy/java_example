package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc4_shortest_path;

/**
 * Description: 不同路径
 * <pre>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_7_0_DiffPath {

    /**
     * 暴力方法
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j]-prices[i] > 0) {
                    max = Math.max(max, prices[j]-prices[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int sum = new LC2_7_0_DiffPath().maxProfit1(prices);
        System.out.println(sum);
    }
}
