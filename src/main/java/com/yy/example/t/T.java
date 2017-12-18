package com.yy.example.t;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/21 at 下午12:14
 */
public class T {
    public static void main(final String[] args) {
        final Random random = new Random();
        // 中奖币种数量

        final BigDecimal decimal = new BigDecimal(11122222222.4444444);
        final double drawCurrencyCount = decimal.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(drawCurrencyCount);


        final long l = 111;
        final float f = 0.6322f;
        final double d = 0.6322;
        final int i = ThreadLocalRandom.current().nextInt(10) + 1;
        System.out.println(i);


        final Integer i1 = new Integer(100);
        final Integer i2 = new Integer(100);
        System.out.println(i1 == i2);

        /**
         * 由于自动装箱机制，实例化时会调用Integer.valueOf(int i);而这个方法缓存了-128--127之间的值，所以下面的输出是true
         *
         * 下面的代码相当于
         * final Integer i111 = Integer.valueOf(100);
         * final Integer i222 = Integer.valueOf(100);
         *
         */

        final Integer i111 = 100;
        final Integer i222 = 100;
        System.out.println(i111 == i222);

//        final Integer i11 = 1000;
//        final Integer i22 = 1000;
//        System.out.println(i11 == i22);

    }
}
