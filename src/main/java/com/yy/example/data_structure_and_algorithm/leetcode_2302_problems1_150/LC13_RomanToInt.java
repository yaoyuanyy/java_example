package com.yy.example.data_structure_and_algorithm.leetcode_2302_problems1_150;

/**
 * Description: 13. 罗马数字转整数
 * <pre>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * https://leetcode.cn/problems/roman-to-integer/
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC13_RomanToInt {

    /**
     * 正常的罗马数字都是左大右小的，所以累加就可以了；但是有特殊的，如果左小右大，那么左边的数就要减
     * 所以，依次来判断一个数是加是减，需要结合它的下一个数字，比较一下，决定是加是减
     */
    public int romanToInt(String s) {
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int val = getValue(s.charAt(i));
            if(i < len - 1 && val < getValue(s.charAt(i+1))) {
                sum -= val;
            }else {
                sum += val;
            }
        }
        return sum;
    }

    private int getValue(char c) {
        switch (c) {
           case  'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case  'L': return 50;
            case 'C': return 100;
            case  'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    public static void main(String[] args) {
//        int[] waters = new int[]{1,8,6,2,5,4,8,3,7};
        String s = "LVIII";
        int res = new LC13_RomanToInt().romanToInt(s);
        System.out.println("res:" + res);
    }
}
