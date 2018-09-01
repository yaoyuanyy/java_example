package com.yy.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class DoubleUtil {

    /**
     * double 除法
     * @param d1
     * @param d2
     * @param scale 四舍五入 小数点位数
     * @return
     */
    public static double divide(double d1, double d2, int scale) {
        // 当然在此之前，你要判断分母是否为0，
        // 为0你可以根据实际需求做相应的处理

        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 小数转百分数，保留两位
     * @return
     */
    public static String decimalsToPercent(Double decimals) {
        if(Objects.isNull(decimals)){
            return null;
        }
        if(decimals > 1){
            return decimals+"";
        }
        NumberFormat num = NumberFormat.getPercentInstance();
        num.setMaximumFractionDigits(2);
        return num.format(decimals);
    }

    public static String decimalsToPercent2(Double decimals){
        DecimalFormat df = new DecimalFormat("0.00%");
        return df.format(decimals);
    }

    public static void main(String[] args) {
        System.out.println(decimalsToPercent(0.1209));
        System.out.println(decimalsToPercent(1209.9012));
        System.out.println(decimalsToPercent(0.1));
        System.out.println(decimalsToPercent(1d));
        System.out.println("--------");

        System.out.println(decimalsToPercent2(0.1209));
        System.out.println(decimalsToPercent2(0.1));
        System.out.println(decimalsToPercent2(1d));
        System.out.println(decimalsToPercent2(1209.9012));
    }
}
