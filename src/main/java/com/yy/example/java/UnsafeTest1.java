package com.yy.example.java;

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
public class UnsafeTest1 {
    private static final Unsafe unsafe;
    private static final long sexOffset;
    private static final long highOffset;
    private static final long ageOffset;
    private static final long hasMoneyOffset;
    private static final long nameOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);

            Class<?> clazzOfPerson = Person.class;
            // 获取操作系统的位数; 返回4或8,代表是32位还是64位操作系统。
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

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        unsafe.putInt(p, sexOffset, 221);
        System.out.println(p);
        // System.out.println(ClassLayout.parseClass(Person.class).toPrintable());
    }
}

class Person {

    private byte sex;
    private char high;
    private int age;
    private double hasMoney;
    private String name;

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
