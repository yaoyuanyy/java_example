package com.yy.example.java_base.gc;

/**
 * Description: 堆内存分析，此类为gc入门程序
 * <p></p>
 * <pre>
 *     JVM Option argv: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintTenuringDistribution
 *      -Xms20m
 *      -Xmx20m
 *      -Xmn10m
 *      -verbose:gc
 *      -XX:+PrintGCDetails #输出详细GC日志模式
 *      -XX:+PrintTenuringDistribution #输出每次minor GC后新的存活周期的阈值
 *      -XX:+PrintGCTimeStamps #输出gc的触发时间
 *
 *     refer to:
 *     https://cloud.tencent.com/developer/article/1041079
 *     http://ifeve.com/useful-jvm-flags-part-8-gc-logging/
 * </pre>
 * NB.
 * Created by skyler on 2018/5/21 at 下午6:51
 */
public class HeapGCTest {

    private static final int _1M = 1024 * 1024;

    public static void main(final String[] args) throws InterruptedException {
        final byte[] byte1 = new byte[2 * _1M];
        final byte[] byte2 = new byte[2 * _1M];
        final byte[] byte3 = new byte[2 * _1M];
        final byte[] byte4 = new byte[2 * _1M];
        final byte[] byte5 = new byte[2 * _1M];

        final byte[] byte6 = new byte[5 * _1M];

        final byte[] byte7 = new byte[2 * _1M];


    }
}
