package com.yy.example.java.aqs;

/**
 * Description:
 * <p></p>
 * <pre>
 *     局部变量在多线程中的测试
 * </pre>
 * NB.
 * Created by skyler on 2018/4/7 at 下午12:54
 */
public class C3_LocalVariableTest {

    public static void main(String[] args) {
        Person person = new Person(1, "skyler");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " -> 原始name值:" + person.getName());
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " -> sleep 1s后的name值:" + person.getName());
                } catch (Exception e) {
                } finally {
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " -> 新线程开始执行person.setName('ss')");
                    person.setName("ss");
                }catch(Exception e){
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
