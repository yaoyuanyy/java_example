package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c7_design;

import java.util.Arrays;
import java.util.Random;

/**
 * Description:
 * <pre>
 * 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 *
 * 实现 Solution class:
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn6gq1/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 6/1/22 at 11:20 AM
 */
public class LC1_01_Shuffle_Array {

    static class Solution {
        Random random;
        int[] source;
        public Solution(int[] nums) {
            source = nums;
            random = new Random();
        }

        public int[] reset() {
            return source;
        }

        /**
         * 使用洗牌算法
         *
         * @return
         */
        public int[] shuffle() {
            int[] tmp = source.clone();
            for (int i = 0; i < tmp.length; i++) {
                int j = random.nextInt(tmp.length);
                swap(tmp, i, j);
            }

            return tmp;
        }

        public void swap(int[] a, int i, int j){
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        Solution solution = new Solution(array);
        int[] shuffleArray = solution.shuffle();
        Arrays.stream(shuffleArray).forEach(o -> System.out.print(o + " "));
    }
}
