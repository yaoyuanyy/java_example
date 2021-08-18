package com.yy.example.data_structure_and_algorithm.leetcode.simple.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 两数之和
 * <pre>
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-10 at 19:07
 */
public class LC9_SumOfTwoNum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] newArray = method_hash(nums, target);
        for (int i : newArray) {
            System.out.print(i + " ");
        }
    }

    /**
     * 哈希表
     *
     * @param nums
     * @param target
     */
    private static int[] method_hash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
