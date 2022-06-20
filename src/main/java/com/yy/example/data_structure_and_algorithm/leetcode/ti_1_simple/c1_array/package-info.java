/**
 * Description:
 * <pre>
 *     easy 数组的总结
 *   LC1    删除排序数组中的重复项     使用两个指针 left right(一层for)
 *   LC2    买卖股票的最佳时机 I       (一层for)一个变量记录历史最低价格，一个变量记录最大高低点差值
 *   LC2    买卖股票的最佳时机 II      贪心算法(类似指针) 两层while / 动态规划 / (一层for)相邻元素差值，差值为正数的累加
 *   LC3    旋转数组                  三次反转 / new 一个新数组(一层for)
 *   LC5    存在重复元素              (两层for) / (一层for) 使用set的add方法
 *   LC5    只出现一次的数字           (一层for)异或运算 / (一层for)使用set的add方法
 *   LC6    两个数组的交集 I           (一层while)先排序，再使用双指针 / (两个一层for)使用两个Set集合
 *   LC6    两个数组的交集 II          (一层while)先排序，再使用双指针 / (两个一层for)使用一个Map
 *   LC7    加一                      (一层for) 从后向前开始遍历
 *   LC8    移动零                    使用两个指针 index i(一层for)
 *   LC9    两数之和                  (一层for)使用一个Map
 *   LC10
 *
 *   from https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2i30g/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-14 at 08:18
 */
package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c1_array;
