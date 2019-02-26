package com.yy.example.pattern_mode.action.responsibility_chain.pure;

import com.yy.example.pattern_mode.action.responsibility_chain.RequestObj;

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
public class BeijingHandler extends Handler {
    @Override
    protected boolean HandlerMessage(RequestObj request) {
        if(1 == request.getType()) {
            System.out.println("北京开始处理这个请求");
            return true;
        }else {
            // 本handler处理不了，传递给下一个handler处理
            return nextHandler.HandlerMessage(request);
        }
    }
}
