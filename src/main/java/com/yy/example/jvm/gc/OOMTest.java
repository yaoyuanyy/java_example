package com.yy.example.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 * -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/yaoliang/Documents -Xmx20m -Xms20m -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCCause
 *
 * https://eclipsesource.com/blogs/2013/01/21/10-tips-for-using-the-eclipse-memory-analyzer/
 * https://kknews.cc/code/p98vj4e.html
 * https://programmersought.com/article/64583676007/
 * https://programmersought.com/article/64583676007/
 *
 * @author skyler
 * Created by on 2021-03-13 at 22:15
 */
public class OOMTest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        // 创建n个1M大小的数组，耗尽内存
        for (int i = 0; i < 10000; i++) {
            list.add(new Person("women" + i, i, new byte[1024 * 1024]));
        }
    }
}

class Person {
    String name;
    int age;
    byte[] ssbytes;

    public Person(String name, int age, byte[] ssbytes) {
        this.name = name;
        this.age = age;
        this.ssbytes = ssbytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte[] getSsbytes() {
        return ssbytes;
    }

    public void setSsbytes(byte[] ssbytes) {
        this.ssbytes = ssbytes;
    }
}
