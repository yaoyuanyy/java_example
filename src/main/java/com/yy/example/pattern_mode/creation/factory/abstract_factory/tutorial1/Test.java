package com.yy.example.pattern_mode.creation.factory.abstract_factory.tutorial1;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午7:20
 */
public class Test {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = FactoryProducer.getFactory(ColorFactory.class);
        Color color = abstractFactory.getColor(Blue.class);
        color.fill();


        AbstractFactory abstractFactory2 = FactoryProducer.getFactory(ShapeFactory.class);
        Shape circle = abstractFactory2.getShape(Circle.class);
        circle.draw();
    }
}
