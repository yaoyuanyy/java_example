package com.yy.example.thread;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/19 at 下午8:57
 */
public class ThreadLocalTest {

    final ThreadLocal<Person> threadLocal = new ThreadLocal();

    public static void main(final String[] args) {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.test();
    }

    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadLocal.set(new Person("yy"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Person person = threadLocal.get();
                    System.out.printf("ff:%10s\n", person.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    class Person{
        private String name;

        public Person() {}

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
