package com.yy.example.java.mutil_thread.communicate.lc_1_objwaitnotify;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * <pre>
 *
 * https://biteeniu.github.io/java/how-to-use-wait-notify-notifyall/
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/17 at 08:15
 */
public class ProviderConsumerTest {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        Thread p = new Provider(list, 3);
        Thread c = new Consumer(list);

        p.start();
        c.start();

        try {
            Thread.sleep(1000*1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


