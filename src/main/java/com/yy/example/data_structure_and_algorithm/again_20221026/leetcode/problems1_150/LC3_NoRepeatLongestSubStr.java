package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.problems1_150;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;

/**
 * Description: 3. 无重复字符的最长子串
 * <pre>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2/10/23 at 9:55 AM
 */
public class LC3_NoRepeatLongestSubStr {

    /**
     * 滑动窗口 左右两个指针在移动过程中计算两个指针的距离长度，移动时不断记录长度最大值，最终的最大值即为答案
     *
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLen = 0;
        // 两个指针：left指针是窗口左边界，i为窗口右边界
        // 两个指针的距离产生len，最大的len即为答案，即最大的窗口即为答案
        // 每次遍历都会移动窗口右指针，同时计算窗口长度，只是左指针的移动是在有重复元素时
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])) {
                // 窗口左指针移动
                // +1的原因是left为窗口内的左边界，
                // 如abca，当右有边界是第二个a时，左边界是第一个a的位置+1，即b的位置
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            // 计算窗口长度，记录最大长度
            // +1的原因是：i 和 left都是窗口内的元素，所以两个边界相减后，要+1。
            // 如窗口为[2,4]，内容是2，3，4，长度是3，即4-2+1=3
            maxLen = Math.max(maxLen, i - left + 1);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aab";
        int len = new LC3_NoRepeatLongestSubStr().lengthOfLongestSubstring(s);
        System.out.println("res len:" + len);
    }
}
