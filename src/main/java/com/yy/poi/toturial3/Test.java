package com.yy.poi.toturial3;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/8/2 at 上午11:40
 */
public class Test {

    ThreadFactory factory = new BasicThreadFactory.Builder().namingPattern("customerPool-excel-export-%d").build();
    ThreadPoolExecutor providerExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100), factory);

    ThreadFactory factory2 = new BasicThreadFactory.Builder().namingPattern("anjia-customerPool-%d").build();
    ThreadPoolExecutor customerExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100), factory2);

    BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue(100);

    public void provider(){
        for(int i =0;i< 100;i++){
            final int num = i;
            providerExecutor.execute(() -> {
                try {
                    System.out.println("provider:"+num);
                    Thread.sleep(10);
                    blockingQueue.put(num);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            });

        };

    }

    public void customer(){
        for(int i =0;i< 100;i++){
        customerExecutor.execute(() -> {
            try {
                System.out.println("customer:"+blockingQueue.take());
            } catch (InterruptedException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        });}

    }

    public static void main(String[] args) {
        Test test = new Test();
        test.customer();
        test.provider();

    }
}
