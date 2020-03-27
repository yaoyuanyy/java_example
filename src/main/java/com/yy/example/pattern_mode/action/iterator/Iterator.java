package com.yy.example.pattern_mode.action.iterator;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-27 at 11:04
 */
public interface Iterator {

    boolean isDone();
    Object currentItem();
    void next();
}
