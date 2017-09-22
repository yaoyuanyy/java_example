package com.yy.example.reentrantlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Basic {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//       ExecutorService executorService = Executors.newFixedThreadPool(3);
//       Data data = new Data();
////        Data data2 = new Data();
////
//        executorService.submit(() -> data.outPut("yy"));
//        executorService.submit(() -> data.outPut("ll"));
//        //executorService.submit(() -> data2.outPut("ll"));

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


}

class Data{

    Lock lock = new ReentrantLock();

    public void outPut(String name) {
        lock.lock();
        try {
            for(int i=100;i>0;i--) {
                if(i == 60){
                    try {
                        Thread.sleep(1000*100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("------"+i+" Thread name:"+Thread.currentThread().getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
