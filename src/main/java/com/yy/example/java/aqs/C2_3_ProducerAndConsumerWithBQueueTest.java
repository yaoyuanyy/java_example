package com.yy.example.java.aqs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Description:
 * <pre>
 *   Producer-Consumer Pattern：通过BlockingQueue实现
 * </pre>
 * <img src="https://1.bp.blogspot.com/-TsBQNDFOsTk/YRdls06KiKI/AAAAAAAApJI/WIPyQzyDlXoxn87aDfUtqYjCXG-ZBVm8gCLcBGAsYHQ/s1125/Blockingqueue%2Bin%2BJAva%2Bwith%2Bproducer%2Bconsumer%2Bexample.png"/>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-30 at 16:52
 */
public class C2_3_ProducerAndConsumerWithBQueueTest {

    BlockingQueue<Integer> blockingQueue;
    int capacity;

    public C2_3_ProducerAndConsumerWithBQueueTest(int size) {
        blockingQueue = new ArrayBlockingQueue(size);
    }

    public void put(int data) throws InterruptedException {
       // while (true) {
        System.out.println("put 开始put数据 data: " + data + " Thread name -> " + Thread.currentThread().getName());
        // 如果放满了就会阻塞
        blockingQueue.put(data);
        capacity++;
       //}
    }

    public int get() throws InterruptedException {
       //while (true) {
        System.out.println("get 开始get数据 Thread name -> " + Thread.currentThread().getName());
        // 如果取空了就会阻塞
        int num = blockingQueue.take();
        capacity--;
           return num;
       //}
    }

    public static void main(String[] args) {
        C2_3_ProducerAndConsumerWithBQueueTest test = new C2_3_ProducerAndConsumerWithBQueueTest(1);

        /**
         * 测试目的：篮子里最多放3个物品，再取就陷入等待，等待有人取走后才能往篮子里再放；
         *          取走最多能取3个，再取就陷入等待，等待有人往篮子里放才能再取
         */
        for (int i = 100; i < 110; i++) {
            int tmp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        test.put(tmp);
                        System.out.println("put 完成put:" + tmp + " Thread name -> " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 100; i < 110; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // sleep是为了put集中执行
                        Thread.sleep(1000l);
                        int data = test.get();
                        System.out.println("get 完成get:" + data + " Thread name -> " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
