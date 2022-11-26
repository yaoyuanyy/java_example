package com.yy.example.data_structure_and_algorithm.sort_8big;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-06-29 at 19:37
 */
public class TopK {
    /**
     * 使用优先队列实现
     *
     * @param arr
     * @return
     */
    public int getTopK(int[] arr, int k) {
        return -1;
    }

    /**
     * 使用快速选择排序实现
     * 求第 k 大的那个元素，相当于获取数组升序排序后第 array.len - k 个元素；
     * 这时，我们看看快排的逻辑：找到一个位置 p，使左边<=array[p]<=右边；
     * 如果 k > p 则 k 在 p 的右侧； 如果 k < p 则 k 在 p 的左侧；k=p 则找到
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247496139&idx=1&sn=b0aca0f2b98e23495c9bd13bb4d90e40&chksm=9bd40fc3aca386d5687dc10ddb1034b71df7584add74c4eb5ab95bbcc2da58cf8402507fad24&mpshare=1&scene=23&srcid=1123SNdZmdUilgQtwCQP1WFC&sharer_sharetime=1669167634246&sharer_shareid=d8b99a7de88c1835290392544af5d7c8%23rd
     *
     * @param arr
     * @return
     */
    public int getTopK2(int[] arr, int k) {
        int k2 = arr.length - k;
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int p = partition(arr, lo, hi);
            if(k2 > p) {
                lo = p + 1;
            }else if(k2 < p) {
                hi = p - 1;
            }else {
                return arr[p];
            }
        }
        return -1;
    }

    /**
     * 找到一个位置，左侧 <= 位置元素值 <= 右侧
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    private int partition(int[] arr, int lo, int hi) {
        int target = arr[lo];
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            // 找到大于target的 i 位置
            while (i <= hi && arr[i] <= target) {
                i++;
            }
            // 找到小于target的 j 位置
            while (j > lo && arr[j] > target) {
                j--;
            }
            if(i >= j) {
                break;
            }
            // 交换 i j 位置元素
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return j;
    }

    public static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {23, 45, 2, 6, 55, 90, 23, 4, 5};
        int value = new TopK().getTopK2(arr, 3);
        System.out.println(value);
    }
}
