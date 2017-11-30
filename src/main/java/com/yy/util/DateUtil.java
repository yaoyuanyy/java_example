package com.yy.util;

import com.yy.enums.DateFormatEnum;
import org.apache.commons.lang.time.DateFormatUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/30 at 下午2:39
 */
public class DateUtil {

    /**
     * 格式化 java.util.Date Format：yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String formatWithJava8(Date date){
        if(Objects.isNull(date)){
            return null;
        }

        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String result = dtf.format(ldt);
        return result;
    }

    /**
     * 格式化 java.util.Date Format：yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String formatWithCommon(Date date){
        if(Objects.isNull(date)){
            return null;
        }
        String result = DateFormatUtils.format(date, DateFormatEnum.SIMPLE.format());
        return result;
    }

    public static void main(String[] args) {
        String result = formatWithCommon(null);
        System.out.println(result);

    }
}
