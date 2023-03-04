package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_5_dp.lc5_dajiajieshe;

/**
 * Description: 198. 打家劫舍
 * <pre>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 链接：
 * https://leetcode.cn/problems/house-robber
 * https://mp.weixin.qq.com/s/z44hk0MW14_mAQd7988mfw
 *
 * </pre>
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_8_1_Rob {

    /**
     * 状态：房屋里的钱
     * 选择：偷与不偷
     * dp[i]：前 i 个房屋获取的最多金额
     * 子问题：对第 i 个房屋来说，如果不偷，dp[i] 就是前 i-1 个房屋的最多金额；如果偷就是前 i-2 个房屋 + 第 i 个房屋的金额
     * 状态转移方程：dp[i] = max(dp[i-1], dp[i-2]+nums[i])
     * base case：只有一个房屋时，最多金额为 dp[0]=nums[0]
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    /**
     * 压缩空间
     * dp[i] 只与 dp[i-1] 和 dp[i-2] 有关，所以，长度为 2 的数组就够了
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[2];
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = dp[1];
            dp[1] = Math.max(dp[1], dp[0]+nums[i]);
            dp[0] = tmp;
        }
        return dp[1];
    }

    public int rob3(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        // base case
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = second;
            second = Math.max(second, first+nums[i]);
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,1};
        int sum = new LC2_8_1_Rob().rob(prices);
        System.out.println(sum);
    }
}
