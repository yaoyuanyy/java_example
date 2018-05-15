package com.yy.example.java_base.inition_instantion;

/**
 * Description:
 * <p></p>
 * <pre>
 *    refer to https://blog.csdn.net/zerohuan/article/details/50015029
 * </pre>
 * NB.
 * Created by skyler on 2018/5/15 at 下午6:21
 */
public class Instantiation {
    static class C {

        static int pp = 10;

        static {
            System.out.println(" c static 1");
        }

        int i = 2;
        int j;

        public C() {
            doSomething();
        }

        protected void doSomething() {
            System.out.println("C's doSomething");
        }
    }

    static class D extends C {
        // D's doSomething, test_static: 9
        static {
            System.out.println(" d static 1");
        }

        static int test_static = 9;
        final int test_final = 12;
        int test_common = 2;
        int test_no_init_value;

        public D() {
            this.test_common = 3;
        }
        // 结果：D's doSomething, test_static: 0
        //final int test_static = 9;

        // 结果：D's doSomething, test_static: 5；原因：static final类型的变量在.class文件编译的时候就赋值了，即加载.class文件前就赋值了
        //private static final int test_static = 5;


        @Override
        protected void doSomething() {
            // System.out.printf("D's doSomething, test_static:%d  test_final:%d test_common:%d", test_static, test_final, test_common);
            System.out.println("D's doSomething test_static:" + test_static);
            System.out.println("D's doSomething test_final:" + test_final);
            System.out.println("D's doSomething test_common:" + test_common);

        }
    }

    public static void main(final String[] args) {
        final D b = new D();
    }
}
