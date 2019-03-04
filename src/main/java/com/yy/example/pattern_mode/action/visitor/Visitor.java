package com.yy.example.pattern_mode.action.visitor;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 10:28
 */
public interface Visitor {

    void visitor(Engine engine);

    void visitor(Brand brand);
}
