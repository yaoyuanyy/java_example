package com.yy.example.pattern_mode.facade;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 下午9:41
 */
public class GongJiJinFacade {

    private GongJiJin gongJiJin;

    public GongJiJinFacade(GongJiJin gongJiJin) {
        this.gongJiJin = gongJiJin;
    }

    /**
     * 这个就是外观模式的提现，对外提供这个方法
     */
    public void getMoney(){
        gongJiJin.companyInfo();
        gongJiJin.personalInfo();
        gongJiJin.houseInfo();
        gongJiJin.authroze();
        gongJiJin.goGongJiJinCenter();
    }
}
