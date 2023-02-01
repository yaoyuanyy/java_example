package com.yy.example.data_structure_and_algorithm.a_started;

import com.yy.example.data_structure_and_algorithm.sort_8big.Example;

/**
 * Description: 归并排序
 * <pre>
 * 核心：将要排序的数组分成两个子数组，对每个子数组进行递归排序，然后将排好序的子数组 组合成一个有序数组
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 1/2/23 at 10:26 AM
 */
public class LC2_Merge extends Example {

    int[] temp = null;

    /**
     * <pre>
     * 快速排序的代码框架可看作是二叉树的前序遍历；
     * 归并排序的代码框架可看作是二叉树的后序遍历；
     * 快速排序功能方法中双指针移动方向:|->      <-|   |表示收尾位置
     * 快速排序功能方法中双指针移动方向:|->  ->    |
     *
     *
     * 快速排序的整体思路：
     *    1.先找到一个位置，这个位置的左边的值小于这个位置，右边的值都大于这个位置。如何找到呢？
     *    2.以这个位置作为边界，形成两部分，分别递归的进行第一步的操作。
     *    1.1.第一步的如何找到呢？
     *      a.随机取一个元素作为target，双指针从头尾两方相对方向(-> <-)，与target 比较：左边找比target 大的，右边找比target 小的，位置互换。
     *      比完一趟后，返回左边位置(为什么返回左边位置呢)
     *
     * 归并排序的整体思路：
     *    1.先找到一个位置，这个位置是正中间的位置
     *    2.以这个位置作为边界，形成两部分，分别递归的进行第一步的操作
     *    3.最后合并这两部分，合并时需要一个额外的临时数组，临时存要排序的arr[lo, hi]的数据。
     *      双指针都从左向右的，一个从头开始，一个从中间位置开始，相互比较，小的那个赋值到原数组的对应位置，一直末尾。
     *
     * 我统一使用 while 循环，不使用 for，以便统一好记
     * </pre>
     *
     * @param arr
     */
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
     * 为了和快速排序一起关联记忆，我用的是 while 条件，这个和左神的视频一致，算法4 用的是 for 条件
     * 左神：https://www.bilibili.com/video/BV1kQ4y1h7ok?p=3&vd_source=c3e9801497e408c0e02a3ddb59c2d64e 35分00秒
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
        int position = lo;
        while (i <= mid && j <= hi) {
//            if (temp[i] > temp[j]) {
//                arr[position] = temp[j];
//                j++;
//            } else {
//                arr[position] = temp[i];
//                i++;
//            }
//            position++;
            // 一行代码等于注释掉的 if else 代码
            arr[position++] = temp[i] > temp[j] ? temp[j++] : temp[i++];
        }
        while (i <= mid) {
            arr[position++] = temp[i++];
        }
        while (j <= hi) {
            arr[position++] = temp[j++];
        }
    }


    public static void main(String[] args) {
        LC2_Merge merge = new LC2_Merge();
        Integer[] array = new Integer[]{20, 30, 90, 60, 40, 50, 70, 10};
        merge.sort(array);
        show(array);
    }

}
