package com.yy.example.callback;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-01 at 15:22
 */
public class BusinessTemplate<T> {

    private CallbackProcessor<T> callbackProcessor;

    public BusinessTemplate(CallbackProcessor<T> callbackProcessor) {
        this.callbackProcessor = callbackProcessor;
    }

    public void execute(){
        try {
            System.out.println("context from ContextHolder is " + ContextHolder.getContext() + ",current Thread:" + Thread.currentThread().getName());
            callbackProcessor.process();
            callbackProcessor.complate();
        } finally {
            // ContextHolder.clearContext();
        }
    }
}
