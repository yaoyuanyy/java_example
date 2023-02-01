package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_1_2_string.double_point;

/**
 * Description: 两数之和 II - 输入有序数组
 * <pre>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 *
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/cnkjg/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC3_TwoSum2 {

    /**
     * 暴力方法 二分查找
     * 遍历数组，用每个元素与后面的其他元素依次判断
     * 因为数组是有序的，所以可使用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l <= r) {
                int m = (r - l) / 2 + l;
                if (target - nums[i] == nums[m]) {
                    return new int[]{i + 1, m + 1};
                } else if (target - nums[i] < nums[m]) {
                    r = m - 1;
                } else if (target - nums[i] > nums[m]) {
                    l = m + 1;
                }
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 双指针
     * 当时想到这个方法，但是怀疑这样会不会有漏的情况，官方阐述了不会漏的原因
     * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/solution/yi-zhang-tu-gao-su-ni-on-de-shuang-zhi-zhen-jie-fa/
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l <= r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] indexs = new LC3_TwoSum2().twoSum(numbers, 9);
        for (int index : indexs) {
            System.out.print(index + " ");
        }
    }
}
