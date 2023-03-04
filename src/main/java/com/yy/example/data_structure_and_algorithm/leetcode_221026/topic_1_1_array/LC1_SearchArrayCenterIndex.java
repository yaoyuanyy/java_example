package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_1_1_array;

import java.util.Arrays;

/**
 * Description: 寻找数组的中心索引
 * <pre>
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 * 示例 1：
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 *
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/yf47s/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC1_SearchArrayCenterIndex {

    /**
     * 题目说了：左侧所有元素和右边所有的，所有我们可以往先把总数计算出来，然后算一边的和和总数比较
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int tmpSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(2 * tmpSum + nums[i] == total) {
                return i;
            }
            tmpSum += nums[i];
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{1, 7, 3, 6, 5, 6};
        int[] arr = new int[]{1, 2, 3};
//        int[] arr = new int[]{2, 1, -1};

        LC1_SearchArrayCenterIndex searchArrayCenterIndex = new LC1_SearchArrayCenterIndex();
        int targetIndex = searchArrayCenterIndex.pivotIndex(arr);
        System.out.println("targetIndex:" + targetIndex);
    }
}
