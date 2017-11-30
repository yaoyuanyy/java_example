package com.yy.example.actor.start1;

import java.io.Serializable;

/**
 * Description: 招呼体,里面有打的什么招呼
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午11:15
 */
public class Greeting implements Serializable {
    public final String message;
    public Greeting(String message) {
        this.message = message;
    }
}
