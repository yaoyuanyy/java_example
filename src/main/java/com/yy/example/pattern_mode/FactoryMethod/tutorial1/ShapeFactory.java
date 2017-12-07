package com.yy.example.pattern_mode.FactoryMethod.tutorial1;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午5:30
 */
public class ShapeFactory {

    public static Object create(Class clazz) {
        Object obj = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
