package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c1_array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * <pre>
 *  Tips: 这道题是判断数组有没有重复的，同时没有移动元素的要求，{@link LC5_OnlyOnceAppear} 也是，它是判断数组中哪个是不重复的。
 *  而{@link LC1_RemoveRepeatItemsOfSortedArray} 在重复元素的同时，有元素的移动的要求
 *  所以，可以总结：前这两道题都涉及数组的元素重复问题但没有移动要求，解法上都可以使用Set来操作。而涉及移动时，则需要其他解法
 *
 *  存在重复元素
 *    给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *  
 *    示例 1：
 *    输入：nums = [1,2,3,1]
 *    输出：true
 *
 *    示例 2：
 *    输入：nums = [1,2,3,4]
 *    输出：false
 *
 *    from https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-16 at 16:20
 */
public class LC4_ExistRepeatArray {

    /**
     * 暴力法：两层for循环
     *
     * @param nums
     * @return
     */
    private boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用map的contains方法
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(data.containsKey(nums[i])) {
                return true;
            }
            data.put(nums[i], nums[i]);
        }

        return false;
    }

    /**
     * 使用set的add方法
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> data = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!data.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC4_ExistRepeatArray existRepeatArray = new LC4_ExistRepeatArray();
        int[] nums = {1,2,3,4,5,6,1};
        boolean exist = existRepeatArray.containsDuplicate3(nums);
        System.out.println("exist:" + exist);
    }
}
