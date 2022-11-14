package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.interviews;

/**
 * Description: 300. 最长递增子序列
 * <pre>
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 * 分析参考：https://juejin.cn/post/6951922898638471181#heading-13
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-12 at 14:29
 */
public class LC300_longest_increasing_subsequence {

    /**
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4
     *
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     *
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {10,9,2,5,3,7,101,18};
        int maxLength = getMaxLength(array);
        System.out.println("maxLength:" + maxLength);
    }


    /**
     * 方法一：动态规划 子序列的问题 -> 动态规划。
     * 解释：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-e/
     *
     * @param array
     * @return
     */
    private static int getMaxLength(int[] array) {
        int[] result = new int[array.length];
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if(array[i] > array[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
            max = Math.max(max, result[i]);
            out(i, result, max);
        }
        return max;
    }

    /**
     * 方法二：贪心 + 二分查找
     *
     */
    private static int getMaxLength2(int[] array) {
        return 0;
    }

    private static void out(int i, int[] result, int max) {
        System.out.print("i:" + i + " max:" + max + " result:");
        for (int i1 : result) {
            System.out.print(" " + i1);
        }
        System.out.println();

    }
}
