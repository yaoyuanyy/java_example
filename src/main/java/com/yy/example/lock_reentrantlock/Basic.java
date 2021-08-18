package com.yy.example.lock_reentrantlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 *     refer to:
 *     https://javadoop.com/2017/07/20/AbstractQueuedSynchronizer-2/
 * </pre>
 */
public class Basic {

    public static void main(String[] args) {

        Data data = new Data();

        new Thread(new Runnable() {
            @Override
            public void run() {
                data.outPut("yy");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                data.outPut("ll");
            }
        }).start();
    }

    static class Data{

        Lock lock = new ReentrantLock();

        public void outPut(String name) {
            lock.lock();
            try {
                Thread.sleep(1000*100);
                System.out.println("name：" + name + "Thread name:" + Thread.currentThread().getName());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}


