package com.yy.example.pattern_mode.single;

/**
 * Created by skyler on 2017/3/8.
 */
public class SingletenWithVolatile {

    private volatile static SingletenWithVolatile instance;

    private SingletenWithVolatile(){}

    public static SingletenWithVolatile getInstance() {
        if(instance == null) {
            synchronized (SingletenWithVolatile.class) {
                if(instance == null) {
                    instance = new SingletenWithVolatile();
                }
            }
        }
        return instance;
    }
}
