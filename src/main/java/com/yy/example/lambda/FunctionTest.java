package com.yy.example.lambda;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.springframework.validation.DefaultMessageCodesResolver.Format.PREFIX_ERROR_CODE;

/**
 * Description: lambda对齐设计模式的应用对比
 * 参考：https://mp.weixin.qq.com/s/ieEISP2wwe2r37KSOPWBow
 * <pre>
 *
 * </pre>
 * <p>
 * NB.
 * </p>
 * Created by skyler on 2019-07-14 at 12:50
 */
public class FunctionTest {

    public static void main(String[] args) {
//        Function<String, String> handlerName = (String name) -> {
//            System.out.println("handlerName input:" + name);
//            return name.toLowerCase();
//        };
//        Function<String, String> handlerUp = (String str) -> {
//            System.out.println("handlerUp input:" + str);
//            return str.replace("yy", "skyler");
//        };
//       // Function<String, String> template = handlerName.compose(handlerUp);
//        Function<String, String> template = handlerName.andThen(handlerUp);
//
//        String arg = "I am yy";
//        String result = template.apply(arg);
//        System.out.println("result:" + result);

    }
}
