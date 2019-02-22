package com.yy.example.pattern_mode.factory.factory_method.tutorial1;

/**
 * Description: 工厂方法子类
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-22 at 14:23
 */
public class CircleFactory implements ShapeFactory{
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
