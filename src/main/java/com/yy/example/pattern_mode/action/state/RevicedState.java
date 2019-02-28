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
public class RevicedState implements State {

    @Override
    public void doAction(Context context) {
        context.setState(this);
        System.out.println("商品用户已签收，订单完成");
    }
}
