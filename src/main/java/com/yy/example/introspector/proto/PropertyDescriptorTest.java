package com.yy.example.introspector.proto;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.Data;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/27 at 上午10:31
 */
public class PropertyDescriptorTest {

    public static void main(String[] args) {
        new PropertyDescriptorTest().test();
    }

    public void test() {
        try {
            Person p = new Person();
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", Person.class);
            // 获取setName()方法
            Method writeMethod = propertyDescriptor.getWriteMethod();
            // 赋值 setName("test")
            Object tmpObject = writeMethod.invoke(p, "test");
            System.out.println("invoke method result:"+tmpObject);

            // 获取getName()方法
            Method readMethod = propertyDescriptor.getReadMethod();
            // 调用getName()方法
            Object value = readMethod.invoke(p);
            System.out.println("result:"+value);

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
