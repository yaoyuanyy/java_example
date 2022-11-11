package com.yy.example.data_structure_and_algorithm.again_20221026.ds.linklist.leetcode.topic_1_2_string.double_point;

/**
 * Description: 最大连续1的个数
 * <pre>
 * 给定一个二进制数组 nums，计算其中最大连续 1 的个数。
 *
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/cd71t/
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC5_MaxContinuousOne {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int maxTmp = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] == 1) {
                maxTmp++;
            }else {
                maxCount = Math.max(maxCount, maxTmp);
                maxTmp = 0;
            }
        }
        return Math.max(maxCount, maxTmp);
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 0, 1, 1, 1};
//        int[] numbers = new int[]{1,1,0,1};
        int maxCount = new LC5_MaxContinuousOne().findMaxConsecutiveOnes(numbers);
        System.out.print(maxCount);
    }
}
