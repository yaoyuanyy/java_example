package com.yy.example.java_base.gc;

/**
 * Description: 测试垃圾回收，此类为gc入门程序
 * <p></p>
 * <pre>
 *     JVM Option argv: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 *     refer to: 深入理解java虚拟机
 *                               第三章 3.5节-内存分配与回收策略
 *                                      代码清单3-3
 *
 *   参考:
 *   https://www.cnblogs.com/xuezhiyizu1120/p/6237510.html
 *   https://segmentfault.com/a/1190000014944731
 *   http://ifeve.com/useful-jvm-flags-part-8-gc-logging/
 *   https://jacobchang.cn/experiment-on-jvm.html
 *   https://cloud.tencent.com/developer/article/1041079
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
        //System.out.println("111");
    }
}
