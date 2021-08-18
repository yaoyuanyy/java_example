package com.yy.example.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * <pre>
 *  https://www.bilibili.com/video/BV1xK4y1C7aT?p=3&spm_id_from=pageDriver
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020-05-22 at 16:25
 */
public class TestMain {

    public static void main(String[] args) {

        int id = 12;


        System.out.println("VM.current().details():" + VM.current().details());
        System.out.println("----------------");
        System.out.println(ClassLayout.parseClass(Consumer.class).toPrintable());
        System.out.println("===============");
        System.out.println(ClassLayout.parseInstance(new Consumer()).toPrintable());

        System.out.println("#################");
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            // 关注下打印出来的字节，看看加锁前后的区别
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }
}
