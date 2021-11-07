package com.yy.example.java.synchronized_;

import org.openjdk.jol.info.ClassLayout;

/**
 * Description: 锁升级过程
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-02 at 23:54
 */
public class SynchronizedUpgradeTest {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(6000);
        System.out.println("===================== 无锁");
        Object o2 = new Object();
        System.out.println(">>>>>>>>>>>>>>>>>> current thread " + Thread.currentThread().getName() + "\n" + ClassLayout.parseInstance(o2).toPrintable());

        //休眠5s，JVM启动了偏向锁
        System.out.println("=====================> 偏向锁");
        new Thread(() -> {
            synchronized (o2) {
                System.out.println(">>>>>>>>>>>>>>>>>> current thread " + Thread.currentThread().getName() + "\n" + ClassLayout.parseInstance(o2).toPrintable());
            }
        }).start();

        Thread.sleep(1000);

        System.out.println("=====================>> 轻量级锁");
        new Thread(() -> {
            synchronized (o2) {
                System.out.println(">>>>>>>>>>>>>>>>>> current thread " + Thread.currentThread().getName() + "\n" + ClassLayout.parseInstance(o2).toPrintable());
            }
        }).start();

        Thread.sleep(1000);

        System.out.println("=====================>>> 重量级锁");
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                synchronized (o2) {
                    System.out.println(">>>>>>>>>>>>>>>>>> current thread " + Thread.currentThread().getName() + "\n" + ClassLayout.parseInstance(o2).toPrintable());
                }
            }).start();
        }
    }
}
