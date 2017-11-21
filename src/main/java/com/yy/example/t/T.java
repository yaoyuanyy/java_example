package com.yy.example.t;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/21 at 下午12:14
 */
public class T {
    public static void main(String[] args) {
        Random random = new Random();
        // 中奖币种数量

        BigDecimal decimal=new BigDecimal(11122222222.4444444);
        double drawCurrencyCount=decimal.setScale(0,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(drawCurrencyCount);

        int i = new Random().nextInt(10)+1;
        System.out.println(i);
    }
}
