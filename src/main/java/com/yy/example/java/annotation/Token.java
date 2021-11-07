package com.yy.example.java.annotation;

import java.lang.annotation.*;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/21 at 下午9:56
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Tokens.class)
public @interface Token {

    String value();
}

