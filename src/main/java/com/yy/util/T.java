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

//    public static void main(String[] args) {
////        String filetext = "guangsha;1.1.0;iOS;11.3;iPhone 8";
////        //正则表达式，取=和|之间的字符串，不包括=和|
////        Pattern p = Pattern.compile("\\;(.*?)\\;");
////        Matcher m = p.matcher(null);
////
////        String des = null;
////        if(m.find()) {
////            des = m.group(1);
////            System.out.println(des);
////
////        }
////
////        System.out.println("tt");
////
////        System.out.println(("1.1.0".compareTo(des)));
////
////
////    }

    public static void main(String[] args) {
        testBreakAndReturn(10);
    }

    public static void testBreakAndReturn(int num){
        System.out.println("开始执行方法");
        int times = 0;
        boolean succ = false;
        while (times<3){
            succ = testData(num);
            if(succ){
                //continue; //(1)
                //break;  //(2)
                return; //(3)
            }
            System.out.println("结束执行方法");
            times++;
        }

        System.out.println("结束执行方法");
    }

    public static boolean testData(int num){
        return num ==10;
    }
}
