package com.yy.example.data_structure_and_algorithm.leetcode_2302_problems1_150;

/**
 * Description: 5. 最长回文子串
 * <pre>
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC5_LongestPalindrome {

    /**
     * 暴力法
     * 两指针相向移动 -> <-
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            // i不动，j向右移动，然后相向移动对比相等性
            for (int j = i + 1; j < s.length(); j++) {
                if(j - i > maxLen && palindrome(s, i, j)) {
                    begin = i;
                    maxLen = j - i;
//                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        // 此处+1的原因：试想s="a"，这时代码根本不会进入for循环，s是回文子串，所以+1
        // 再想，begin的位置本身就占了回文子串的一个位置，所以相减时要+1，把占的位置扣除
        return s.substring(begin, begin + maxLen + 1);
    }

    // 相向移动i j，比较数值
    private boolean palindrome(String s, int i, int j) {
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--; // 向左移动
            i++; // 向右移动
        }
        // 代码走到这里，说明这段字符串是回文子串
        return true;
    }

    /**
     * 中心扩散法
     * 两指针反向移动 <- ->
     * 注意事项：对于一个位置，扩散时不知道回文串是奇偶，所以，扩散时的奇偶都要扩散，最后取较大的那个
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int maxLen = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = palindrome2(s, i, i);
            int len2 = palindrome2(s, i, i + 1);
            int curLen = Math.max(len1, len2);
            if(curLen > maxLen) {
                begin = i - (curLen - 1)/2;
                maxLen = curLen;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // i 向左移动，j 向右移动 《---i 中心位置 j---》
    private int palindrome2(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        // 代码执行到这里，i位置和j位置是++ --后的位置，这两个位置值是不相等的
        // i 和 j 的位置已经不是回文子串的位置了，左右各多移动了一步，
        // ccbaabee
        //  i    j，baab是回文子串，所以长度len=j-i-1
        return j - i - 1;
    }


    public static void main(String[] args) {
        String s = "ccc";
        String res = new LC5_LongestPalindrome().longestPalindrome(s);
        System.out.println("res:" + res);
    }
}
