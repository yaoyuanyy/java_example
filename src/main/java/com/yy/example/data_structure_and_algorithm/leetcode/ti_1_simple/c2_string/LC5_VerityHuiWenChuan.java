package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c2_string;

/**
 * Description: 验证回文串
 * <pre>
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-22 at 07:25
 */
public class LC5_VerityHuiWenChuan {

    /**
     * .toCharArray()很耗时，有没有其他方法呢：字符串一个一个取，然后操作，试试
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            while (l < r && !this.isChar(chars[l])) {
                l++;
            }
            while (l < r && !this.isChar(chars[r])) {
                r--;
            }
            if(chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean isChar(char aChar) {
        if(((0 <= aChar - 'a') && (aChar - 'a') <= 25) || ((0 <= aChar - '0') && (aChar - '0') <= 9)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC5_VerityHuiWenChuan verityHuiWenChuan = new LC5_VerityHuiWenChuan();
        String no = "race a car";
        String yes = "A man, a plan, a canal: Panama";
        boolean result = verityHuiWenChuan.isPalindrome("Marge, let's \"[went].\" I await {news} telegram.");
        System.out.println(result);
    }
}
