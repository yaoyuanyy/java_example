package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c2_string;

/**
 * Description: 有效的字母异位词
 * <pre>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-21 at 23:25
 */
public class LC4_CharYiWeiCi {

    /**
     *  3个一次for
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] sChar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sChar[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            sChar[t.charAt(i) - 'a']--;
        }
        for (int value : sChar) {
            if (0 != value) {
                return false;
            }
        }

        return true;
    }

    /**
     * 1个一次for todo 没懂
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            //出现了一个新的字符
            if (++map[cs[i] - 'a'] == 1) {
                count++;
            }
            //消失了一个新的字符
            if (--map[ct[i] - 'a'] == 0) {
                count--;
            }
        }
        return count == 0;
    }


    public static void main(String[] args) {
        LC4_CharYiWeiCi charYiWeiCi = new LC4_CharYiWeiCi();
        String s = "bc";
        String t = "cb";
        boolean result = charYiWeiCi.isAnagram2(s, t);
        System.out.println(result);
    }
}
