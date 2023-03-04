package com.yy;

import java.util.Scanner;

/**
 * 不包含101 的个数
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int left = 0;
        int right = 0;
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            left = in.nextInt();
            right = in.nextInt();
        }
        // xx101xx
        // 2的n次方 - 1
        int count = 0;
        for (int i = left; i <= right; i++) {
            String data = Integer.toBinaryString(i);
            if(data.contains("101")) {
                continue;
            }
            count++;
        }
        System.out.println(count);
    }
}