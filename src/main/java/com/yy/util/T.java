package com.yy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/7/9 at 下午4:48
 */
public class T {

    public static void main(String[] args) {
        String filetext = "guangsha;1.1.0;iOS;11.3;iPhone 8";
        //正则表达式，取=和|之间的字符串，不包括=和|
        Pattern p = Pattern.compile("\\;(.*?)\\;");
        Matcher m = p.matcher(null);

        String des = null;
        if(m.find()) {
            des = m.group(1);
            System.out.println(des);

        }

        System.out.println("tt");

        System.out.println(("1.1.0".compareTo(des)));


    }
}
