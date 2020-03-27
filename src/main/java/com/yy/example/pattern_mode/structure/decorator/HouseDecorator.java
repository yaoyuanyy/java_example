package com.yy.example.pattern_mode.structure.decorator;

/**
 * Description: house装饰器
 * <p>
 *  装饰器模式：装饰器不仅继承Component，同时还持有Component类型的属性
 * </p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-25 at 06:42
 */
public abstract class HouseDecorator implements House{

    protected House house;

    public HouseDecorator(House house) {
        this.house = house;
    }

    @Override
    public String getInternalInfo(){
        System.out.println("装饰组件：" + style());
        return house.getInternalInfo();
    }

    public abstract String style();
}
