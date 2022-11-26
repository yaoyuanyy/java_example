package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 荷兰国旗问题
 * <pre>
 *   一个数组arr，一个数num，请把小于等于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。
 *   要求空间复杂度O(1)，时间复杂度O(n)
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-10-17 at 14:32
 */
public class P3_03_01_HeLan {

    public static void main(String[] args) {
        int[] array = new int[]{20, 60, 90, 80, 40, 60, 70, 10};
        sort2(array, 60);
        show(array);
    }

    private static void sort(int[] array, int num) {
        int i = 0;
        int p1 = 0;
        int p2 = array.length - 1;
        while (i < p2){
            if(array[i] < num){
                exch(array, p1, i);
                p1++;
                i++;
            }else if(array[i] > num) {
                exch(array, p2, i);
                p2--;
            }else {
                i++;
            }

            System.out.print("i:" + i + " => ");
            show(array);

        }
    }

    /**
     * 20 10 40 60 60 70 80 90
     * @param arr
     * @param num
     */
    public static void sort2(int arr[], int num) {
        int left = -1, right = arr.length;
        int i = 0;
        while (i < right) {
            if (arr[i] < num) {//如果被分析的数小于用来比较的数值，则把这个数与其指针left指向的下一个数值交换，因为指针指向的下一个值是被分析过的，所以交换后不需要分析直接i++
                exch(arr, i++, ++left);
            } else if (arr[i] > num) {
                exch(arr, i, --right);//被交换过的数字没有被分析过，所以i指向不变
            } else{
                i++;//比较的两个数相等则直接跳向下一个
            }
            System.out.print("i:" + i + " => ");
            show(arr);
        }
    }

    public static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
