package com.yy.example.java.queue.synchronous_queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 *      SynchronousQueue是一个没有数据缓冲的BlockingQueue，生产者线程对其的插入操作put必须等待消费者的移除操作take，反过来也一样
 * </p>
 * <pre>
 *     refer to:
 *     http://ifeve.com/java-synchronousqueue/
 * </pre>
 * NB.
 * Created by skyler on 2018/4/7 at 下午10:54
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println("开始add a");
//                    queue.put("a");
//                    System.out.println("开始add b");
//                    queue.put("b");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println("开始take a");
//                    String value = queue.take();
//                    System.out.println("开始take b");
//                    String value3 = queue.take();
//
//                    System.out.printf("%10s\n", value);
//                    System.out.format("%5s", value);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 10).forEach(a -> {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i=0;i<100000;i++){
                            for (int j=0;j<100000;j++){
                                if(i == 99999 && j == 99999){
                                    System.out.println("开始take " +i+":"+j + "-->" + System.currentTimeMillis()/1000 + " == current Thread:"+Thread.currentThread().getName());
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        });

    }
}
