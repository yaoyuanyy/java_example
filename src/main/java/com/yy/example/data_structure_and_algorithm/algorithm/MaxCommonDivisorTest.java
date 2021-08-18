package com.yy.example.data_structure_and_algorithm.algorithm;

/**
 * Description: 求两个数的最大公约数
 * <pre>
 *  最大公约数：来源：算法设计与分析基础 第三版-第一章
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-06-30 at 11:59
 */
public class MaxCommonDivisorTest {

    public static void main(String[] args) {
        int a = 12;
        int b = 28;
//        int maxCommonDivisor = doByOuJiLiD(a, b);
         int maxCommonDivisor = doByDiminishOfMinValue(a, b);
        System.out.println("maxCommonDivisor:" + maxCommonDivisor);
    }

    /**
     * 使用欧几里得算法
     *
     * gcd(60, 24) = gcd(24, 60 % 24)=gcd(12, 24%12)=gcd(12, 0)=12
     * while(b !=0){
     *     r -> a % b;
     *     a -> b;
     *     b -> r;
     * }
     * return a;
     *
     * @param a
     * @param b
     * @return
     */
    private static int doByOuJiLiD(int a, int b) {
        if(a < 1 || b < 1){
            return 0;
        }
        if(a == 1 || b == 1){
            return Math.max(a, b);
        }
        if(b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (b != 0){
            int mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }

    /**
     * 拿到较小的数，从它开始逐一减一，然后分别使用a, b除以减一后的值，都能除尽时，即是最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static int doByDiminishOfMinValue(int a, int b) {
        if(a < 1 || b < 1){
            return 0;
        }
        if(a == 1 || b == 1){
            return Math.max(a, b);
        }
        int tmp = Math.min(a, b);
        for (int i = tmp - 1; i > 0; i--) {
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 0;
    }
}
