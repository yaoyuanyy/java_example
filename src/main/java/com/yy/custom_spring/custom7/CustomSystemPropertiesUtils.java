package com.yy.custom_spring.custom7;

import org.springframework.util.SystemPropertyUtils;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/20 at 下午6:43
 */
public class CustomSystemPropertiesUtils {

    public static void main(String[] args) {
//        System.out.println(test("aaaa", true));
//        System.out.println(test("aaaa:ffff", true));
//        System.out.println(test("{aaaa}", true));
//        System.out.println(test("{aaaa:}", true));
        System.out.println(test("${aaaaa:ccc}", true));

        System.out.println("----");
        System.out.println(test("${a", true));
        System.out.println(test("${aa}", true));
        System.out.println(test("${aaa:}", true));
        System.out.println(test("${aaaa:bb}", true));

    }

    public static String test(String text, boolean ignoreUnresolvablePlaceholders){
        return SystemPropertyUtils.resolvePlaceholders(text, ignoreUnresolvablePlaceholders);
    }
}
