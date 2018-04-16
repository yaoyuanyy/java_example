package com.yy.util;

import com.yy.enums.DateFormatEnum;
import org.apache.commons.lang.time.DateFormatUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * Description:
 * <pre>
 * 参考：
 *  1. 国际时间：https://www.mkyong.com/java8/java-8-convert-date-to-localdate-and-localdatetime/
 *  2. 国内时间：https://stackoverflow.com/questions/19431234/converting-between-java-time-localdatetime-and-java-util-date
 * </pre>
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

    /**
     * localDateTime Convert to Date with china time
     * @param localDateTime
     * @return
     */
    public Date localDateTimeConvertDate(LocalDateTime localDateTime){
        if(Objects.isNull(localDateTime)) {
            return null;
        }
        ZonedDateTime zdt = localDateTime.atZone(ZoneId.systemDefault());
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    /**
     * Date Convert to localDateTime
     * @param date
     * @return
     */
    public LocalDateTime ConvertLocalDateTime(Date date){
        if(Objects.isNull(date)) {
            return null;
        }
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return ldt;
    }

    /**2017-10-15 23:59:59
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()),
                ZoneId.systemDefault());
        ;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得某天最小时间
     *
     * @param date
     * @return
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()),
                ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {

        String result = formatWithCommon(null);
        System.out.println(result);

        //------ Date -> java.time ------------------------------------------------------
        //Asia/Kuala_Lumpur +8
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("System Default TimeZone : " + defaultZoneId);

        //toString() append +8 automatically.
        Date date = new Date();
        System.out.println("date : " + date);

        //1. Convert Date -> Instant
        Instant instant = date.toInstant();
        System.out.println("instant : " + instant); //Zone : UTC+0

        //2. Instant + system default time zone + toLocalDate() = LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        System.out.println("localDate : " + localDate);

        //3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
        System.out.println("localDateTime : " + localDateTime);

        //4. Instant + system default time zone = ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
        System.out.println("zonedDateTime : " + zonedDateTime);


        //------ java.time -> Date ------------------------------------------------------
        //Asia/Kuala_Lumpur +8
        ZoneId defaultZoneId2 = ZoneId.systemDefault();
        System.out.println("System Default TimeZone : " + defaultZoneId2);

        LocalDate localDate2 = LocalDate.of(2016, 8, 19);
        Date date2 = Date.from(localDate2.atStartOfDay(defaultZoneId2).toInstant());
        System.out.println("\n1. LocalDate -> Date");
        System.out.println("localDate : " + localDate2);
        System.out.println("date : " + date2);

        LocalDateTime localDateTime2 = LocalDateTime.of(2016,8,19,21,46,31);
        Date date3 = Date.from(localDateTime2.atZone(defaultZoneId2).toInstant());
        System.out.println("\n2. LocalDateTime -> Date");
        System.out.println("localDateTime : " + localDateTime2);
        System.out.println("date3 : " + date3);

        ZonedDateTime zonedDateTime2 = localDateTime2.atZone(defaultZoneId2);
        Date date4 = Date.from(zonedDateTime2.toInstant());
        System.out.println("\n3. ZonedDateTime -> Date");
        System.out.println("zonedDateTime : " + zonedDateTime2);
        System.out.println("date4 : " + date4);


    }
}
