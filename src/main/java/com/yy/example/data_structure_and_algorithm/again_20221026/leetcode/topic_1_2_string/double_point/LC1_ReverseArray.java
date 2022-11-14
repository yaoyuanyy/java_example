package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_1_2_string.double_point;

/**
 * Description: 反转数组
 * <pre>
 * 让我们从一个经典问题开始：
 * 反转数组中的元素。比如数组为 ['l', 'e', 'e', 't', 'c', 'o', 'd', 'e']，反转之后变为 ['e', 'd', 'o', 'c', 't', 'e', 'e', 'l']。
 * 使用双指针技巧，其思想是分别将两个指针分别指向数组的开头及末尾，然后将其指向的元素进行交换，再将指针向中间移动一步，继续交换，直到这两个指针相遇。
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/cmf5c/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC1_ReverseArray {

    /**
     * 使用双指针
     *
     * @param s
     * @return
     */
    public char[] reverseArray(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l <= r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
        return s;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'l', 'e', 'e', 't', 'c', 'o', 'd', 'e'};
        char[] reversedChars = new LC1_ReverseArray().reverseArray(chars);
        for (char reversedChar : reversedChars) {
            System.out.print(reversedChar + " ");
        }
    }
}
