package com.yy.example.spring.custom_spring.custom7_utils.spring_reflection;

import com.alibaba.fastjson.JSON;
import com.yy.example.spring.custom_spring.custom5.InstantiationService;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;

/**
 * Description: 通过spring reflect util 反射创建bean实例
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/18 at 下午5:08
 */
public class CustomReflectionUtils {

    public static void main(String[] args) {
        try {
//            Class[] parameterTypes = {Long.class, String.class};
//            Object[] parameterObjects = {new Long(200), "skyler"};
//            InstantiationService instantiationService = beanInstantiation(InstantiationService.class, parameterTypes, parameterObjects);

            InstantiationService instantiationService = beanInstantiation(InstantiationService.class);

            output(instantiationService);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用默认构造方法的getBean
     *
     * @param clazz
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     */
    public static <T> T beanInstantiation(Class<T> clazz) throws NoSuchMethodException {
        T t = beanInstantiation(clazz,null,null);
        return t;
    }

    /**
     * 通用的getBean
     *
     * @param clazz
     * @param types
     * @param parameters
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     */
    public static <T> T beanInstantiation(Class<T> clazz, Class[] types, Object... parameters) throws NoSuchMethodException {
        Constructor<T> constructor = clazz.getDeclaredConstructor(types);
        ReflectionUtils.makeAccessible(constructor);
        T t = BeanUtils.instantiateClass(constructor, parameters);
        return t;
    }

    /**
     * 使用全限定名的class name创建bean实例
     * @param name
     * @return
     */
    public static Object beanInstantiation(String name){
        try {
            Class clazz = ClassUtils.forName(name, CustomReflectionUtils.class.getClassLoader());
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void output(Object obj){
        System.out.println(JSON.toJSONString(obj));
    }
}
