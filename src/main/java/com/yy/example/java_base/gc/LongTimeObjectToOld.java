package com.yy.example.java_base.gc;

/**
 * Description: 长期存活的对象进入老年代
 * <p>
 * </p>
 * <pre>
 *     jvm添加参数:-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 *      -Xms20M  --初始堆大小
 *      -Xmx20M  --最大堆大小
 *      -Xmn10M  --年轻代大小
 *      -XX:MaxTenuringThreshold=1 -- 对象转移到老年代阀值(每次垃圾回收对象age+1,age大于阀值时对象被移到老年代中)
 *      -XX:+PrintTenuringDistribution
 *
 *     refer to:
 *     https://www.jianshu.com/p/22e609df559b
 * </pre>
 * NB.
 * Created by skyler on 2018/5/21 at 下午6:08
 */
public class LongTimeObjectToOld {
    public static int _1MB = 1024 * 1024;

    public static void test_3_6_3() {
        final byte[] a1 = new byte[_1MB >> 2];
        byte[] a2 = new byte[2 * _1MB];
        byte[] a3 = new byte[2 * _1MB];
        byte[] a4 = new byte[2 * _1MB];
        a2 = null;
        a3 = null;
        a4 = null;
        a2 = new byte[2 * _1MB];//第1次YGC
        a3 = new byte[2 * _1MB];
        a4 = new byte[2 * _1MB];
        a2 = null;
        a3 = null;
        a4 = null;
        a2 = new byte[2 * _1MB];//第2次YGC,a1被移到老年代
    }

    public static void main(final String[] args) {
        test_3_6_3();
    }
}
