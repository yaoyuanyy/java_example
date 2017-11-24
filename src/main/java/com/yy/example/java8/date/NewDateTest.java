package com.yy.example.java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yaoliang on 2016/12/1.
 */
public class NewDateTest {
    public static void main(String[] args) {


        Date date = new Date();
        // date转换instant
        Instant instant = date.toInstant();
        // instant转换date
        Date date2 = Date.from(instant);
        // LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println("获取日期:"+localDate);

        localDate = LocalDate.ofYearDay(2014, 200);
        System.out.println("获得 2014 年的第 200 天:"+localDate.toString());

        LocalDate localDate2 = LocalDate.of(2014, Month.SEPTEMBER, 10); //2014 年 9 月 10 日
        System.out.println("日期："+localDate2.toString());//输出：2014-09-10
        System.out.println("2014 年的第 200 天在2014-09-10之后？"+localDate.isAfter(localDate2));
        System.out.println("2014-09-10加一天后的日期为"+localDate2.plusDays(1).toString());
        System.out.println("2014-09-11加一天后的日期为"+localDate2.minus(1, ChronoUnit.DAYS));
        System.out.println("2014为闰年吗？"+localDate.isLeapYear());
        System.out.println(localDate+"与"+localDate2+"相差的天数(省去整月)为："+Period.between(localDate, localDate2).getDays());

        //字符串转换为日期
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas);   // 2014-12-24

        String goodFriday = "Apr 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }

        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);

        // LocalTime
        LocalTime localTime = LocalTime.now();
        System.out.println("输出当前时间:"+localTime.toString());//
        localTime = LocalTime.of(10, 20, 50);
        System.out.println("时间"+localTime.toString());

        // LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("输出当前时间:"+localDateTime.toString());//
        localDateTime = LocalDateTime.of(2014,Month.APRIL,10, 20, 50);
        System.out.println("时间"+localDateTime.toString());

        //Clock 时钟(可选，可用now()获取同样的功能)
        //代替System.currentTimeMillis()来获取当前的毫秒值
        Clock clock = Clock.systemDefaultZone();//获取系统默认时区 (当前瞬时时间 )
        long millis = clock.millis();//


        Date legacyDate = Date.from(instant);// == java.util.Date
        System.out.println(legacyDate);
    }
}
