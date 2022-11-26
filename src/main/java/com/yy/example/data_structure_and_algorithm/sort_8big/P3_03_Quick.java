package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-10-17 at 09:59
 */
public class P3_03_Quick extends Example {

    /**
     * 快速排序，就是一个二叉树前序遍历
     * 思路：
     * 第一步. 首先，找到一个位置，使该位置的左侧元素值都<=改位置值，同时该位置右侧的元素值>=改位置值
     * 第二步. 然后，分别对左侧元素和右侧元素两部分递归的进行第一步的操作
     * 总结起来：先找位置，再递归
     *
     * @param arr
     */
    @Override
    public void sort(Comparable[] arr) {
        sort((Integer[]) arr, 0, arr.length - 1);
    }

    private void sort(Integer[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    /**
     * 这里更多的参考 labuladong的，算法4的代码不太好记忆
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247496139&idx=1&sn=b0aca0f2b98e23495c9bd13bb4d90e40&chksm=9bd40fc3aca386d5687dc10ddb1034b71df7584add74c4eb5ab95bbcc2da58cf8402507fad24&mpshare=1&scene=23&srcid=1123SNdZmdUilgQtwCQP1WFC&sharer_sharetime=1669167634246&sharer_shareid=d8b99a7de88c1835290392544af5d7c8%23rd
     *
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    private int partition(Integer[] arr, int lo, int hi) {
        int target = arr[lo];
        // 为啥 + 1: lo 位置的值是目标值，所以直接从目标值右侧的元素开始
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            // 找到大于 target 位置的元素位置
            while (i < hi && less(arr[i], target)) {
                i++;
            }
            // 找到小于 target 位置的元素位置
            while (j > lo && less(target, arr[j])) {
                j--;
            }
            // 此时，[lo..i] <= p <= [j..hi]
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
        // 此时，j 位置应该放 lo 位置的那个值。互换即可
        exch(arr, lo, j);
        return j;
    }


    public static void main(String[] args) {

        P3_03_Quick quick = new P3_03_Quick();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        quick.sort(array);
        show(array);
    }
}
