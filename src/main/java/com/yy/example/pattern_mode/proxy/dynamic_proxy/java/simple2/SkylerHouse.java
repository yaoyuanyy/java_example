package com.yy.example.pattern_mode.proxy.dynamic_proxy.java.simple2;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-25 at 16:06
 */
public class SkylerHouse implements House {
    @Override
    public String descripte() {

        String desc = "this is skyler`s house with a bingxiang";
        System.out.println(desc);
        return desc;
    }
}
