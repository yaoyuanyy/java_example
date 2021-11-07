package com.yy.example.data_structure_and_algorithm.algorithm.book_biancheng_zhuji;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-03-21 at 09:56
 */
public class BinaryFullUtils {

    private static String INIT_VALUE = "00000000000000000000000000000000";

    public static String outFullWithZero(String source) {
        if(StringUtils.isBlank(source)) return "";
        return outFullWithZero(Integer.parseInt(source));
    }

    /**
     * 输出int数值的完整的32位二进制表示形式
     *
     * @param source
     * @return
     */
    public static String outFullWithZero(int source) {
        if(Objects.isNull(source)) {
            return INIT_VALUE;
        }

        String s = Integer.toBinaryString(source);
        int s_length = s.length();
        if(s_length > 32) {
            return INIT_VALUE;
        }

        int init_length = INIT_VALUE.length();
        return INIT_VALUE.substring(0, init_length - s_length) + s;
    }

    public static void main(String[] args) {
//        1000001
//        1000003
//        1000005
//        1000007
//        1000010
        String result = outFullWithZero(1000001);
        System.out.println("result1:" + result + " => length:" + result.length());

        String result2 = outFullWithZero(1000003);
        System.out.println("result2:" + result2 + " => length:" + result2.length());

        String result3 = outFullWithZero(1000005);
        System.out.println("result3:" + result3 + " => length:" + result3.length());

        String result4 = outFullWithZero(1000007);
        System.out.println("result4:" + result4 + " => length:" + result4.length());

        String result5 = outFullWithZero(1000010);
        System.out.println("result5:" + result5 + " => length:" + result5.length());


        String result6 = outFullWithZero(-10);
        System.out.println("result6:" + result6 + " => length:" + result6.length());

        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-1));

    }
}
