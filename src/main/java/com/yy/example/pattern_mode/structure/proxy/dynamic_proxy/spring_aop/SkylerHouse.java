package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.spring_aop;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 18:35
 */
public class SkylerHouse implements House {
    @Override
    public void address(String name) {
        System.out.println("朝阳区北苑路北:" + name);
    }

    @Override
    public void desc() {
        System.out.println("小区附近吃的多，交通方便，干净，安全");
    }
}
