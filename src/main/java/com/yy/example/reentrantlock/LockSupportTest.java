package com.yy.example.reentrantlock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/9/15 at 下午8:46
 */
public class LockSupportTest {

    public static void main(String[] args) {
//        Thread mainThread = Thread.currentThread();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+ " start");
//                LockSupport.unpark(mainThread);
//                //System.out.println(mainThread.getName()+ " go on");
//            }
//        }).start();
//
//        System.out.println(Thread.currentThread().getName()+ " block");
//        LockSupport.park(mainThread);
//
//        System.out.println(Thread.currentThread().getName()+ " go on");


    }


    private AtomicBoolean lockFlag = new AtomicBoolean(false);

    private Queue<Thread> waitingQueue = new ConcurrentLinkedDeque();

    public void lockR() {
        Thread current = Thread.currentThread();
        waitingQueue.add(current);

        while (waitingQueue.peek() != current || lockFlag.compareAndSet(false, true)) {
            LockSupport.park();
        }

        waitingQueue.remove();
    }

    public void unlockR() {
        lockFlag.set(false);
        LockSupport.unpark(waitingQueue.peek());
    }
}
