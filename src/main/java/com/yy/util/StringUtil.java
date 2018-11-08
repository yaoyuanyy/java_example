package com.yy.util;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/19 at 下午2:55
 */
public class StringUtil {


    public static void main(String [] args) {
        //hidden("18753993252");
        hidden("02180001111");

    }

    /**
     * // 将手机号码第4位到第7位替换成*
     *
     * @param tel
     * @return
     */
    public static String hidden(String tel){
        if(null == tel || "".equals(tel)){
            return null;
        }
        // 括号表示组，被替换的部分$n表示第n组的内容
        tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.print(tel);
        return tel;
    }

}
