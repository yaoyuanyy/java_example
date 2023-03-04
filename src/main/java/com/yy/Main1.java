package com.yy;

import java.util.*;

/**
 * Description:
 * <pre>
 * 优秀学员统计
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/27 at 10:04
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int emplayCount = sc.nextInt();
        int[] days = new int[30];
        for (int i = 0; i < days.length; i++) {
            days[i] = sc.nextInt();
        }
        // 数组初始化完毕，开始业务逻辑 员工号：打卡总数
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < days.length; i++) {
            int count = days[i];
            for (int j = 0; j < count; j++) {
                int emplayId = sc.nextInt();
                Integer value = map.get(emplayId);
                if(value == null) {
                    map.put(emplayId, 1);
                }else {
                    map.put(emplayId, value + 1);
                }
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue(5, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry<Integer, Integer> e1 = (Map.Entry<Integer, Integer>)o1;
                Map.Entry<Integer, Integer> e2 = (Map.Entry<Integer, Integer>)o2;
                if(e1.getValue() > e2.getValue()) {
                    return 1;
                }else if(e1.getValue() < e2.getValue()) {
                    return -1;
                }
                return e1.getKey() <= e2.getKey() ? 1 : -1;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
        }

        int i = 0;
        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> e = minHeap.poll();
            if(e != null) {
                System.out.print(e.getKey() + " ");
            }
            i++;
            if(i == 5) {
                break;
            }
        }
//
//        int factLen = minHeap.size() < 5 ? minHeap.size() : 5;
//        for (int i = 0; i < factLen; i++) {
//            Map.Entry<Integer, Integer> entry = minHeap.poll();
//            System.out.print(entry.getKey() + " ");
//        }
    }

}