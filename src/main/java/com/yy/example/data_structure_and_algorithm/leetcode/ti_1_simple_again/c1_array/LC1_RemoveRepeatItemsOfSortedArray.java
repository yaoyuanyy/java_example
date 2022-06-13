package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c1_array;

/**
 * Description:
 * <pre>
 * 删除排序数组中的重复项
 *   给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *   由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *   将最终结果插入 nums 的前 k 个位置后返回 k 。
 *   不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *   示例 2：
 *   输入：nums = [0,0,1,1,1,2,2,3,3,4]
 *   输出：5, nums = [0,1,2,3,4]
 *   解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *
 *   from https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-14 at 08:21
 */
public class LC1_RemoveRepeatItemsOfSortedArray {


    /**
     * 思路：
     * 1. 使用两个指针 left right，分别指向第一 第二个位置元素。
     * 2. 如果两个位置元素相同，则left 不动，right 右移一个位置
     * 3. 否则，两个元素元素不同，则left 右移一个位置，将right位置元素替换left位置，然后right 右移一个元素，
     *
     * 对于这个逻辑，如果这个目标数据是 0,0,1,1,3,3,3,5,6,6。就比较好理解代码逻辑；如果是0,1,1,3,3,3,5,6,6，就不太好理解
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return ++left;
    }

    public static void main(String[] args) {
        LC1_RemoveRepeatItemsOfSortedArray removeRepeatItems = new LC1_RemoveRepeatItemsOfSortedArray();
        int[] nums = {0,1,1,3,3,3,5,6,6};
        int length = removeRepeatItems.removeDuplicates(nums);
        System.out.println("length:" + length);

        /// 验证
        // 长度正确的期望答案
        int[] expectedNums = {0,1,3,5,6};
        assert length == expectedNums.length;
        for (int i = 0; i < length; i++) {
            System.out.print("num:" + nums[i] + " ");
            assert nums[i] == expectedNums[i];
        }
    }
}