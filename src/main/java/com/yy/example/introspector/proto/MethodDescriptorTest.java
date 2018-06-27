package com.yy.example.introspector.proto;

import lombok.Data;

import java.beans.IntrospectionException;
import java.beans.MethodDescriptor;
import java.beans.ParameterDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Enumeration;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/27 at 上午10:31
 */
public class MethodDescriptorTest {

    public static void main(String[] args) {
        new MethodDescriptorTest().test();
    }

    public void test() {
        final String ATTRIBUTE_NMAE = "sayHello";
        try {

            ParameterDescriptor parameterDescriptor = new ParameterDescriptor();
            parameterDescriptor.setValue(ATTRIBUTE_NMAE,"tt");
            parameterDescriptor.setName("cul");

            MethodDescriptor methodDescriptor = new MethodDescriptor(Person.class.getMethod("setName", String.class),
                    new ParameterDescriptor[]{parameterDescriptor});

            System.out.println("getDisplayName:"+methodDescriptor.getDisplayName());
            System.out.println(methodDescriptor.getName());
            System.out.println(methodDescriptor.getShortDescription());
            Enumeration enumeration = methodDescriptor.attributeNames();
            while (enumeration.hasMoreElements()){
                System.out.println("attributeNames:"+enumeration.nextElement());
            }
            for(ParameterDescriptor pd : methodDescriptor.getParameterDescriptors()) {
                System.out.println(pd.getValue(ATTRIBUTE_NMAE));
                System.out.println(pd.getDisplayName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    @Data
    class Person {
        private Long id;
        private String name;
    }
}
