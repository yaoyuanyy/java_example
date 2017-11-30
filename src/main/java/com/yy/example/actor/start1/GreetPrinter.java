package com.yy.example.actor.start1;

import akka.actor.UntypedActor;

/**
 * Description: 打印招呼
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午11:17
 */
public class GreetPrinter extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Greeting)
            System.out.println(((Greeting) message).message);
    }
}
