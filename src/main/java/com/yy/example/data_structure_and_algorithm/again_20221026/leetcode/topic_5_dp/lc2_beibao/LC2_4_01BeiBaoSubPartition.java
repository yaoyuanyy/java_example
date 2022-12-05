package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp.lc2_beibao;

/**
 * Description: 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * </pre>
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_4_SubBeibao {

    /**
     * 1. 确定状态
     * 根据题目，状态是背包的容量 w，可选择物品 n
     *
     * 2. 确定选择
     * 对每个物品，选择有两个：装进背包，不装进背包
     *
     * 3. 状态转移方程
     * dp[i][w] 表示将前 i 个物品放进一个容量为 w 背包中，可以获取的最大价值
     * 选择1: 第 i 个物品放进背包， 那么  dp[i][w] = dp[i-1][w-wArr[i-1]] + valArr[i]
     * 选择2: 第 i 个物品不放进背包，那么 dp[i][w] = dp[i-1][w]
     * 最后，max(选择1，选择2)
     *
     * @return
     */
    public boolean canPartition(int[] nums) {
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {};
        boolean res = new LC2_4_SubBeibao().canPartition(nums );
        System.out.println(res);
    }
}
