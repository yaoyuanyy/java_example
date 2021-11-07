package com.yy.example.java.introspector.proto;

import lombok.Data;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import static java.beans.Introspector.USE_ALL_BEANINFO;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/27 at 上午10:31
 */
public class IntrospectorTest {

    public static void main(String[] args) {
        new IntrospectorTest().test();
    }

    public void test() {
        Person p = new Person();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, USE_ALL_BEANINFO);
            for(PropertyDescriptor pd : beanInfo.getPropertyDescriptors()){
                if("name".equals(pd.getName())){
                    pd.getWriteMethod().invoke(p,"t2");
                }else if("id".equals(pd.getName())){
                    pd.getWriteMethod().invoke(p, 10L);
                }
            }

            System.out.println(p);

        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Data
    class Person {
        private Long id;
        private String name;
    }
}
