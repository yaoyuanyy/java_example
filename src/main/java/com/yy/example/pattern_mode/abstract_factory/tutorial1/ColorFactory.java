package com.yy.example.pattern_mode.abstract_factory.tutorial1;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午7:13
 */
public class ColorFactory extends AbstractFactory{

    @Override
    Shape getShape(Class clazz) {
        return null;
    }

    @Override
    Color getColor(Class clazz) {
        try {
            Color color = (Color)Class.forName(clazz.getName()).newInstance();
            return color;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
