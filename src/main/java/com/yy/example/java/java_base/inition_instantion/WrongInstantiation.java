package com.yy.example.java.java_base.inition_instantion;

/**
 * Description:
 * <p></p>
 * <pre>
 *     运行结果：
 *      B's doSomething, bInt: 0
 *
 *     这是因为：
 *     类A构造器中调用了doSomething，从输出结果中我们看到实际上调用的是子类的方法实现，而此时子类的实例化还未开始，因此bInt并没有如“预期”那样是9,而是0；
 *     这就是由于动态绑定，doSomething是一个protected方法，因此它是通过invokevirtual指令调用的，该指令根据对象实例的类型找到对应的方法实现（这里就是B的实例对象，对应方法就是类B的方法实现）执行，故而有此结果。
 *     结论：正如前面说的“不要在构造器，clone方法和readObject方法中调用可被覆盖的方法”；
 *
 *     扩展：如果bInt变量定义为final或static, 运行结果：B's doSomething, bInt: 9。 原因你思考一下，结果可以参考有道笔记常考面试题中类的初始化那个知识点
 *
 *     refer to https://blog.csdn.net/zerohuan/article/details/50015029
 * </pre>
 * <p>
 * Created by skyler on 2018/5/15 at 下午6:53
 */
public class WrongInstantiation {
    private static class A {
        public A() {
            doSomething();
        }

        protected void doSomething() {
            System.out.println("A's doSomething");
        }
    }

    private static class B extends A {
        int bInt = 9; // B's doSomething, bInt: 0

        //final int bInt = 9; // B's doSomething, bInt: 9
        //static int bInt = 9; // B's doSomething, bInt: 9

        @Override
        protected void doSomething() {
            System.out.println("B's doSomething, bInt: " + bInt);
        }
    }

    public static void main(final String[] args) {
        final B b = new B();
    }
}
