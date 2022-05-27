package com.yy.example.data_structure_and_algorithm.algorithm.algorithm_4;

/**
 * Description: 找出一个数组的最大元素 递归实现
 * 左程云：https://www.bilibili.com/video/BV1kQ4y1h7ok?p=3 5分10秒
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/23/22 at 10:53 AM
 */
public class C2_02_00_ZCY_Max{

    public int max(int[] arr) {
        return doMax(arr, 0, arr.length - 1);
    }

    /**
     * 手动画出执行过程，递归调用树
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public int doMax(int[] arr, int l, int r) {
        if(r == l) {
            return arr[r];
        }
        int mid = l + ((r - l) >> 1);
        int lMax = doMax(arr, l, mid);
        int rMax = doMax(arr, mid + 1, r);
        return Math.max(lMax, rMax);
    }

    public static void main(String[] args) {

        C2_02_00_ZCY_Max max = new C2_02_00_ZCY_Max();
        int[] array = new int[]{20, 30, 90, 60, 40, 50, 70, 10};
        System.out.println("最大元素值为：" + max.max(array));
    }
}
