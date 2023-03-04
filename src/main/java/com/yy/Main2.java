package com.yy;

import java.util.*;

/**
 * 木板
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                map.put(num, value + 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue(5, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry<Integer, Integer> e1 = (Map.Entry<Integer, Integer>) o1;
                Map.Entry<Integer, Integer> e2 = (Map.Entry<Integer, Integer>) o2;
                if (e1.getKey() > e2.getKey()) {
                    return 1;
                } else if (e1.getKey() > e2.getKey()) {
                    return -1;
                }
                return 0;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
        }

        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> e = minHeap.poll();
            // System.out.println(e.getKey() + " " + e.getValue());
            int x = (max - e.getKey()) * e.getValue();
            if(m > x) {
                m = m - x;
            }else {
                System.out.println(e.getKey());
                break;
            }
        }
    }
}