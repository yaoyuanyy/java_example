/**
 * Description:
 * <pre>
 *     easy 数组的总结
 *   LC1     反转字符串                      使用两个指针 left right (一层while)
 *   LC2     整数反转                        (一层while) 使用取模，取整，乘10等操作
 *   LC3     字符串中的第一个唯一字符          两次for + 借助字符与int的关系巧用数组下标 / 两次for + 使用map
 *   LC4     有效的字母异位词                 三次for + 借助字符与int的关系巧用数组下标 / 一次for todo 没懂
 *   LC5     验证回文串                      使用两个指针 left right (两层while) 外层里有两个while
 *   LC6     字符串转换整数 (atoi)            一层for + 借助字符与int的关系巧用数组下标
 *   LC7 重要-实现 strStr() 函数 - 经典算法    (两层for) 暴力法 / 一层for 暴力法2：进阶 / 使用 KMP 算法
 *   LC9     最长公共前缀                     (两层for) + 纵向扫描 / (两层for) + 横向扫描 / (两层 for while) + string内方法
 *
 *   from https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2uudv/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-14 at 08:18
 */
package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c2_string;
