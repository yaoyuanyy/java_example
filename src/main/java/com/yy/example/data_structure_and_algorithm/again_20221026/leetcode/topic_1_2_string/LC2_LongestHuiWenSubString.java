package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_1_2_string;

/**
 * Description: 最长回文子串
 * <pre>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 链接：
 * https://leetcode.cn/leetbook/read/array-and-string/conm7/
 * https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvn3ke/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 6/8/22 at 9:30 AM
 */
public class LC2_LongestHuiWenSubString {

    /**
     * 暴力方法
     * 整体思路：截取所有的字串，判断哪些是回文串，选出最长的那个，返回
     *
     * https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvn3ke/ 参见：数据结构和算法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if(s.length() <= 1) return s;
        int len = 0;
        int begin = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                // j - i > len的含义：我们要的最长的回文子串，所以，即使j - i是回文子串，但是长度小于已得到的len长度，所以直接跳过
                // 这是一个优化的点，对核心思路没有影响
                if(j - i > len && isPalindrome(s, i, j)) {
                    begin = i;
                    len = j - i;
//                  len = Math.max(len, j - i);
                }
            }
        }
        return s.substring(begin, begin + len + 1);
    }

    /**
     * 左右两个指针，相向而行，l向右，r向左  --》《--
     * 即从两个方向向中间方向靠拢
     * @param s
     * @param i
     * @param j
     * @return
     */
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * https://leetcode.cn/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/ 查看视频
     * 方法二：中心扩散算法
     * 整体思路：
     * 1. 枚举所有可能的回文子串的中心位置
     * 2. 中心位置可能是一个字符，也可能是两个相邻的字符
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int maxLen = 0;
        int start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 因为中心位置可能是一个字符，也可能是两个相邻的字符，即奇偶子串，所以，每个位置都要看奇偶的情况
            int len = palindrome(chars, i, i); // 奇数
            int len2 = palindrome(chars, i, i + 1); // 偶数
            int currentLen = Math.max(len, len2);
            if(currentLen > maxLen) {
                maxLen = currentLen;
                start = i - (maxLen - 1)/2; // 这里乍一看是不好理解的，可以看视频中的讲述
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 向两个方向分散，判断是否为回文子串 《--- 中心位置 ---》
     * @param chars
     * @param l
     * @param r
     * @return
     */
    private int palindrome(char[] chars, int l, int r) {
        while (l >= 0 && r < chars.length) {
            if(chars[l] != chars[r]) {
                break;
            }
            l--;
            r++;
        }
        // 当while跳出循环走到这里时，说明 chars[l] != chars[r]
        // 所以，回文子串的len长度是: r - l + 1 - 2 = r - l -1
        return r - l - 1;
    }

    /**
     * 方法二：中心扩散算法
     * 整体思路：
     * 1. 枚举所有可能的回文子串的中心位置
     * 2. 中心位置可能是一个字符，也可能是两个相邻的字符
     * longestPalindrome2方法有一处不太好理解，所以，可以看下labuladong的方式
     * 参考 https://labuladong.github.io/algo/1/5/
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        char[] chars = s.toCharArray();
        String resMax = "";
        for (int i = 0; i < chars.length; i++) {
            String res1 = palindrome2(s, i, i);
            String res2 = palindrome2(s, i, i + 1);
            resMax = resMax.length() > res1.length() ? resMax: res1;
            resMax = resMax.length() > res2.length() ? resMax: res2;
        }

        return resMax;
    }

    private String palindrome2(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }


    /**
     * 方法三：动态规划
     * https://leetcode.cn/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/ 查看视频
     *
     * @param s
     * @return
     */
    public String longestPalindrome4(String s) {

        return null;
    }

    public static void main(String[] args) {
        String s = "babad";
//        String s = "cbbd";
//        String s = "ac";
        LC2_LongestHuiWenSubString longestHuiWenSubString = new LC2_LongestHuiWenSubString();
        String longestHuiWenSunString = longestHuiWenSubString.longestPalindrome3(s);
        System.out.println(longestHuiWenSunString);
    }
}
