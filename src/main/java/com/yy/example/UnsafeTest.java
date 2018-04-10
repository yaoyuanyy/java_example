package com.yy.example;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Description:
 * <p>
 *     <b>练习使用Unsafe给类的属性赋值</b>
 * </p>
 * <pre>
 *     getUnsafe() , 返回值是Unsafe的实例。如果直接调用会抛： Exception in thread "main" java.lang.SecurityException: Unsafe
 *     解决办法：
 *     https://blog.csdn.net/hezuideda/article/details/45132229
 * </pre>
 * NB.
 * Created by skyler on 2018/4/10 at 下午10:31
 */
public class UnsafeTest {

    static {

    }

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.casAge(0, 1));

        System.out.println("p:"+p);

        p.putCasName("test");
        System.out.println("p:"+p);

        Person p2 = new Person();
        System.out.println(p.casName(null, "tt"));
        System.out.println("p2:"+p2);

    }

    static class Person {

        private static final Unsafe unsafe;
        private static final long ageOffset;
        private static final long nameOffset;

        static {
            try {
                Field field = Unsafe.class.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                unsafe = (Unsafe)field.get(null);

                Class<?> clazz = Person.class;
                ageOffset = unsafe.objectFieldOffset(clazz.getDeclaredField("age"));

                nameOffset = unsafe.objectFieldOffset(clazz.getDeclaredField("name"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public void putCasName(String name){
            unsafe.putObject(this,nameOffset,name);
        }

        public boolean casAge(int source, int des) {
            return unsafe.compareAndSwapInt(this, ageOffset, source, des);
        }

        public boolean casName(String source, String des) {
            return unsafe.compareAndSwapObject(this, nameOffset, source, des);
        }

        private int age;
        private String name;

        public void casName() {

        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
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
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
