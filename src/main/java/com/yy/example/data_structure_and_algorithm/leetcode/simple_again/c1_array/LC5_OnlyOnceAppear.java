package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c1_array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <pre>
 *  只出现一次的数字
 *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *  说明：
 *  你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 *  示例 1:
 *  输入: [2,2,1]
 *  输出: 1
 *
 *  示例 2:
 *  输入: [4,1,2,1,2]
 *  输出: 4
 *
 *  from https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-16 at 18:55
 */
public class LC5_OnlyOnceAppear {

    /**
     * 异或运算：相同为0，不同为1
     * a ^ a = 0;
     * 0 ^ a = a;
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int tmp = 0;
        for (int num : nums) {
            tmp = tmp ^ num;
        }
        return tmp;
    }

    /**
     * 使用Set操作
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
       Set<Integer> set = new HashSet();
        for (int num : nums) {
            if(!set.add(num)) {
                set.remove(num);
            }
        }
        return (int)set.toArray()[0];
    }

    public static void main(String[] args) {
        LC5_OnlyOnceAppear onlyOnceAppear = new LC5_OnlyOnceAppear();
        int[] nums = {4,1,2,1,2};
        int num = onlyOnceAppear.singleNumber2(nums);
        System.out.println("num:" + num);
    }
}
