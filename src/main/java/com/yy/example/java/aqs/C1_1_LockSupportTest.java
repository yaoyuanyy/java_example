package com.yy.example.java.aqs;

import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

/**
 * Description:
 * <pre>
 *  在通过{@link C1_0_BasicLockByAQSTest} 了解了ReentrantLock 和 AQS后，线程的阻塞是通过LockSupport.park()方法的，而LockSupport.park()
 *  又是通过Unsafe.park(false, 0L)实现的，Unsafe.park是native的，那么不禁要问，jvm是怎么实现的阻塞的，系统又是怎么实现的阻塞呢？
 *  正是带着这些个疑问，通过运行 {@link C1_1_LockSupportTest} 此类，观察线程的运行情况，来了解系统层面的实现原理
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-09 at 16:43
 */
public class C1_1_LockSupportTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("park开始");
            LockSupport.park();
            System.out.println("park结束");
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println("unpark开始");
            LockSupport.unpark(t1);
            System.out.println("unpark结束");
        }, "t2");

        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("输入“1”启动t1线程，输入“2”启动t2线程，输入“quit”退出");
        while (!(input = scanner.nextLine()).equals("quit")) {
            if (input.equals("1")) {
                if (t1.getState().equals(Thread.State.NEW)) {
                    t1.start();
                }
            } else if (input.equals("2")) {
                if (t2.getState().equals(Thread.State.NEW)) {
                    t2.start();
                }
            }
        }
    }
}
