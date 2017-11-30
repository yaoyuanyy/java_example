package com.yy.enums;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/30 at 下午3:15
 */
public enum DateFormatEnum {

    SIMPLE("yyyy-MM-dd HH:mm:ss");

    private String format;

    DateFormatEnum(String format) {
        this.format = format;
    }

    public String format() {
        return format;
    }
}
