package com.yy.example.data_structure_and_algorithm.leetcode.ti_2_middle.c1_array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 无重复字符的最长子串
 * <pre>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 链接：
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 *
 * 本题属于滑动窗口题
 *
 * 其他滑动窗口题目:
 * 3.   无重复字符的最长子串
 * 30.  串联所有单词的子串
 * 76.  最小覆盖子串
 * 159. 至多包含两个不同字符的最长子串
 * 209. 长度最小的子数组
 * 239. 滑动窗口最大值
 * 567. 字符串的排列
 * 632. 最小区间
 * 727. 最小窗口子序列
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020-01-04 at 20:23
 */
public class LC4_LongestSubString {

    public static int lengthOfLongestSubstring0(String s) {
        // todo 6月1号
        return 0;
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0; // 用于记录最大不重复子串的长度
        int left = 0; // 滑动窗口左指针 代表的是在第几位上，第一个元素就是第一位，第二个元素就是第二位
        for (int i = 0; i < s.length() ; i++) {
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符 ch 包含在 map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            if(map.containsKey(s.charAt(i))) {
                left = Math.max(left , map.get(s.charAt(i))+1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i) , i);
            maxLen = Math.max(maxLen , i-left+1);
        }

        return maxLen;
    }

    /**
     * 执行用时：
     * 107 ms , 在所有 Java 提交中击败了 6.85% 的用户
     * 内存消耗： 42.1 MB , 在所有 Java 提交中击败了 5.04% 的用户
     * 通过测试用例： 987 / 987
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int tmpMax = 0;
            HashSet set = new HashSet();
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                tmpMax++;
            }

            max = Math.max(max, tmpMax);
        }
        return max;
    }

    public static int test(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

//        System.out.println("length:" + lengthOfLongestSubstring("abba"));
//        System.out.println("length:" + lengthOfLongestSubstring("abb"));
//        System.out.println("length:" + lengthOfLongestSubstring("abcbcabb"));
        System.out.println("length:" + test("abcbcabb"));
    }
}

