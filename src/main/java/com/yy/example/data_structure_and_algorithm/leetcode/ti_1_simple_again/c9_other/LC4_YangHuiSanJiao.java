package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c9_other;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 杨辉三角
 * <pre>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *        1
 *       1,1
 *      1,2,1
 *     1,3,3,1
 *    1,4,6,4,1
 *
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xncfnv/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 6/6/22 at 8:38 AM
 */
public class LC4_YangHuiSanJiao {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    row.add(1);
                }else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        LC4_YangHuiSanJiao yangHuiSanJiao = new LC4_YangHuiSanJiao();
        List<List<Integer>> result = yangHuiSanJiao.generate(5);
        result.stream().forEach(o -> {
            o.stream().forEach(o2 -> System.out.print(o2 + ","));
            System.out.println();
        });
    }
}
