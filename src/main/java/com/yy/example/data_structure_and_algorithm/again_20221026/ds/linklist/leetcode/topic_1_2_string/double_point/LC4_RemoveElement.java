package com.yy.example.data_structure_and_algorithm.again_20221026.ds.linklist.leetcode.topic_1_2_string.double_point;

/**
 * Description: 移除元素
 * <pre>
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/cwuyj/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC4_RemoveElement {

    /**
     * 双指针 快慢指针：
     * 快慢指针同向开始向右，快指针每次移动一个元素，慢指针遇到目标元素时停下，快指针的元素覆盖掉慢指针的元素，然后快慢指针都向右移动一个元素。重复开始步骤
     *
     * while版本
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if(nums[fast] == val) {
                fast++;
            }else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }

    /**
     * 双指针 快慢指针：
     * 快慢指针同向开始向右，快指针每次移动一个元素，慢指针遇到目标元素时停下，快指针的元素覆盖掉慢指针的元素，然后快慢指针都向右移动一个元素。重复开始步骤
     *
     * for版本
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
//        int target = 2;
//        int[] numbers = new int[]{0,1,2,2,3,0,4,2};
        int target = 3;
        int[] numbers = new int[]{3,2,2,3};
        int len = new LC4_RemoveElement().removeElement(numbers, target);
            System.out.print(len + " ");
    }
}
