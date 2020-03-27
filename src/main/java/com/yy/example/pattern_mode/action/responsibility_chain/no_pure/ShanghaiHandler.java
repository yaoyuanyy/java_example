package com.yy.example.pattern_mode.action.responsibility_chain.no_pure;

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
public class ShanghaiHandler extends Handler {
    @Override
    protected void HandlerMessage(RequestObj request) {

        System.out.println("上海开始处理这个请求");

        nextHandler.HandlerMessage(request);
    }
}
