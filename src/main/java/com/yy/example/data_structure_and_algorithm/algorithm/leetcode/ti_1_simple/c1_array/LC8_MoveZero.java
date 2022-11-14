package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c1_array;

/**
 * Description:
 * <pre>
 *     移动零
 *     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *     请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *     示例 1:
 *     输入: nums = [0,1,0,3,12]
 *     输出: [1,3,12,0,0]
 *
 *     示例 2:
 *     输入: nums = [0]
 *     输出: [0]
 *
 *     from：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-18 at 15:23
 */
public class LC8_MoveZero {

    /**
     * 自我实现，先找到0的位置，在其后找到第一个不是0的位置，互换
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            if(nums[i] == 0) {
                int index = i;
                while (index < length-1) {
                    if(nums[++index] != 0) {
                        nums[i] = nums[index];
                        nums[index] = 0;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 指针法
     * index指向0元素的位置，index为找到指向0元素的位置
     *
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length){
            nums[index++] = 0;
        }
    }

    /**
     * 双指针
     * index指向0元素的位置，i遍历循环。思路是把0元素放后移动
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;

                index++;
            }
        }

    }

    public static void main(String[] args) {
        LC8_MoveZero moveZero = new LC8_MoveZero();
        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,0,1};

        moveZero.moveZeroes3(nums);

        for (int num : nums) {
            System.out.println("num:" + num);
        }
    }
}
