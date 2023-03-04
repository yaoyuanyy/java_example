package com.yy.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/3/2 at 18:09
 */
public class ProConTest {

   static List<Integer> data = new ArrayList<>(100);
   int maxCount = 100;

    public void put(int i) {
        // 放
        while (true) {
            synchronized (data) {
                while (data.size() == maxCount) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                data.add(i);
                data.notify();
            }
        }
    }

    public void get() {
        // 取
        while (true) {
            synchronized (data) {
                while (data.size() == 0) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                data.remove(1);
                data.notify();
            }
        }
    }
}
