package com.yy.example.reactor;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * <p>
 * NB.
 * </p>
 * Created by skyler on 2019-07-03 at 12:25
 */
public class ThisDemo {

    private String name = "ThisDemo";

    public void test() {
        // 匿名类实现
        new Thread(new Runnable() {

            private String name = "Runnable";

            @Override
            public void run() {
                System.out.println("这里的this指向匿名类:" + this.name);
            }
        }).start();

        // lambda实现
        new Thread(() -> {
            System.out.println("这里的this指向当前的ThisDemo类:" + this.name);
        }).start();
    }

    public static void main(String[] args) {
        ThisDemo demo = new ThisDemo();
        demo.test();
    }

    public int normalMethod(int i) {
        System.out.println("实例方法可以访问this:" + this);
        return i * 2;
    }
}
