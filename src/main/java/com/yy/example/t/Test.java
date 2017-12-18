package com.yy.example.t;

import java.util.Objects;
import java.util.TreeMap;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/17 at 下午3:51
 */
public class Test {

    public static void main(final String[] args) {
        final String str = "bbsba";

        if (!Objects.isNull(str) && str.length() > 0) {
            final TreeMap<Character, Integer> map = new TreeMap<>();

            for (final char c : str.toCharArray()) {
                final Integer count = map.get(c);
                if (count == null) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);

                }
            }
        }
    }

}


