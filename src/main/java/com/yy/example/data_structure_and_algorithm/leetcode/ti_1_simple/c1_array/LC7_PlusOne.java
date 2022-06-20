package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c1_array;

/**
 * Description:
 * <pre>
 *     加一
 *     给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *     你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *     示例 1：
 *     输入：digits = [1,2,3]
 *     输出：[1,2,4]
 *     解释：输入数组表示数字 123。
 *
 *     from：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-18 at 13:50
 */
public class LC7_PlusOne {

    /**
     * 从低位开始遍历，如果数值不是9，+1后直接结束。如果是9，赋0，进入下一次循环，最后出了循环说明有进位
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }

        int[] newDigits = new int[digits.length + 1];
        // 不需要赋值操作
//        for (int i = 1; i < digits.length; i++) {
//            newDigits[i] = digits[i-1];
//        }
        newDigits[0] = 1;

        return newDigits;
    }

    public static void main(String[] args) {
        LC7_PlusOne plusOne = new LC7_PlusOne();
        int[] nums = {9,9,9};
        int[] result = plusOne.plusOne(nums);

        for (int num : result) {
            System.out.println("num:" + num);
        }
    }
}
