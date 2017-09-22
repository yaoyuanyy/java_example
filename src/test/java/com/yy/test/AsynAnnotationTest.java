package com.yy.test;

import com.yy.example.anno_async.Task;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.Future;

public class AsynAnnotationTest extends AppTest {

    @Resource
    Task task;

    @Test
    public void testTask() throws Exception {

        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();


        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }

            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }
}
