package com.yy.example.java_base.memory;

/**
 * Description:
 * <p></p>
 * <pre>
 *     线程操作栈溢出
 *     jvm参数：-Xms5m -Xmx5m -Xmn2m -XX:NewSize=1m -Xss64k
 *
 *     refer to:
 *     http://www.imooc.com/article/15379
 * </pre>
 * NB.
 * Created by skyler on 2018/4/24 at 下午11:26
 */
public class StackOverflowTest {

    public static void main(String[] args) {
        int i =0;
        digui(i);
    }

    private static void digui(int i){
        System.out.println(i++);
        String[] s = new String[50];
        digui(i);
    }

}