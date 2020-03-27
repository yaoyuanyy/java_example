package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.java.simple2;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-25 at 16:14
 */
public class Client {

    public static void main(String[] args) {
        SkylerHouse skylerHouse = new SkylerHouse();

        ProxyFactory proxyFactory = new ProxyFactory(skylerHouse);
        House house = (House) proxyFactory.getProxyObject();
        house.descripte();
    }
}
