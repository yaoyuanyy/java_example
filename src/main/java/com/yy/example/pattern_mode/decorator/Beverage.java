package com.yy.example.pattern_mode.decorator;

/**
 * 被装饰者基类
 * 饮料基类
 * Created by yaoliang on 2017/3/4.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    /**
     * @Desc: 此饮料的描述
     * @return:
     * @author: skyler
     * @Date: 2017/3/4 10:28
     */
    public String getDescription(){
        return description;
    }

    /**
     * @Desc: 此饮料的价格
     * @author: skyler
     * @Date: 2017/3/4  10:25
     */
    abstract double cost();
}
