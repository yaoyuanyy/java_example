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
 * Created by skyler on 2019-02-26 at 10:54
 */
public abstract class Handler {

    protected Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract boolean HandlerMessage(RequestObj request);
}
