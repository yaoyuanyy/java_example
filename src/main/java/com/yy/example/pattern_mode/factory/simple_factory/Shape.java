package com.yy.example.pattern_mode.factory.simple_factory;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-22 at 11:30
 */
public interface Shape {

    void draw();

    default void doDraw(){
        System.out.println("Draw");
    }
}
