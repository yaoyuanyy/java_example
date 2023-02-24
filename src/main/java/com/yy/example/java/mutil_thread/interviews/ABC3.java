package com.yy.example.java.mutil_thread.interviews;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:如何优雅的让3个线程打印ABC
 * <pre>
 * 方案：阻塞队列
 * 参考：https://juejin.cn/post/6940274452559036453
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/19 at 10:05
 */
public class ABC3 extends Thread{

    BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue();
    ABC3 next;

    private static final Integer Max = 9;

    @Override
    public void run() {
        try {
            printABC();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printABC() throws InterruptedException {
        while (true) {
            int value = blockingQueue.take();
            if(value > Max) {
                return;
            }
            System.out.println((char)('A' + value % 3));
            next.blockingQueue.put(value + 1);
        }

    }

    public static void main(String[] args) {
        ABC3 t1 = new ABC3();
        ABC3 t2 = new ABC3();
        ABC3 t3 = new ABC3();

        t1.next = t2;
        t2.next = t3;
        t3.next = t1;

        t1.start();
        t2.start();
        t3.start();

        t1.blockingQueue.add(0);
    }

}
