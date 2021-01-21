package com.yy.example.java_base.bitset;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Description:
 * <pre>
 *   <<编程珠玑>>习题1.6 第三题
 *   假设n为10 000 000， 且输入文件包含 1 000 000 个正数 ，使用位图排序实现。
 *   本文将使用java实现上述代码。
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020-10-18 at 23:05
 */
public class BitTest {

    static int BITSPERWORD = 32;
    static int SHIFT = 5;

    // 31
    static byte MASK = 0x1F;

    //static int N=10000;
    static int N = 10000000;

    //每个int是4字节32位能存32个数字
    static int a[] = new int[1 + N / BITSPERWORD];

    //随机生成不重复的
    public static Set<Integer> randomGenerate() {
        //set中的值不重复
        long start = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>();
        for (; set.size() < 1000000; ) {
            set.add(new Random().nextInt(10000000));
        }
        System.out.println("set.size():" + set.size() + "   -->   " + (System.currentTimeMillis() - start));
        return set;
    }

    //清除位值
    public static void clr(int i) {
        a[i >> SHIFT] &= ~(1 << (i & MASK));
    }

    //将A[i>>SHIFT]的第(i & MASK)位置1
    public static void set(int i) {
        // i & MASK  相当于 i%31 , 左移 这个位数 就是 余数 在某位设1 ，
        //a[i>>SHIFT] 等同a[i/32] 因为每个int可以保存32个数字
        a[i >> SHIFT] |= (1 << (i & MASK));
    }

    //测试位值
    //测试A[i>>SHIFT]的第(i & MASK)位置是否为1
    public static int test(int i){
        double x = i >> SHIFT;
        double y = Math.log(1 << (i & MASK)) / Math.log(2);
        System.out.println("对应数字" + (x + y));
        return a[i >> SHIFT] & (1 << (i & MASK));
    }
    public static void main(String[] args) {

        Set<Integer> set = randomGenerate();

        for (int i = 0; i < N; i++) {
            clr(i);
        }
        for (Integer a : set) {
            set(a);
        }
        for (int j = 0; j < 31; j++) {
            System.out.println(test(j));
        }

//        for (int i = 0; i < N; i++) {
//            if (test(i) == 1) {
//                System.out.println(i);
//            }
//        }
    }
}
