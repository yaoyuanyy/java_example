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
        Shape shape = (Shape) ShapeFactory.create(Circle.class);
        shape.draw();

        Shape shape2 = (Shape) ShapeFactory.create(Rectangle.class);
        shape2.draw();
    }
}
