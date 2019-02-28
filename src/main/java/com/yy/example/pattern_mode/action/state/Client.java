package com.yy.example.pattern_mode.action.state;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-27 at 19:58
 */
public class Client {

    public static void main(String[] args) {

        // 订单被创建，状态为待付款
        Context context = new Context();
        TOPayState toPayState = new TOPayState();
        context.setState(toPayState);
        context.info();

        // 订单已付款
        PaiedState paiedState = new PaiedState();
        context.setState(paiedState);
        context.info();

        RevicedState revicedState = new RevicedState();
        context.setState(revicedState);
        context.info();

    }
}
