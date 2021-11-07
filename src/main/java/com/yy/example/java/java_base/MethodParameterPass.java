package com.yy.example.java.java_base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:
 * <p>
 * <b>方法参数传递相关知识点</b>
 * </p>
 * <pre>
 *     值传递（pass by value）
 *          是指在调用函数时将实际参数复制一份传递到函数中，这样在函数中如果对参数进行修改，将不会影响到实际参数。
 *
 *     引用传递（pass by reference）
 *          是指在调用函数时将实际参数的地址直接传递到函数中，那么在函数中对参数所进行的修改，将影响到实际参数。
 *
 *     结论：Java中其实还是值传递的，只不过对于对象参数，值的内容是对象的引用(首地址)
 *
 *     refer to:
 *          https://juejin.im/entry/5ac187ad6fb9a028e52dfaee
 * </pre>
 * NB.
 * Created by skyler on 2018/4/24 at 上午11:00
 */
public class MethodParameterPass {

    public static void main(final String[] args) {
        final int count = 5;
        intValueOpr(count);
        System.out.println("调用方法-->intValueOpr后的的结果: value:" + count);

        final String s = "test";
        StrValueOpr(s);
        System.out.println("调用方法-->StrValueOpr后的的结果: value:" + s);

        final Person p = new MethodParameterPass().new Person("test", 1);
        PersonValueOpr(p);
        System.out.println("调用方法-->PersonValueOpr后的的结果: value:" + p);

    }

    /**
     * int类型值传递
     *
     * @param num
     */
    public static void intValueOpr(int num) {
        System.out.println("opr int before:" + num);
        num++;
        System.out.println("opr int after:" + num);
    }

    /**
     * String类型值传递
     *
     * @param value
     */
    public static void StrValueOpr(String value) {
        System.out.println("opr string before:" + value);
        value = "s";
        System.out.println("opr string after:" + value);
    }

    /**
     * Person类型值传递
     *
     * @param p
     */
    public static void PersonValueOpr(final Person p) {
        System.out.println("opr person before:" + p);
        p.setName("new name");
        System.out.println("opr person after:" + p);
    }

    @Data
    @AllArgsConstructor
    class Person {
        private String name;
        private int age;
    }
}
