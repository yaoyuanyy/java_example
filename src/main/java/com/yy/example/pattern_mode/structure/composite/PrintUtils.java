package com.yy.example.pattern_mode.structure.composite;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-25 at 12:00
 */
public class PrintUtils {

    public static String prefix(int level){
        String levelDeepFlag = "-";

        if(level < 1) return levelDeepFlag;

        for (int i = 1; i<level; i++){
            // 层级递增
            levelDeepFlag += "-";
        }

        return levelDeepFlag;
    }
}
