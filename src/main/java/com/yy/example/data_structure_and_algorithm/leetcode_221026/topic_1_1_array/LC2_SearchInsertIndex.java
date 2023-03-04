package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_1_1_array;

/**
 * Description: 搜索插入位置 二分查找的应用 ＊
 * <pre>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 链接：
 * https://leetcode.cn/leetbook/read/array-and-string/cxqdh/
 * https://leetcode.cn/problems/search-insert-position/solution/sou-suo-cha-ru-wei-zhi-by-leetcode-solution/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_SearchInsertIndex {

    /**
     * O(logn)的时间复杂度，又因为题目给的数组是有序的，所以，直接想到了二分查找
     *
     * @param nums
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // question: 为什么返回的是l，而不是r呢  参考 leetcode @munpf
        return l;

    }
    /**
     * O(n)的时间复杂度的时候，最基础的计算方式
     * @param nums
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }


    public static void main(String[] args) {
        //[1,3,5,6], target = 5 ==> 2
        //[1,3,5,6], target = 2 ==> 1
        //[1,3,5,6], target = 7 ==> 4
        int[] arr = new int[]{1,3,5,6}; int target = 7;
        LC2_SearchInsertIndex searchInsertIndex = new LC2_SearchInsertIndex();
        int targetIndex = searchInsertIndex.searchInsert2(arr, target);
        System.out.println("targetIndex:" + targetIndex);
    }
}
