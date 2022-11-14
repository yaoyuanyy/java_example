package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c6_dynamic_programing;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description: 打家劫舍
 * <pre>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 链接：
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnq4km/
 * https://leetcode.cn/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/19/22 at 8:01 AM
 */
public class LC4_01_HouseRobber {

    /**
     * 动态规划 dp[] 版本
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // dp[i]: 前 i 个房屋偷的最高金额；为求 dp[i]，只需看 i位置的钱是否偷窃
        // 如果偷窃，dp[i] = nums[i] + dp[i - 2]
        // 如果不偷窃，dp[i] = dp[i - 1]
        // 状态转移方程：dp[i] = max{dp[i - 1], dp[i - 2] + nums[i]}
        int[] dp = new int[nums.length + 1];
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            max = Math.max(max, dp[i]);
        }
        Arrays.stream(dp).forEach(o -> System.out.print(o + " "));
        return max;
    }

    /**
     * 动态规划 优化版本
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = second;
            second = Math.max(second, nums[i] + first);
            first = tmp;
        }
        return second;
    }

    /**
     * 递归
     *
     * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return doRob(nums, nums.length - 1, map);
    }

//    public int doRob(int[] nums, int n) {
//        if(n == 0) {
//            return 0;
//        }
//        // 偷上上家所获取的最高金额
//        int lastLast = doRob(nums, n - 2);
//        int last = doRob(nums, n - 1);
//        int cur = lastLast + nums[n];
//        System.out.println("lastLast:" + lastLast + "last:" + last + "cur:" + cur);
//        return Math.max(cur, last);
//    }

    /**
     * 记忆法搜索
     *
     * @param nums
     * @param n
     * @return
     */
    public int doRob(int[] nums, int n, HashMap<Integer, Integer> map) {
        // todo
        if(n == 0) {
            return 0;
        }
        // 偷上上家所获取的最高金额
        int lastLast = doRob(nums, n - 2, map);
        int last = doRob(nums, n - 1, map);
        int cur = lastLast + nums[n];
        System.out.println("lastLast:" + lastLast + "last:" + last + "cur:" + cur);
        return Math.max(cur, last);
    }

    public static void main(String[] args) {
        LC4_01_HouseRobber daJiaJieShe = new LC4_01_HouseRobber();
        int[] nums = new int[]{2,7,9,3,1};
        int max = daJiaJieShe.rob3(nums);
        System.out.println(max);
    }
}
