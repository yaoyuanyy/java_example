package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc2_beibao;

/**
 * Description: 目标和
 * <pre>
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * https://leetcode.cn/problems/target-sum/
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_4_01BeiBaoTargetSumWays {

    /**
     * dp[i][j] 表示在数组 nums 的前 i 个选取元素，使之之和等于 neg，计算选取的方案数
     *
     * 零钱兑换1:https://leetcode.cn/problems/coin-change/solution/by-flix-su7s/
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = (sum - target);
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int N = nums.length;
        int W = diff / 2;
        int[][] dp = new int[N + 1][W + 1];
        // base case
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                int remainW = j - nums[i - 1]; // 本行为了 debug
                if (j - nums[i - 1] < 0) {
                    // 说明 j < nums[i-1]，不能选第 i 个元素
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //        不选第 i 个元素 选第 i 个元素，选与不选的方案之和
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 采用空间压缩：内层循环倒序遍历的方式
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = (sum - target);
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int W = diff / 2;
        int[] dp = new int[W + 1];
        // base case
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
//            for (int j = W; j >= 0; j--) {
//                if (j - nums[i] < 0) {
//                    // 说明 j < nums[i-1]，不能选第 i 个元素
//                    dp[j] = dp[j];
//                } else {
//                    //        不选第 i 个元素 选第 i 个元素，选与不选的方案之和
//                    dp[j] = dp[j] + dp[j - nums[i]];
//                }
//            }
            for (int j = W; j >= nums[i]; j--) {
                //        不选第 i 个元素 选第 i 个元素，选与不选的方案之和
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int res = new LC2_4_01BeiBaoTargetSumWays().findTargetSumWays2(nums, target);
        System.out.println(res);
    }
}
