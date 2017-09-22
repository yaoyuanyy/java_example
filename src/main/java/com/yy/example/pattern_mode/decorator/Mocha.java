package com.yy.example.pattern_mode.decorator;

/**
 * desc:摩卡，调料的一种
 * Created by skyler on 2017/3/4
 *
 * CondimentDecorator继承Beverage是为了继承类型
 * Mocha组合Beverage是为了实现beverage的行为
 */
public class Mocha extends CondimentDecorator{

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "， Mocha ";
    }

    /**
     * @Desc: 计算出带摩卡这种调料的饮料的价钱=调料钱+饮料钱
     * @return:
     * @author: skyler
     * @Date: 2017/3/4 11:01
     */
    @Override
    double cost() {
        return 0.10 + beverage.cost();
    }
}