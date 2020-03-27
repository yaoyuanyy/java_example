package com.yy.example.pattern_mode.action.command;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-26 at 14:48
 */
public class LiangCaiReceiver extends Receiver {

    @Override
    public void prepareRou() {
        // 凉菜不用肉
    }

    @Override
    public void prepareShucai() {
        System.out.println("准备黄瓜和干豆腐");
    }

    @Override
    public void prepareTool() {
        System.out.println("准备岔子和拌菜盆");
    }

    @Override
    public void zuocai() {
        System.out.println("黄瓜切丝，干豆腐切条后放入拌菜盆搅拌，出锅");

    }
}
