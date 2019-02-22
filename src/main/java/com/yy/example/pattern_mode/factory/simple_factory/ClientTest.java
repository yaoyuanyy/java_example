package com.yy.example.pattern_mode.factory.simple_factory;

import com.yy.example.pattern_mode.factory.factory_method.tutorial1.Rectangle;

import java.lang.reflect.InvocationTargetException;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-22 at 11:52
 */
public class ClientTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        System.out.println(new ShapeFactory().getShape(1).getClass().getName());
        System.out.println(new ShapeFactory().getShape(Circle.class.getName()));


        // 通过反射获取
        Shape shape = (Shape) ShapeFactoryByReflect.create(Circle.class);
        shape.draw();

        Shape shape2 = (Shape) ShapeFactoryByReflect.create(Rectangle.class);
        shape2.draw();
    }
}
