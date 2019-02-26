package com.yy.example.pattern_mode.action.responsibility_chain.no_pure;

import com.yy.example.pattern_mode.action.responsibility_chain.RequestObj;

import java.util.Objects;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-26 at 10:58
 */
public class ShenzhenHandler extends Handler {
    @Override
    protected void HandlerMessage(RequestObj request) {
        if(Objects.nonNull(nextHandler)) {
            nextHandler.HandlerMessage(request);
        }
        System.out.println("深圳处理这个请求完成");
    }
}
