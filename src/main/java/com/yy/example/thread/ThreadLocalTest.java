package com.yy.example.thread;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/19 at 下午8:57
 */
public class ThreadLocalTest {

    //final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    final ThreadLocal<Integer> threadLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return 0;
        }
    };

    public static void main(final String[] args) {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        System.out.println(threadLocalTest.test());
    }

    public int test() {
        threadLocal.set(threadLocal.get() + 1);
        return threadLocal.get();
    }

}
