package com.yy.example.java.mutil_thread.threadPool.with_timeout;

/**
 * Description: 任务
 * <pre>
 *
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/3/3 at 10:36
 */
public class Task implements Runnable{

    String dicai;

    public Task(String dicai) {
        this.dicai = dicai;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这里是任务");
    }
}
