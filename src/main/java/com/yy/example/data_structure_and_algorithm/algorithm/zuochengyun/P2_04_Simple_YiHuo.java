package com.yy.example.data_structure_and_algorithm.algorithm.zuochengyun;

/**
 * Description: 异或运算
 * <pre>
 *     异或运算：
 *       1. 相同的两个数异或为0：A ^ A = 0
 *       2. 任何的数与0异或都为其本身：A ^ 0 = A
 *       3. 异或运算符合交互律和结合律：A ^ B ^ C = C ^ A ^ B = A ^ (B ^ C)
 *     异或运算的应用
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-28 at 11:07
 */
public class P2_04_Simple_YiHuo {
    public static void main(String[] args) {
        //apply1(1, 2);
        // apply2();
        // System.out.println(11000010 & (~11000010 + 1));
        apply3();
    }

    /**
     * 两个数交换数值
     */
    private static void apply1(int a, int b) {
        System.out.println("交换前 a:" + a + " b:" + b);
        a = a ^ b;
        b = a ^ b; // => a ^ a ^ b = b
        a = a ^ b; // => a ^ b ^ b = a

        System.out.println("交换后 a:" + a + " b:" + b);
    }

    /**
     * 一个数组中只有一种数出现奇数次，找出来
     */
    private static void apply2() {
        int[] array = {2, 1, 1, 2, 5, 9, 66, 3, 3, 66, 9};
        int eOR = 0;
        for (int num : array) {
            eOR ^= num;
        }
        System.out.println("target nu=:" + eOR);
    }

    /**
     * 一个数组中只有两种数出现奇数次，找出来
     */
    private static void apply3() {
        int[] array = {2, 1, 1, 2, 5, 9, 66, 3, 66, 9};
        int eOR = 0;

        for (int num : array) {
            eOR ^= num;
        }
        System.out.println("eOR:" + eOR);

        // 此时 eOR包含两种数：出现奇数次的那两种数
        // 思路：这两种数，肯定不相同，即不相等，那么eOR ≠ 0，因为 eOR ≠ 0，所以，所以 eOR 的二进制上肯定某一位是1。假设第6位是1
        // 即这两种数的二进制上肯定至少有一位是不同的，要么一个0，一个1；要么一个1，一个0。
        // 此时，就可将数组的数据分为两拨：一波第6位都是1，另一波第6位都是0，
        // 操作：计算出 eOR 的二进制的最右侧的1位置
        int rightOne = eOR & (~eOR + 1);  // 举例：11000010 & (~11000010 + 1) = 00000010

        int eOROfHalf = 0;
        for (int num : array) {
            // 找出第六位是0 (xxxxx0xx) 的那些值
            if((num & rightOne) == 0) {
                eOROfHalf ^= num;
            }
        }

        System.out.println("target eOROfHalf:" + eOROfHalf + " eOR:" + (eOR ^= eOROfHalf));
    }
}
