package com.yy.example.data_structure_and_algorithm.leetcode.simple.array;

import java.util.HashMap;
import java.util.Objects;

/**
 * Description: 存在重复元素
 * <pre>
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-10 at 12:22
 */
public class LC4_ExistRepeatItem {

    public static void main(String[] args) {
        int[] array = {1,2,3,1};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if(Objects.nonNull(map.get(num))) {
                System.out.println("重复的数：" + map.get(num));
                return;
            }
            map.put(num, num);
        }
    }
}
