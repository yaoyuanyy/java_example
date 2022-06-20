package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c9_other;

import java.util.*;

/**
 * Description: 有效的括号
 * <pre>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *   有效字符串需满足：
 *   1.左括号必须用相同类型的右括号闭合。
 *   2.左括号必须以正确的顺序闭合。
 *  
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnbcaj/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 6/6/22 at 10:44 AM
 */
public class LC5_ValidBracket {

    /**
     * https://leetcode.cn/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                if(stack.isEmpty() || !map.get(c).equals(stack.pop())) {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    /**
     * 整体思路：如果字符是左侧括号，那么它的配对右侧符号进栈，如果是字符本身就是右侧符号，则弹出栈顶元素与之相等比较
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        if(s == null) return true;
        if(s.length() % 2 != 0) return false;
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if(c == '(') {
                stack.addFirst(')');
            }else if(c == '{') {
                stack.addFirst('}');
            }else if(c == '[') {
                stack.push(']');
            }else if(stack.isEmpty() || c != stack.poll()) {
                // c代表的是右侧符号，所以，如果栈为空，说明不成对，自然是整体字符串无效，所以return false
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LC5_ValidBracket validBracket = new LC5_ValidBracket();
        String s = "]";
//        String s = "{[]}";
        System.out.println(validBracket.isValid2(s));
    }
}
