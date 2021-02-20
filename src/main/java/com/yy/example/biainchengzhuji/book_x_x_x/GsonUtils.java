package com.yy.example.biainchengzhuji.book_x_x_x;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Objects;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2021-02-19 at 10:38
 */
public class GsonUtils {

    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().serializeNulls().create();

    private static final Gson defaultGson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();

    public static String outWithPretty(Object o) {
        if(Objects.isNull(o)) {
            return null;
        }
        return gson.toJson(o);
    }

    public static String out(Object o) {
        if(Objects.isNull(o)) {
            return null;
        }
        return defaultGson.toJson(o);
    }
}
