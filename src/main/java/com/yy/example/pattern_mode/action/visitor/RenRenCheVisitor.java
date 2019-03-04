package com.yy.example.pattern_mode.action.visitor;

/**
 * Description: 买卖二手车
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 10:52
 */
public class RenRenCheVisitor implements Visitor {
    @Override
    public void visitor(Engine engine) {
        System.out.println(this.getClass().getSimpleName() + " engine name:" + engine.getName() + " engine usedYears:" + engine.getUsedYears());
    }

    @Override
    public void visitor(Brand brand) {
        System.out.println(this.getClass().getSimpleName() + " brand name: " + brand.getName()+" brand level:" + brand.getLevel());
    }
}
