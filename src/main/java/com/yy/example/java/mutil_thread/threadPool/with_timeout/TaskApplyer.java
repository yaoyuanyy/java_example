package com.yy.example.java.mutil_thread.threadPool.with_timeout;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: 任务应用方
 * <pre>
 *
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/3/3 at 10:48
 */
public class TaskApplyer {

    static final ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(3, 10, 60 * 10, TimeUnit.SECONDS,
                    new LinkedBlockingDeque(5),
                    new BasicThreadFactory.Builder().namingPattern("test-thread-pool-%d").build(),
                    new RejectedExecutionHandler() {
                        @Override
                        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                            System.out.println("rejectedExecution");
                        }
                    }
            );

    public void eat(String dicai) {
        Task task = new Task(dicai);
        threadPoolExecutor.execute(task);
    }

    /**
     * 带超时功能的吃饭
     * 超时后自动取消点菜
     * @param dicai
     */
    public void eatWithTimeout(String dicai) {
        Task task = new Task(dicai);
        TaskTimer taskTimer = new TaskTimer(task, 5, TimeUnit.SECONDS);
        threadPoolExecutor.execute(taskTimer);
    }

    public static void main(String[] args) {
//        TaskApplyer taskApplyer = new TaskApplyer();
//        taskApplyer.eat("烤鸭");
//        taskApplyer.eatWithTimeout("烤鸭");

        Integer[] arr = new Integer[]{4, 2, 6};
        Arrays.sort(arr, new Comparator() {
            @Override
            // 第一个参数小于第二个参数，返回负数
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i1 - i2;
            }

            @Override
            public boolean equals(Object obj) {
                return true;
            }
        });

        Arrays.stream(arr).forEach(o -> System.out.println(o));
        // result:
        // 2
        // 4
        // 6
    }
}
