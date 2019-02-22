package com.yy.example.pattern_mode.factory.factory_method.tutorial1;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午5:21
 */
public class Test {

    public static void main(String[] args) {
        // 如果想获取circle,可以从CircleFactory获取
        Shape shape = new CircleFactory().getShape();
        shape.draw();

        // 如果想获取rectangle,可以从RectangleFactory获取
        Shape shape2 = new RectangleFactory().getShape();
        shape2.draw();

    }
}
