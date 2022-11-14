package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c5_sort_search;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/14/22 at 10:32 AM
 */
public class LC2_02_BinarySearch {

    public int search(int[] nums, int target) {
        if(nums == null) {
            return -1;
        }
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = (s + e) >> 1;
            if(nums[m] > target) {
                e = m - 1;
            }else if(nums[m] < target) {
                s = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        LC2_02_BinarySearch binarySearch = new LC2_02_BinarySearch();
        System.out.println(binarySearch.search(arr, 9));
    }
}
