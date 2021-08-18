package com.yy.example.data_structure_and_algorithm.leetcode.simple.array;

/**
 * Description: 旋转数组
 * <pre>
 *  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。\
 *
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-09 at 08:20
 */
public class LC3_RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        // 5,6,7,1,2,3,4
        int[] newNums = rotate2(nums, 3);

    }

    /**
     * 方法一：使用额外的数组
     * 复杂度分析
     *    时间复杂度： O(n)O(n)，其中 nn 为数组的长度。
     *    空间复杂度： O(n)O(n)。
     *
     * @param nums
     * @param rotateStep
     * @return
     */
    private static int[] rotate1(int[] nums, int rotateStep) {
        if(rotateStep < 1) {
            return nums;
        }

        if(rotateStep >= 7) {
            rotateStep = rotateStep % 7;
        }

        int[] newArray = new int[7];
        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i + rotateStep) % nums.length;
            newArray[newIndex] = nums[i];
        }

        return newArray;
    }

    /**
     * 方法三：数组翻转
     * 复杂度分析
     *    时间复杂度：O(n)O(n)，其中 nn 为数组的长度。每个元素被翻转两次，一共 nn 个元素，因此总时间复杂度为 O(2n)=O(n)O(2n)=O(n)。
     *    空间复杂度：O(1)O(1)。
     *
     * @param nums
     * @param rotateStep
     * @return
     */
    private static int[] rotate2(int[] nums, int rotateStep) {
        if (rotateStep < 1) {
            return nums;
        }

        if (rotateStep >= 7) {
            rotateStep = rotateStep % 7;
        }

        doRotate(nums, 0, nums.length);
        out(nums);

        doRotate(nums, 0, rotateStep);
        out(nums);

        doRotate(nums, rotateStep, nums.length);
        out(nums);
        return nums;
    }

    private static void out(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * right即是右边界，
     * @param nums
     * @param left
     * @param right
     */
    private static void doRotate(int[] nums, int left, int right) {
//        int step = right;
//        for (int i = left; i < right; i++) {
//            if(i >= --step){
//                System.out.println("i:" + i + " --> step:" + step);
//                return;
//            }
//            int tmp = nums[i];
//            nums[i] = nums[step];
//            nums[step] = tmp;
//        }
        right = right - 1;
        // 用while循环更适合
        while (left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right --;
        }
    }
}
