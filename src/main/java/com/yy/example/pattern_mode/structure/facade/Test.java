package com.yy.example.pattern_mode.structure.facade;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午10:06
 */
public class Test {

    public static void main(String[] args) {
        GongJiJin gongJiJin = new GongJiJin();
        GongJiJinFacade facade = new GongJiJinFacade(gongJiJin);
        facade.getMoney();
    }
}
