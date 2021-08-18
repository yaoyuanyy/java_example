package com.yy.example.data_structure_and_algorithm.leetcode.simple.array;

/**
 * Description: 加一
 * <pre>
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-10 at 18:27
 */
public class LC7_PlusOne {

    public static void main(String[] args) {
//        int[] array = {4,3,2,1};
        int[] array = {4,3,2,9};
//        int[] array = {9,9,9,9};

        int[] newArray = doCal(array);

        for (int i : newArray) {
            System.out.print(i + " ");
        }
    }

    private static int[] doCal(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            array[i]++;
            array[i] = array[i] % 10;
            if(array[i] != 0) {
                return array;
            }
        }

        array = new int[array.length + 1];
        array[0] = 1;

        return array;
    }

}
