package com.yy.example.mutil_thread.thread;

import java.time.Period;
import java.util.Objects;

/**
 * Description: 演示ThreadLocal在一个线程上存值，在另一个线程为何取不到值来掌握他的原理，debug源码
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

                    threadLocal.set(new Person("-new"));
                    Person p = threadLocal.get();
                    System.out.println(""+p);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Person person = threadLocal.get();
                if (Objects.nonNull(person)) {
                    System.out.printf("ff:%10s\n", person.getName());
                }
            }
        }).start();
    }

    class Person {
        private String name;

        public Person() {
        }

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
