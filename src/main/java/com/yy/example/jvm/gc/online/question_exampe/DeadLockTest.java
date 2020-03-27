package com.yy.example.jvm.gc.online.question_exampe;

/**
 * Description: 死锁实例展示
 * <p></p>
 * <pre>
 *     https://blog.belonk.com/blog/c/%E4%BD%BF%E7%94%A8visualvm%E7%9B%91%E6%8E%A7Java%E7%A8%8B%E5%BA%8F%E6%80%A7%E8%83%BD%E4%BA%8C%E4%B8%BB%E7%AA%97%E5%8F%A3%E5%8A%9F%E8%83%BD%E8%AF%A6%E8%A7%A3.html
 * </pre>
 * NB.
 * Created by skyler on 2018/5/23 at 下午5:14
 */
public class DeadLockTest {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(final String[] args) {
        new Thread(new MyThread1(lock1, lock2)).start();
        new Thread(new MyThread2(lock1, lock2)).start();
    }
}

class MyThread1 implements Runnable {
    private final Object lock1;
    private final Object lock2;

    public MyThread1(final Object lock1, final Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock1) {
                System.out.println("using lock1");
                synchronized (lock2) {
                    System.out.println("using lock2");
                }
            }
        }
    }
}

class MyThread2 implements Runnable {
    private final Object lock1;
    private final Object lock2;

    public MyThread2(final Object lock1, final Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock2) {
                System.out.println("using lock2");
                synchronized (lock1) {
                    System.out.println("using lock1");
                }
            }
        }
    }
}
