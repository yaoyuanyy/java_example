package com.yy.example.java;

import org.openjdk.jol.info.ClassLayout;
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
 * NB. 对象的字段的排列方式：从长到短排列，引用排最后: long/double --> int/float --> short/char --> byte/boolean --> Reference
 * Created by skyler on 2018/4/10 at 下午10:31
 */
public class UnsafeTest {

    public static void main(String[] args) {
        Person p = new Person();

        System.out.println(ClassLayout.parseClass(Person.class).toPrintable());

//        System.out.println(p.casAge(0, 1));
//
//        System.out.println("p:"+p);
//
//        p.putCasName("test");
//        System.out.println("p:"+p);
//
//        Person p2 = new Person();
//        System.out.println(p.casName(null, "tt"));
//        System.out.println("p2:"+p2);

    }

    static class Person {
        private static final Unsafe unsafe;
        private static final long sexOffset;
        private static final long highOffset;
        private static final long ageOffset;
        private static final long hasMoneyOffset;
        private static final long nameOffset;

        private byte sex;
        private char high;
        private int age;
        private double hasMoney;
        private String name;

        static {
            try {
                Field field = Unsafe.class.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                unsafe = (Unsafe)field.get(null);

                Class<?> clazzOfPerson = Person.class;
                System.out.println("unsafe.addressSize():" + unsafe.addressSize());

                sexOffset = unsafe.objectFieldOffset(clazzOfPerson.getDeclaredField("sex"));
                System.out.println("sexOffset:" + sexOffset);

                highOffset = unsafe.objectFieldOffset(clazzOfPerson.getDeclaredField("high"));
                System.out.println("highOffset:" + highOffset);

                hasMoneyOffset = unsafe.objectFieldOffset(clazzOfPerson.getDeclaredField("hasMoney"));
                System.out.println("hasMoneyOffset:" + hasMoneyOffset);

                ageOffset = unsafe.objectFieldOffset(clazzOfPerson.getDeclaredField("age"));
                System.out.println("ageOffset:" + ageOffset);

                nameOffset = unsafe.objectFieldOffset(clazzOfPerson.getDeclaredField("name"));
                System.out.println("nameOffset:" + nameOffset);
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public void putCasName(String name){
            unsafe.putObject(this, nameOffset, name);
        }

        public boolean casAge(int source, int des) {
            return unsafe.compareAndSwapInt(this, ageOffset, source, des);
        }

        public boolean casName(String source, String des) {
            return unsafe.compareAndSwapObject(this, nameOffset, source, des);
        }

        public byte getSex() {
            return sex;
        }

        public void setSex(byte sex) {
            this.sex = sex;
        }

        public char getHigh() {
            return high;
        }

        public void setHigh(char high) {
            this.high = high;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getHasMoney() {
            return hasMoney;
        }

        public void setHasMoney(double hasMoney) {
            this.hasMoney = hasMoney;
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
                    "sex=" + sex +
                    ", high=" + high +
                    ", age=" + age +
                    ", hasMoney=" + hasMoney +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
