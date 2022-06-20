package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c2_string;

/**
 * Description:
 * <pre>
 *     反转字符串
 *     编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 *     不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *     示例 1：
 *
 *     输入：s = ["h","e","l","l","o"]
 *     输出：["o","l","l","e","h"]
 *
 *     from：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-19 at 16:23
 */
public class LC1_ReverseString {

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        LC1_ReverseString reverseString = new LC1_ReverseString();
        char[] s = new char[]{'a','b','c','d'};
        reverseString.reverseString(s);

        for (char c : s) {
            System.out.println(c);
        }

    }
}
