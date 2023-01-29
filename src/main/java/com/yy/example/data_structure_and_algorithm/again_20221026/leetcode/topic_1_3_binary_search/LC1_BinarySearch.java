package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_1_3_binary_search;

/**
 * Description: 二分查找
 * <pre>
 *
 * https://labuladong.github.io/algo/di-ling-zh-bfe1b/wo-xie-le--3c789/
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC1_BinarySearch {

    /**
     * 搜索一个元素:找到一个即返回
     *
     * @param sortedNums
     * @return
     */
    public int binarySearch(int[] sortedNums, int target) {
        int left = 0;
        int right = sortedNums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == sortedNums[mid]) {
                return mid;
            } else if (sortedNums[mid] > target) {
                right = mid - 1;
            } else if(sortedNums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 搜索左侧边界:找到元素第一次出现的位置
     *
     * @param sortedNums
     * @return
     */
    public int binarySearch2(int[] sortedNums, int target) {
        int left = 0;
        int right = sortedNums.length - 1;
        // 搜索区间[left,right]；终止条件：left=right+1,如果right=7，则left=8，即数组长度
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedNums[mid] == target) {
                // [left,mid] 此时，我们要的第一个肯定在mid的左侧(包含)，那么 right 左移就好了
                // 搜索区间[left,mid-1]
                right = mid - 1;
            } else if (sortedNums[mid] > target) {
                // 搜索区间[left,mid-1]
                right = mid - 1;
            } else if(sortedNums[mid] < target){
                // 搜索区间[mid + 1,right]
                left = mid + 1;
            }
        }
        // 当 target 大于所有元素时，条件成立
        if (left == sortedNums.length) {
            return -1;
        }
        // 当 target 小于所有元素时，-1条件成立
        return sortedNums[left] == target ? left : -1;
    }

    /**
     * 搜索右侧边界：找到元素最后一次出现的位置
     *
     * @param sortedNums
     * @return
     */
    public int binarySearch3(int[] sortedNums, int target) {
        int left = 0;
        int right = sortedNums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedNums[mid] == target) {
                // [mid,right] 此时，我们要的最后一个肯定在mid的右侧(包含)，那么 left 右移就好了
                // 搜索区间[mid + 1,right]
                left = mid + 1;
            } else if (sortedNums[mid] > target) {
                // 搜索区间[left,mid-1]
                right = mid - 1;
            } else if(sortedNums[mid] < target){
                // 搜索区间[mid + 1,right]
                left = mid + 1;
            }
        }
        // 当 target 大于所有元素时，条件成立
        if (right < 0) {
            return -1;
        }
        // 当 target 大于所有元素时，-1条件成立
        return sortedNums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 6, 6, 6, 9, 10, 11};
        int target = 6;
        int first = new LC1_BinarySearch().binarySearch2(arr, target);
        System.out.println("first:" + first);

        int last = new LC1_BinarySearch().binarySearch3(arr, target);
        System.out.println("last:" + last);
    }
}
