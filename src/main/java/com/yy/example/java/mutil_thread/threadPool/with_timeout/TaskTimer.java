package com.yy.example.java.mutil_thread.threadPool.with_timeout;

import java.util.concurrent.*;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/3/3 at 10:37
 */
public class TaskTimer implements Runnable {

    private Task task;

    private int timeout;

    private TimeUnit timeUnit;

    public TaskTimer(Task task, int timeout, TimeUnit timeUnit) {
        this.task = task;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(task);
        try {
            future.get(timeout, timeUnit);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        } catch (TimeoutException e) {
            System.out.println("执行超时了，Timeout:" + timeout);
            boolean success = future.cancel(true);
            System.out.println("取消成功：" + success);
            e.printStackTrace();
        }
    }
}

