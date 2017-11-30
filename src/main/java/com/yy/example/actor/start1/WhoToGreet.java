package com.yy.example.actor.start1;

import java.io.Serializable;

/**
 * Description: 打招呼的人
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午11:15
 */
public class WhoToGreet implements Serializable {
    public final String who;
    public WhoToGreet(String who) {
        this.who = who;
    }
}
