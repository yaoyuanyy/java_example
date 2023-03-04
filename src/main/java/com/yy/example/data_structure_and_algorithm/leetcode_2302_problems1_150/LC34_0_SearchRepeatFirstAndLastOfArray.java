package com.yy.example.data_structure_and_algorithm.leetcode_2302_problems1_150;

import java.util.Arrays;

/**
 * Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * <pre>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * https://labuladong.github.io/algo/di-ling-zh-bfe1b/wo-xie-le--3c789/
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC34_0_SearchRepeatFirstAndLastOfArray {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = getFirst(nums, target);
        ans[1] = getLast(nums, target);
        return ans;
    }

    private int getFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                // 搜索范围：[l, m-1]
                r = m - 1;
            } else if (target < nums[m]) {
                // 搜索范围：[l, m-1]
                r = m - 1;
            } else if (target > nums[m]) {
                // 搜索范围：[m+1, r]
                l = m + 1;
            }
        }
        // 当代码走到这里的时候: l = r + 1
        // 如果 target 大于所有的值，则：r = m; l = m + 1; l = r + 1;
        // 如果 target 小于所有的值，则：r = m - 1; l = m; l = r + 1;

        // 如果target 大于所有的值，则 r 不动，l 会一直右移，直到 l = m + 1 = r + 1 = nums.length
        if (l == nums.length) {
            return -1;
        }

        /**
         * 对于 求左边界元素来说，当 target == nums[m] 时，仍然要执行 r = m - 1，
         * 所以就会产生一种情况：即使找到了元素，r 也可能 < 0; 如 target=1 nums=[1]
         * 所以，当求左边界元素时，不能加 if (r < 0) 的逻辑
         */
        // 如果target 小于所有的值，则 l 不动，r 会一直左移，直到 r = m - 1 = l - 1 = 0 - 1 = -1
        //if (r < 0) {
        //    return -1;
        //}

        // 代码走到这里，说明 target 是在 nums 元素大小中间的，如 target=5 nums=[3, 4, 6, 6, 8]
        // 所以，要判断是否 nums[l] == target
        return nums[l] == target ? l : -1;
    }

    private int getLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                // 找到了一个，我们要找的是最右侧的那个，所以，l 往右移动
                // 搜索范围：[m+1, r]
                l = m + 1;
            } else if (target < nums[m]) {
                // 搜索范围：[l, m-1]
                r = m - 1;
            } else if (target > nums[m]) {
                // 搜索范围：[m+1, r]
                l = m + 1;
            }
        }
        // 当代码走到这里的时候: l = r + 1
        // 如果 target 大于所有的值，则：r = m; l = m + 1; l = r + 1;
        // 如果 target 小于所有的值，则：r = m - 1; l = m; l = r + 1;

        /**
         * 对于 求右边界元素来说，当 target == nums[m] 时，仍然要执行 l = m + 1，
         * 所以就会产生一种情况：即使找到了元素，l == nums.length; 如 target=1 nums=[1]
         * 所以，当求右边界元素时，不能加 if (l == nums.length) 的逻辑
         */
        // 如果target 大于所有的值，则 r 不动，l 会一直右移，直到 l = m + 1 = r + 1 = nums.length
        //if (l == nums.length) {
        //    return -1;
        //}

        // 如果target 小于所有的值，则 l 不动，r 会一直左移，直到 r = m - 1 = l - 1 = 0 - 1 = -1
        if (r < 0) {
            return -1;
        }

        // 代码走到这里，说明 target 是在 nums 元素大小中间的，如 target=5 nums=[3, 4, 6, 6, 8]
        // 所以，要判断是否 nums[l] == target
        return nums[r] == target ? r : -1;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{3, 6, 6, 6, 6, 9, 10, 11};
        int[] arr = new int[]{1};
        int target = 1;
        int[] ans = new LC34_0_SearchRepeatFirstAndLastOfArray().searchRange(arr, target);
        Arrays.stream(ans).forEach(o -> System.out.println(o));
    }
}
