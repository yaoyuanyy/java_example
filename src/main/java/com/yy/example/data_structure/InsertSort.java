package com.yy.example.data_structure;

import java.util.Arrays;

/**
 * Description:
 * <pre>
 *     1.思想：
 *     直接插入排序的基本操作是将一个记录插入到已经排好的有序表中，从而得到一个新的、记录数增1的有序表。
 * 对于给定的一组记录，初始时假定第一个记录自成一个有序序列，其余记录为无序序列。接着从第二个记录开始，
 * 按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，直到最后一个记录插到有序序列中为止。
 * </pre>
 * <pre>
 *     2.复杂度分析
 * 当最好的情况，也就是要排序的表本身就是有序的，此时只有数据比较，没有数据移动，时间复杂度为O(n)。
 * 当最坏的情况，即待排序的表是逆序的情况，此时需要比较次数为：2+3+…+n=(n+2)(n-1)/2 次,而记录移动的最大值也达到了 (n+4)(n-1)/2 次.
 * </pre>
 *
 * Created by skyler on 2017/11/13 at 上午9:07
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {38,65,97,46,13,27,4};
        System.out.println("排序前：" + Arrays.toString(a));
        insert(a);
        System.out.println("排序后：" + Arrays.toString(a));
    }


    public static void insert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int target = a[i];
            while (j > 0 && a[j - 1] > target) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = target;
        }
    }
}
