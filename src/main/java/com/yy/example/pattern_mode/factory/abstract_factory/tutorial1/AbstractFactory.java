package com.yy.example.pattern_mode.factory.abstract_factory.tutorial1;


/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午7:00
 */
public abstract class AbstractFactory {

    abstract Shape getShape(Class clazz);
    abstract Color getColor(Class clazz);

}

