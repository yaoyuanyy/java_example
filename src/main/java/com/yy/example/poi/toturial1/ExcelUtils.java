package com.yy.example.poi.toturial1;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/7/31 at 下午2:45
 */
public class ExcelUtils {

    public static String capitalizeInitialLetter(String fieldName) {
        if(null == fieldName || fieldName.length() < 1)
        return null;

        char c = fieldName.charAt(0);
        return Character.toUpperCase(c) + fieldName.substring(1);
    }
}
