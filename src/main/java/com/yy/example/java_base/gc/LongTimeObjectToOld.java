package com.yy.example.java_base.gc;

/**
 * Description: 长期存活的对象进入老年代
 * <p>
 * </p>
 * <pre>
 *    VM 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 *      -Xms20M  --初始堆大小
 *      -Xmx20M  --最大堆大小
 *      -Xmn10M  --年轻代大小
 *      -XX:MaxTenuringThreshold=1 -- 对象转移到老年代阀值(每次垃圾回收对象age+1,age大于阀值时对象被移到老年代中)
 *      -XX:+PrintTenuringDistribution
 *
 *     refer to:
 *     https://jacobchang.cn/experiment-on-jvm.html
 *     https://www.jianshu.com/p/22e609df559b
 *     https://cloud.tencent.com/developer/article/1041079
 * </pre>
 * NB.
 * Created by skyler on 2018/5/21 at 下午6:08
 */
public class LongTimeObjectToOld {
    public static int _1MB = 1024 * 1024;

    public static void main(final String[] args) {
        testTenuringThreshold();
    }

    public static void testTenuringThreshold() {
        final byte[] a1;
        final byte[] a2;
        byte[] a3;
        a1 = new byte[_1MB / 4];
        a2 = new byte[4 * _1MB];
        a3 = new byte[4 * _1MB];
        a3 = null;
        a3 = new byte[4 * _1MB];
    }
}
