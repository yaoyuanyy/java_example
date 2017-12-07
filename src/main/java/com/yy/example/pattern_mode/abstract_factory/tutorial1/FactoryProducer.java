package com.yy.example.pattern_mode.abstract_factory.tutorial1;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午7:17
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(Class clazz){
        try {
            AbstractFactory abstractFactory = (AbstractFactory)Class.forName(clazz.getName()).newInstance();
            return abstractFactory;
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
