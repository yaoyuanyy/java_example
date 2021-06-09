package com.yy.rest;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-06-09 at 20:56
 */
public class PersonObj {

    String name;
    int age;
    byte[] ssbytes;

    public PersonObj(String name, int age, byte[] ssbytes) {
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
