package com.yy.example.java.java_base.inition_instantion;

/**
 * Description: 初始化，这个一个特殊的类实例化过程，原因是父类中有子类的静态实例引用，这么做会产生问题
 * <p></p>
 * <pre>
 * 对象的初始化顺序：
 * （1）类加载之后，按从上到下（从父类到子类）执行被static修饰的语句；
 * （2）当static语句执行完之后,再执行main方法；
 * （3）如果有语句new了自身的对象，将从上到下执行构造代码块、构造器（两者可以说绑定在一起）
 *
 * refer to https://blog.csdn.net/zerohuan/article/details/50015029
 * </pre>
 * NB.
 * Created by skyler on 2018/5/15 at 上午8:14
 */
public class Initation {

    private static class A {
        static {
            System.out.println("类A初始化开始...");
        }

        //父类包含子类的static引用
        private static final B b = new B();
        protected static int aInt = 9;

        static {
            System.out.println("类A初始化结束...");
        }

        public static void main(final String[] args) {

        }
    }

    private static class B extends A {
        static {
            System.out.println("类B初始化开始...");
        }

        //子类的域依赖于父类的域
        private static final int bInt = 9 + A.aInt;

        public B() {
            //构造器依赖类的static域
            System.out.println("类B的构造器调用 " + "bInt的值" + bInt);
        }

        static {
            System.out.println("类B初始化结束... " + "aInt的值：" + bInt);
        }

        public static void main(final String[] args) {

        }
    }


}
