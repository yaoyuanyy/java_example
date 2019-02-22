package com.yy.example.pattern_mode.factory.abstract_factory.tutorial1;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午7:15
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(Class clazz) {

        try {
            Shape shape = (Shape)Class.forName(clazz.getName()).newInstance();
            return shape;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    Color getColor(Class clazz) {
        return null;
    }
}
