package com.yy.example.pattern_mode.action.state;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-27 at 19:51
 */
public class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void info(){
        // 这里的this可以用作回调
        state.doAction(this);
    }
}
