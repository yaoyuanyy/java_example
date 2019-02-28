package com.yy.example.pattern_mode.action.state;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-27 at 19:56
 */
public class TOPayState implements State {

    @Override
    public void doAction(Context context) {
        context.setState(this);
        text();
    }

    public void text(){
        System.out.println("订单为待付款状态");
    }
}
