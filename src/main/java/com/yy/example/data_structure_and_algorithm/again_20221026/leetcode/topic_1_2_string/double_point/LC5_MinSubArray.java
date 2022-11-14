package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_1_2_string.double_point;

/**
 * Description: 长度最小的子数组
 * <pre>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/c0w4r/
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC5_MinSubArray {

    /**
     * 暴力法
     * 两层for循环，从左向右找目标数据
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    // 为啥这里用break呢，找到了就返回了，本次后面的元素在外循环就会处理了
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * 滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                len = Math.min(len, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] numbers = new int[]{2,3,1,2,4,3};
//        int target = 11;
//        int[] numbers = new int[]{1,1,1,1,1,1,1,1};
        int maxCount = new LC5_MinSubArray().minSubArrayLen2(target, numbers);
        System.out.print(maxCount);
    }
}
