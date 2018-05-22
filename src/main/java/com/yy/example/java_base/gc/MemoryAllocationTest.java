package com.yy.example.java_base.gc;

/**
 * Description: 测试各个场景内存分配
 * <p>
 * </p>
 * <pre>
 *     refer to:
 *     https://www.jianshu.com/p/22e609df559b
 *     https://jacobchang.cn/experiment-on-jvm.html
 *     https://cloud.tencent.com/developer/article/1041079
 * </pre>
 * NB.
 * Created by skyler on 2018/5/21 at 下午6:08
 */
public class MemoryAllocationTest {

    private static final int _1MB = 1024 * 1024;

    /**
     * 测试场景：对象优先在 Eden 区分配
     * VM参数：（参数序号对应实验序号）
     * 1. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseParNewGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 2. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseParallelGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testPriorityAllocationToEden() {
        final byte[] allocation1;
        final byte[] allocation2;
        final byte[] allocation3;
        final byte[] allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; //出现一次 Minor GC
    }

    /**
     * 测试场景：大对象直接进入老年代
     * VM参数：（参数序号对应实验序号）
     * 3. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseParNewGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=3145728
     */
    public static void testBigObjectToOld() {
        final byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    /**
     * 测试场景：长期存活的对象将进入老年代
     * -XX:MaxTenuringThreshold=1 -- 对象转移到老年代阀值(每次垃圾回收对象age+1,age大于阀值时对象被移到老年代中
     * <p>
     * VM参数：（参数序号对应实验序号）
     * 4. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     * 5. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:MaxTenuringThreshold=4 -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public static void testLongTimeObjectToOld() {
        final byte[] allocation1;
        byte[] allocation2;
        final byte[] allocation3;
        byte[] allocation4;
        allocation1 = new byte[_1MB / 16];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * 测试场景：TenuringThreshold 是动态变化的
     * VM参数：（参数序号对应实验序号）
     * 6. -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:MaxTenuringThreshold=4 -XX:+PrintTenuringDistribution
     * <p>
     * 如果在Survivor空间中相同年龄所有对象大小的总和>Survivor空间的一半（ -XX:TargetSurvivorRatio）时，年龄>=该年龄的对象就可以直接进入年老代
     */
    @SuppressWarnings("unused")
    public static void testTenuringThredholdChangeDynamic() {
        final byte[] allocation1;
        byte[] allocation2;
        final byte[] allocation3;
        byte[] allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(final String[] args) {
    }

}
