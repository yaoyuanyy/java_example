package com.yy.example.java_base.gc;

/**
 * Description:
 * <p></p>
 * <pre>
 *     运行时配置: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 *     refer to: 深入理解java虚拟机
 *                               第三章 3.5节-内存分配与回收策略
 *                                      代码清单3-3
 *
 *   Metaspace 各个字段的含义，参考:
 *   http://www.cnblogs.com/benwu/articles/8312699.html
 *   https://stackoverflow.com/questions/40891433/understanding-metaspace-line-in-jvm-heap-printout
 * </pre>
 * NB.
 * Created by skyler on 2018/5/18 at 下午3:02
 */
public class GCTest {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        final byte[] allocation1;
        final byte[] allocation2;
        final byte[] allocation3;
        final byte[] allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];

    }

    public static void main(final String[] args) {
        testAllocation();
        System.out.println("111");
    }
}
