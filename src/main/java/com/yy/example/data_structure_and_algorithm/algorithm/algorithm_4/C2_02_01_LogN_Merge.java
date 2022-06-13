package com.yy.example.data_structure_and_algorithm.algorithm.algorithm_4;

/**
 * Description: 归并排序
 * <pre>
 * 核心：将待排序的数组 n (递归地)分成两半分别排序，然后将结果归并起来
 * 重点：
 * 1. 需要额外空间：n 长度的数组
 * 2. 归并排序是递归进行的
 * 3. 先递归后归并 (与快排相比)
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/23/22 at 10:53 AM
 */
public class C2_02_01_LogN_Merge extends Example{

    @Override
    public void sort(Comparable[] a) {
        Comparable[] tmpArr = new Comparable[a.length];
        sort(a, 0, a.length - 1, tmpArr);
        show(a);
    }

    public void sort(Comparable[] a, int lo, int hi, Comparable[] tmpArr) {
        if(hi <= lo) {
            return;
        }
        int mid = lo + ((hi - lo) >> 1);
        sort(a, lo, mid, tmpArr);
        sort(a, mid + 1, hi, tmpArr);
        merge(a, lo, mid, hi, tmpArr);
    }

    /**
     * 额外数组作为参数传入递归方法中
     * 此方法写法参照：算法4 p170
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     * @param tmpArr
     */
    public void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] tmpArr) {

        // 把数组放到额外数组中
        for (int k = lo; k <= hi; k++) {
            tmpArr[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;
        // 走逻辑
        for (int k = lo; k <= hi; k++) {
            if(i > mid) {  // 边界判断
                a[k] = tmpArr[j++];
            }else if(j > hi) {  // 边界判断
                a[k] = tmpArr[i++];
            } else if(less(tmpArr[j], tmpArr[i])) { // 元素判断
                a[k] = tmpArr[j++];
            } else { // 元素判断
                a[k] = tmpArr[i++];
            }
        }
    }

    /**
     * 此方法写法参照：
     * 左程云算法课程：https://www.bilibili.com/video/BV1kQ4y1h7ok?p=3 00:35:00
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public void merge(Comparable[] a, int lo, int mid, int hi) {

    }

    public static void main(String[] args) {

        C2_02_01_LogN_Merge merge = new C2_02_01_LogN_Merge();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        System.out.println("merge sort");
        System.out.print("原 值 ");show(array);
        merge.sort(array);
    }
}
