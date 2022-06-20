package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c1_array;

/**
 * Description:
 * <pre>
 *     旋转数组
 *     给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *     示例 1:
 *     输入: nums = [1,2,3,4,5,6,7], k = 3
 *     输出: [5,6,7,1,2,3,4]
 *     解释:
 *     向右轮转 1 步: [7,1,2,3,4,5,6]
 *     向右轮转 2 步: [6,7,1,2,3,4,5]
 *     向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 *     进阶：
 *     尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 *     你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *     https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-14 at 23:33
 */
public class LC3_XunZhuanArray {

    /**
     * new 一个新数组
     *
     * 空间复杂度：O(n)
     * 时间复杂度：O(n)
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if(null == nums || nums.length == 1) {
            return;
        }
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % newNums.length] = nums[i];
        }
        out(newNums);
    }

    /**
     * 三次反转
     * 空间复杂度：O(1)
     * 时间复杂度：O(n)
     * * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if(null == nums || nums.length == 1) {
            return;
        }

        this.reverse(nums, 0, nums.length - 1);
        this.reverse(nums, 0, k - 1);
        this.reverse(nums, k, nums.length - 1);

        out(nums);
    }

    private void reverse(int[] nums, int from, int to) {
        if(from>= to) {
            return;
        }
        while (from < to) {
            int tmp = nums[from];
            nums[from] = nums[to];
            nums[to] = tmp;
            from++;
            to--;
        }
    }

    /**
     * 每旋转一次，将最后一个值存储，数组依次往后移，最后将存储的值放入a[0],这样的操作执行K次（性能不佳）
     * k可能大于数组长度，取余
     * 空间复杂度：O(1)
     * 时间复杂度：O(n*k)
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
        out(nums);
    }

    private void out(int[] newNums) {
        System.out.println();
        for (int num : newNums) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LC3_XunZhuanArray xunZhuanArray = new LC3_XunZhuanArray();
        int[] nums = {1,2,3,4,5,6,7};
        //            5,6,7,1,2,3,4
        int k = 3;
//        xunZhuanArray.rotate1(nums, k);
//        xunZhuanArray.rotate2(nums, k);
        xunZhuanArray.rotate3(nums, k);
    }
}
