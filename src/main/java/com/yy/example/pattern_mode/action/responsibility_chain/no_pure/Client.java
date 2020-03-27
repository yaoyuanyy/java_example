package com.yy.example.pattern_mode.action.responsibility_chain.no_pure;

import com.yy.example.pattern_mode.action.responsibility_chain.RequestObj;

import java.util.UUID;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-26 at 11:08
 */
public class Client {

    public static void main(String[] args) {
        RequestObj requestObj = new RequestObj(UUID.randomUUID().toString(),"请求内容","to chongqing", 1);
        Handler beijingHandler = new BeijingHandler();
        Handler shanghaiHandler = new ShanghaiHandler();
        Handler shenzhenHandler = new ShenzhenHandler();

        beijingHandler.setNextHandler(shanghaiHandler);
        shanghaiHandler.setNextHandler(shenzhenHandler);

        beijingHandler.HandlerMessage(requestObj);

    }
}
