package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c2_string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 字符串中的第一个唯一字符
 * <pre>
 *
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 *
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-21 at 08:38
 */
public class LC3_FirstUniqueCharOfStr {

    /**
     * 两次遍历，使用一个int[]数组
     * 重点：数组下表为 x - 'a'，这样，数组就是有序的了
     * 第一遍先统计每个字符出现的次数，第二遍再次从前往后遍历字符串s中的每个字符，如果某个字符出现一次直接返回，原来比较简单
     *
     * @param s
     * @return
     */
    public int firstUniqChar_method1(String s) {
        int[] values = new int[26];
        //  s.toCharArray().length很耗时，请使用s.length()
        for (int i = 0; i < s.length(); i++) {
            values[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(1 == values[s.charAt(i) - 'a']) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 使用Map
     *
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * @param s
     * @return
     */
    public int firstUniqChar_method2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.toCharArray().length; i++) {
            if(1 == map.get(s.charAt(i))) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LC3_FirstUniqueCharOfStr firstUniqueCharOfStr = new LC3_FirstUniqueCharOfStr();
        String s = "loveleetcode";
        int index = firstUniqueCharOfStr.firstUniqChar_method1(s);

        System.out.println("index:" + index);
    }
}
