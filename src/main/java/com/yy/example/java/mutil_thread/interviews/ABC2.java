package com.yy.example.java.mutil_thread.interviews;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:如何优雅的让3个线程打印ABC
 * <pre>
 * 方案：ReentrantLock + 全局类变量 current
 * 参考：https://juejin.cn/post/6940274452559036453
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/19 at 10:05
 */
public class ABC2 implements Runnable{

    /** 类变量 */
    static final Lock lock = new ReentrantLock();
    int target;
    /** 类变量，变量属于类，而不是实例，所以多个线程可以共同对其值进行更新 */
    static int current;
    /** 类变量 */
    static int max = 10;

    public ABC2(int target) {
        this.target = target;
    }

    @Override
    public void run() {
        printABC();
    }

    public void printABC() {
        while (current < max) {
            try{
                lock.lock();
                // current < max 的原因是
                if((current % 3 == target)) {
                    System.out.println((char)('A' + current % 3));
                    current++;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ABC2(0)).start();
        new Thread(new ABC2(1)).start();
        new Thread(new ABC2(2)).start();

        try {
            Thread.sleep(1000*10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
