package com.yy.example.jvm.gc.online.question_exampe;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 使用VisualVM监控OOM问题
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/5/23 at 上午10:36
 */
public class OOMTest {

    /**
     * JVM启动参数设置为：-Xms10m -Xmx10m -verbose:gc -XX:+PrintGCDetails
     *
     * @param args
     */
    public static void main(final String[] args) {
        final List<Object> objects = new ArrayList<>();
        try {
            Thread.sleep(1000 * 10);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            objects.add(new Object());
        }

    }
}
