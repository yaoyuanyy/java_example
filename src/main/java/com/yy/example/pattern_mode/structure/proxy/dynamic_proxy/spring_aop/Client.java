package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.spring_aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 18:24
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory factory = CustomProxyFactory.getProxyObject(House.class, new SkylerHouse());
        House house = (House) factory.getProxy();

        house.address("test");

        house.desc();
    }

}
