package com.yy.example.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * <p></p>
 * <pre>
 *     局部变量在多线程中的测试
 * </pre>
 * NB.
 * Created by skyler on 2018/4/7 at 下午12:54
 */
public class LocalVariableTest {

    public static void main(String[] args) {
        //Person person = new Person(1, "skyler");

        // Step1: 用两个线程来追踪源码
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    System.out.println("线程0");
//                    final Person p = person;
//                    System.out.println("name:"+p.getName());
//                    Thread.sleep(1000);
//                    System.out.println("2 name:"+p.getName());
//                }catch(Exception e){
//                    System.out.printf("%s\n", e);
//                }finally {
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    Thread.sleep(100);
//                    System.out.println("线程1");
//                    final Person p = person;
//                    p.setName("ss");
//                }catch(Exception e){
//                    System.out.printf("%s\n", e);
//                }finally {
//                }
//            }
//        }).start();


        Person person = new Person(1, "skyler");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("线程0");
                    System.out.println("name:"+person.getName());
                    Thread.sleep(1000);
                    System.out.println("2 name:"+person.getName());
                }catch(Exception e){
                    System.out.printf("%s\n", e);
                }finally {
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(100);
                    System.out.println("线程1");
                    person.setName("ss");
                }catch(Exception e){
                    System.out.printf("%s\n", e);
                }finally {
                }
            }
        }).start();
    }


}

class Person{
    private int age;
    private String name;

    public Person(){}

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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
}
