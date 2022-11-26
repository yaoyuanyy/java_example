package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 归并排序
 * <pre>
 * 核心：将要排序的数组分成两个子数组，对每个子数组进行递归排序，然后将排好序的子数组 组合成一个有序数组
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-28 at 10:24
 */
public class P3_02_Merge extends Example {

    int[] temp = null;

    @Override
    public void sort(Comparable[] arr) {
        temp = new int[arr.length];
        sort((Integer[]) arr, 0, arr.length - 1);
    }

    /**
     * 归并排序类似一个二叉树的后序遍历
     * 先递归，后归并
     * 每次递归都是等分左右数组
     * https://labuladong.github.io/algo/2/21/41/
     * @param arr
     * @param lo
     * @param hi
     */
    private void sort(Integer[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = ((hi - lo) / 2 + lo);
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, hi, mid);
    }

    /**
     * 合并数组，将两个自数组合并成有序的一个，由于我们是一个数组，所以需要定义个临时数组
     * 使用双指针技巧，一个从 lo -> mid；一个从 mid + 1 -> hi
     * 所以，两个指针是同向的，从左向右
     *
     * @param arr
     * @param lo
     * @param hi
     * @param mid
     */
    private void merge(Integer[] arr, int lo, int hi, int mid) {
        for (int k = lo; k <= hi; k++) {
            temp[k] = arr[k];
        }
        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (i <= mid && j <= hi) {
//            if (temp[i] > temp[j]) {
//                arr[k] = temp[j];
//                j++;
//            } else {
//                arr[k] = temp[i];
//                i++;
//            }
//            k++;
            // 一行代码等于注释掉的 if else 代码
            arr[k++] = temp[i] > temp[j] ? temp[j++] : temp[i++];
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        while (j <= hi) {
            arr[k++] = temp[j++];
        }
    }


    public static void main(String[] args) {
        P3_02_Merge merge = new P3_02_Merge();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        merge.sort(array);
        show(array);
    }

}
