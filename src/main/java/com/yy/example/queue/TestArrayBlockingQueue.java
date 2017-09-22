package com.yy.example.queue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by yaoliang on 2017/2/27.
 */
public class TestArrayBlockingQueue {
    public static void main(String[] args) {
        System.out.println("");

        HashMap hm = new HashMap();
        hm.put(null,"a");
        System.out.println(hm.get(null));

        LinkedHashMap lhm = new LinkedHashMap();
        lhm.put(null,"d");
        System.out.println(lhm.get(null));

        TreeMap tm = new TreeMap();
        tm.put(null,"q");
        System.out.println(tm.get(null));
    }
}
