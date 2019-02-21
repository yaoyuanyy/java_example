package com.yy.test;

import org.junit.Test;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorTest extends JavaExampleAppTest {


    /**
     * <span color=yellow>测试用例不适合test 定时任务相关的功能，因为测试用例跑完整个应用就停止了，也就是这个进程停止了。应用停止了，延迟或周期走的代码当然就走不了了。
     * 所以自己写个main方法测试定时任务相关的功能</span>
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        ScheduledFuture scheduledFuture = executorService.schedule(() -> {
                System.out.println("run --- "+ Thread.currentThread().getName());
            }, 1, TimeUnit.SECONDS);

        if(scheduledFuture.isDone()) {
            Object object = scheduledFuture.get();
            System.out.println("isDone "+object);
        }else {
            System.out.println("not is Done");
        }
    }

}
