package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c1_array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <pre>
 *     两数之和
 *     给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *     你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *     你可以按任意顺序返回答案。
 *
 *     示例 1：
 *     输入：nums = [2,7,11,15], target = 9
 *     输出：[0,1]
 *     解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 *     from：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-18 at 20:50
 */
public class LC9_SumTwoNum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(null != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        LC9_SumTwoNum sumTwoNum = new LC9_SumTwoNum();
        int[] nums = {2,7,11,15};

        int[] result = sumTwoNum.twoSum(nums, 9);

        for (int num : result) {
            System.out.println("num:" + num);
        }
    }
}
