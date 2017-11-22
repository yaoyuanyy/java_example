package com.yy.example.threadPool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: 参考 http://www.crazyant.net/2124.html
 * <p>探索ThreadPoolExecutor的运行轨迹</p>
 * <pre>
 *     场景一：任务数大于最大线程数+队列长度
 *     coreSize maxSize queueSize taskSize
 *     3        10      5         19
 *
 *     任务编号：1， 2， 3， 4， 5， 6， 7， 8， 9，10
 *             11，12，13，14，15，16，17，18，19
 *
 *     运行轨迹(步骤)     执行的任务编号                      本质揭秘(执行的数量)
 *        1              1, 2,  3                          coreSize
 *        2              9, 10, 11, 12, 13, 14, 15         maxSize - coreSize
 *        3              4, 5,  6,  7, 8                   queueSize
 *        4              程序报错                           taskSize - coreSize - queueSize > maxSize - coreSize 结果大于0：报错，小于等于0：正常运行
 *
 *     ----------------------------------------------------------------------------------------
 *     场景二：任务数等于最大线程数
 *     coreSize maxSize queueSize taskSize
 *     3        10      5         10
 *
 *     任务编号：1， 2， 3， 4， 5， 6， 7， 8， 9
 *
 *     运行轨迹(步骤)     执行的任务编号                      本质揭秘(执行的数量)
 *        1              1, 2, 3                           coreSize
 *        2              9, 10                             taskSize - coreSize - queueSize
 *        3              4, 5, 6, 7, 8                     queueSize
 * </pre>
 * NB.
 * Created by skyler on 2017/11/22 at 上午10:36
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        BlockingDeque blockingDeque = new LinkedBlockingDeque(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,10,60*10, TimeUnit.SECONDS,blockingDeque);
        for (int i = 1; i <= 15; i++) {
            final int task = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try { Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " for task of " + task);
                }
            });
        }
    }
}
