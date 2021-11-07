package com.yy.example.data_structure_and_algorithm.algorithm.book_biancheng_zhuji;

/**
 * Description: 二分查找算法
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-04-26 at 17:16
 */
public class Test_4_6_1 {

    public static void main(String[] args) {
        int[] arraySorted = new int[]{2,4,6,8,10,11,15,33,39};
        int index = binarySearch(arraySorted, 39);
        System.out.println("index:" + index);
    }

    private static int binarySearch(int[] arraySorted, int target) {

        int steps = 0;
        int start = 0;
        int end = arraySorted.length;
        for (;;) {
            steps ++ ;
            int mid = (start + end) / 2;
            int midValue = arraySorted[mid];
            if(midValue == target) {
                System.out.println("steps:" + steps);
                return mid;
            }
            if(start >= end || (start + 1 == end)) {
                System.out.println("没有找到target:" + target  + " steps:" + steps  + " mid:" + mid + " start:" + start + " startValue:" + arraySorted[start] + " end:" + end + " endValue:" + arraySorted[end]);
                return -1;
            }
            if(target > midValue) {
                start = mid;
            }
            if(target < midValue) {
                end = mid;
            }
        }
    }
}
