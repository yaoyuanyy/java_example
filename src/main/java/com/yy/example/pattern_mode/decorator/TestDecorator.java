package com.yy.example.pattern_mode.decorator;

/**
 * @Desc: 客户要一杯双倍摩卡的咖啡
 * @return:
 * @author: skyler
 * @Date: 2017/3/4 11:05
 */
public class TestDecorator {

    public static void main(String[] args) {

        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        System.out.println("确认客户的菜单：" + beverage.getDescription());
        System.out.println("客户需要付的价格：" + beverage.cost());
    }

}
