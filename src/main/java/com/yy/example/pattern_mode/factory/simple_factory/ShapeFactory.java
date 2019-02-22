package com.yy.example.pattern_mode.factory.simple_factory;

import org.springframework.util.ClassUtils;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-22 at 11:38
 */
public class ShapeFactory {

    public Shape getShape(int flag){
        if(0 == flag) return new Circle();
        if(1 == flag) return new Rectangle();
        return null;
    }

    public Shape getShape(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (Shape) ClassUtils.forName(className, this.getClass().getClassLoader()).newInstance();
    }
}
