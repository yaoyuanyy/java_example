package com.yy.example.mutil_thread.thread;

import java.util.Objects;

/**
 * <pre>
 *  疑问：每次set get方法时，会确定往table的哪个下标处存放/获取 value, 即执行这个算法：
 *  int i = threadLocalMap.threadLocalHashCode & (table.length - 1);
 *  我的疑问是如果table扩容了。即table.length变大了，如何获取到当初没有扩容前存放的value呢
 *
 *  下面的代码的就是这个疑问的实践
 *  结论：扩容时会将已有的数据重新计算table.new length的下标后，把原位置的value赋值到新下标下。
 *  get时会按照新下标获取
 *  int i = threadLocalMap.threadLocalHashCode & (new length - 1);
 *
 * </pre>
 */
public class ThreadLocalWithExpandCapTest {

    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // testBinaryNum();
        ThreadLocal<String> tl1 = new ThreadLocal<>();
        ThreadLocal<String> tl2 = new ThreadLocal<>();
        ThreadLocal<String> tl3 = new ThreadLocal<>();
        ThreadLocal<String> tl4 = new ThreadLocal<>();
        ThreadLocal<String> tl5 = new ThreadLocal<>();
        ThreadLocal<String> tl6 = new ThreadLocal<>();
        ThreadLocal<String> tl7 = new ThreadLocal<>();
        ThreadLocal<String> tl8 = new ThreadLocal<>();
        ThreadLocal<String> tl9 = new ThreadLocal<>();
        ThreadLocal<String> tl10 = new ThreadLocal<>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread name" + Thread.currentThread().getName());

                tl1.set("01");
                System.out.println("tl1");
                tl2.set("02");
                System.out.println("tl2");
                tl3.set("03");
                System.out.println("tl3");
                tl4.set("04");
                System.out.println("tl4");
                tl5.set("05");
                System.out.println("tl5");
                tl6.set("06");
                System.out.println("tl6");
                tl7.set("07");
                System.out.println("tl7");
                tl8.set("08");
                System.out.println("tl8");
                tl9.set("09");
                System.out.println("tl9");

                // 由于 threshold = INITIAL_CAPACITY * 2 / 3 = 16 * 2 / 3 = 10，所以这里会进行扩容(原来的2倍)
                tl10.set("10");
                System.out.println("tl10");

                System.out.println("tl1 value:" + tl1.get());
            }
        });

        thread.start();
        // thread.join();
        System.out.println("thread.join exec ed");
    }

}
