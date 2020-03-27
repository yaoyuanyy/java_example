package com.yy.example.callback;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-01 at 15:23
 */
public interface CallbackProcessor<T> {

    T process();

    void complate();
}
