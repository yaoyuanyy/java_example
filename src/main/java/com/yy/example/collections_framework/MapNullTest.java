package com.yy.example.collections_framework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by yaoliang on 2017/2/27.
 */
public class MapNullTest {
    public static void main(final String[] args) {
        System.out.println("");

        final HashMap hm = new HashMap();
        hm.put(null, "a");
        System.out.println(hm.get(null));

        final LinkedHashMap lhm = new LinkedHashMap();
        lhm.put(null, "d");
        System.out.println(lhm.get(null));

        final TreeMap tm = new TreeMap();
        tm.put(null, "q");
        System.out.println(tm.get(null));
    }
}
