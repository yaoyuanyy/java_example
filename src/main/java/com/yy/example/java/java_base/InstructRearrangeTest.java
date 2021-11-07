package com.yy.example.java.java_base;

/**
 * Description: 指令重排
 * <p></p>
 * <pre>
 *
 *  我们理想认为的情况：
 *      flag = true;  // C1
 *      value = 2;    // C2
 *    C1代码在C2代码之前被执行，即flag=true之前一定是value=0的，
 *
 *  实际情况：
 *    多运行几次，出现结果：发生了重排序, client.j=4
 *
 *    出现原因：线程t1先执行C2, 线程t2执行C3和C4, 线程t1执行C1, 指令C1和C2被重排了, 导致最终的j=4。即但是由于指令重排，导致value=2先于flag=true执行了，所以reader()方法进入了if条件语句
 *
 *  TODO 进阶分析：此处的指令重排的原因是jvm编译java代码时进行了指令重排，还是cpu对java字节码进行了指令重排呢
 *
 *  NB. 这里java代码的重排只是为了简单示意，真正的指令重排是在字节码指令的层面
 * </pre>
 *
 * Created by skyler on 2019-05-16 at 10:49
 */
public class InstructRearrangeTest {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100000; i++) {
            final ReorderClient client = new ReorderClient();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    client.writer();
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    client.reader();
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            if (client.j != 0) {
                System.out.println("i=" + i + "时发生了重排序, client.j=" + client.j);
            }
        }

        System.out.println("the end");
    }

    private static class ReorderClient {
        private boolean flag = false;
        private int value = 0;
        private int j;

        private void writer() {
            flag = true;  // C1
            value = 2;    // C2
        }

        private void reader() {
            if (!flag) {            // C3
                j = value * value; // C4
            }
        }
    }
}
