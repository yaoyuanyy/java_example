package com.yy.example;

/**
 * Description:
 * <p></p>
 * <pre>
 *     refer to https://blog.csdn.net/zerohuan/article/details/50015029
 * </pre>
 * NB.
 * Created by skyler on 2018/5/15 at 上午8:14
 */
public class Init_Instante {

    private static class A {
        static {
            System.out.println("类A初始化开始...");
        }
        //父类包含子类的static引用
        private static B b = new B();
        protected static int aInt = 9;

        static {
            System.out.println("类A初始化结束...");
        }

        public static void main(String[] args) {

        }
    }

    private static class B extends A {
        static {
            System.out.println("类B初始化开始...");
        }
        //子类的域依赖于父类的域
        private static int bInt = 9 + A.aInt;

        public B() {
            //构造器依赖类的static域
            System.out.println("类B的构造器调用 " + "bInt的值" + bInt);
        }

        static {
            System.out.println("类B初始化结束... " + "aInt的值：" + bInt);
        }

        public static void main(String[] args) {

        }
    }
}
