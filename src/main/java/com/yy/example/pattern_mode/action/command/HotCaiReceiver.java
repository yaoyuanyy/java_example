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
public class HotCaiReceiver extends Receiver {

    @Override
    public void prepareRou() {
        System.out.println("准备猪肉和胡萝卜");
    }

    @Override
    public void prepareShucai() {
        // 不用蔬菜
    }

    @Override
    public void prepareTool() {
        System.out.println("准备老抽和工具");
    }

    @Override
    public void zuocai() {
        System.out.println("猪肉下油锅，回锅加入胡萝卜丝，出锅");

    }
}
