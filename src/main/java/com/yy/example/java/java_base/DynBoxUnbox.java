package com.yy.example.java.java_base;

/**
 * Description: 自动装箱和拆箱
 * <p></p>
 * <pre>
 *
 *   NB. https://www.jianshu.com/p/6e0eac9ec392
 * </pre>
 * <p>
 * Created by skyler on 2019-05-15 at 12:45
 */
public class DynBoxUnbox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 333;
        Integer f = 333;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(e.equals(f));
        System.out.println(c == a + b);
        System.out.println(c.equals(a+b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a+b));

        // output:
//        true
//        false
//        true
//        true
//        true
//        true
//        false
    }

}
