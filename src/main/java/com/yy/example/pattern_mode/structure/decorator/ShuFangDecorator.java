package com.yy.example.pattern_mode.structure.decorator;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-25 at 06:52
 */
public class ShuFangDecorator extends HouseDecorator {

    public ShuFangDecorator(House house) {
        super(house);
    }

    @Override
    public String getInternalInfo() {
        return super.getInternalInfo();
    }

    @Override
    public String style() {
        return "加个一个书房";
    }
}
