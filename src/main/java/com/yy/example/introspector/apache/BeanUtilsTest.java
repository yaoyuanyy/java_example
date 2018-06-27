package com.yy.example.introspector.apache;

import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/27 at 上午10:31
 */
public class BeanUtilsTest {

    public static void main(String[] args) {
        new BeanUtilsTest().test();
    }

    public void test() {
        Person p = new Person();
        try {
            BeanUtils.setProperty(p, "name", "t3");

            System.out.println(p);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    class Person implements Serializable{
        private Long id;
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}



