package com.yy.example.pattern_mode.factory_method.tutorial1;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午5:21
 */
public class Test {

    public static void main(String[] args) {
//        Circle circle = (Circle) ShapeFactory.getShape("CIRCLE");
//        circle.draw();
//
//        Rectangle rectangle = (Rectangle) ShapeFactory.getShape("RECTANGLE");
//        rectangle.draw();

        // 通过反射获取
        Circle circle = (Circle) ShapeFactoryByReflect.create(Circle.class);
        circle.draw();

        Rectangle rectangle = (Rectangle) ShapeFactoryByReflect.create(Rectangle.class);
        rectangle.draw();
    }
}
