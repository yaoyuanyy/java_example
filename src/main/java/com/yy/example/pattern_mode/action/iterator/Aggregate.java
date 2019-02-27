package com.yy.example.pattern_mode.action.iterator;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-27 at 11:03
 */
public abstract class Aggregate {

    public abstract Iterator createIterator();
    public abstract void add(Object object);

}
