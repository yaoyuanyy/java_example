package com.yy.example.pattern_mode.action.visitor;

/**
 * Description: 买新车
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 10:55
 */
public class ConsumerVisitor implements Visitor{
    @Override
    public void visitor(Engine engine) {
        System.out.println(this.getClass().getSimpleName() + " engine name:" + engine.getName() + " engine desc:" + engine.getDesc());
    }

    @Override
    public void visitor(Brand brand) {
        System.out.println(this.getClass().getSimpleName() + " brand name: " + brand.getName()+" brand code:" + brand.getCode());
    }
}
