package com.yy.example.queue.linked_transfer_queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * LinkedTransferQueue特点：
 *
 * refer to:
 * http://ifeve.com/java-transfer-queue/
 * https://segmentfault.com/a/1190000011266361
 * https://zhuanlan.zhihu.com/p/27148381
 * https://blog.csdn.net/xiaoxufox/article/details/52241317#linkedtransferqueue%E7%BB%93%E6%9E%84-node
 *
 * Created by yaoliang on 2017/2/27.
 */
public class LinkedTransferQueueTest {
    public static void main(final String[] args) {

        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();
        new Thread(new LinkedTransferQueueTest().new Producer(queue)).start();
        new Thread(new LinkedTransferQueueTest().new Customer(queue)).start();

    }

    class Producer implements Runnable{

        private LinkedTransferQueue<Integer> queue;

        public Producer(LinkedTransferQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            IntStream.range(0, 3).forEach(a -> {
                try {
                    System.out.println("producer 等待生产...:"+a);
                    // 测试add方法
                    // queue.add(a);

                    // 测试transfer方法
                    queue.transfer(a);

                    // 测试tryTransfer方法
                    //queue.tryTransfer(a);

                    // 测试tryTransfer带时间的方法
                    //queue.tryTransfer(a, 1000, TimeUnit.MILLISECONDS);
                    System.out.println("producer 生产完成:"+a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    class Customer implements Runnable{

        private LinkedTransferQueue<Integer> queue;

        public Customer(LinkedTransferQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            IntStream.range(0, 3).forEach(a -> {
                try {
                    System.out.println("Customer 等待消费...:"+a);
                    queue.take();
                    System.out.println("Customer 消费完成:"+a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
