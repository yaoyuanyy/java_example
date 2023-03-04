package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_1_2_string;

/**
 * Description: 翻转字符串里的单词
 * <pre>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 *
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/crmp5/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC3_ReverseWords {

    public String reverseWords(String s) {
        return "";
    }

    public static void main(String[] args) {
//        String str = "the sky is blue";
        String str = "  hello world  ";
        LC3_ReverseWords reverseWords = new LC3_ReverseWords();
        String reversedWords = reverseWords.reverseWords(str);
        System.out.println("reversedWords:" + reversedWords);
    }
}
