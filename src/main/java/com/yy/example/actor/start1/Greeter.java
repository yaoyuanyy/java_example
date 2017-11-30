package com.yy.example.actor.start1;

import akka.actor.ActorContext;
import akka.actor.UntypedActor;

/**
 * Description: 打招呼的Actor
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午11:16
 */
public class Greeter extends UntypedActor {
    String greeting = "";

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("onReceive -- ");
        if (message instanceof WhoToGreet)
            greeting = "hello, " + ((WhoToGreet) message).who;
        else if (message instanceof Greet)
            // 发送招呼消息给发送消息给这个Actor的Actor
            getSender().tell(new Greeting(greeting), getSelf());
        else if (message instanceof Greeting)
            System.out.println("message:"+((Greeting) message).message);
        else unhandled(message);
    }
}
