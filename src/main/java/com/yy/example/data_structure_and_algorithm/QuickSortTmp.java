package com.yy.example.data_structure_and_algorithm;

import java.util.Arrays;

/**
 * Description:快速排序算法分析
 * <p>
 * 参考：：http://www.imooc.com/article/11013
 * </p>
 * <pre>
 * 快速排序思想：
 *
 * 通过对数据元素集合Rn 进行一趟排序划分出独立的两个部分。其中一个部分的关键字比另一部分的关键字小。
 * 然后再分别对两个部分的关键字进行一趟排序，直到独立的元素只有一个，此时整个元素集合有序。
 *
 * <B>特点：</B>
 * 1.算法是不稳定的
 * 2.每层排序大约需要O(n)复杂度。而一个长度为n的数组，调用深度最多为log(n)层。
 * 二者相乘，得到快速排序的平均复杂度为O(n ㏒n)。
 * </pre>
 * NB.
 * Created by skyler on 2017/12/16 at 上午11:41
 */
public class QuickSortTmp {

    public static void main(final String[] args) {
        final int[] a = {38, 65, 97, 46, 13, 27, 4};
        System.out.println("排序前：" + Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    public static void quickSort(final int[] a, final int low, final int high) {
        if (a == null || a.length < 2) {
            return;
        }
        if (high > low) {
            final int middle = partion(a, low, high);
            quickSort(a, low, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    public static int partion(final int[] a, int low, int high) {

        final int target = a[low];
        while (high > low) {
            while (high > low && a[high] > target) {
                high--;
            }
            if (high > low) {
                a[low++] = a[high];
            }

            while (high > low && a[low] < target) {
                low++;
            }
            if (high > low) {
                a[high--] = a[low];
            }

            a[low] = target;
        }
        return low;
    }
}
