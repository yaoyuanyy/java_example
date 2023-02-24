package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.problems1_150;

/**
 * Description: 4. 寻找两个正序数组的中位数
 * <pre>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC4_0_FindMedianSortedArrays {

    /**
     * 暴力法 - 归并法
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0d;
    }

    /**
     * 解法二
     * 思路：数组都是有序的，虽然是两个数组，如果将他们看成一个整体，长度和一组数组是一样的，中位数也是一个数组的中位数
     * 所以，假设数组1长度是m，数组2长度是n，整个数组长度就是 m + n，那么中位数就是 (m + n)/2这个位置值或两边的位置值的和除以2
     * 所以，我们只要遍历 (m + n)/2的次数，两个数组从左向右，值较小的那么数组的指针向右移动，然后再比较，再移动，直到遍历次数达到
     * (m+n)/2，这时候要观察整个数组的奇偶性，做逻辑，确定中位数的值
     * 思路参见视频：https://leetcode.cn/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
     * 代码参见：https://leetcode.cn/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int len = (m + n); // +1操作包含了m + n 是奇偶两种情况
        int step = 0;

        int left = 0;
        int right = 0;
        while (step <= len / 2) {
            left = right;
            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                right = nums1[i++];
            } else {
                // 代码走这里的条件：i>=m 或者 j < n && nums1[i] >= nums2[j]
                // 如果i>=m，那么j<n是一定成立的，不然不会满足step<len/2
                right = nums2[j++];
            }
            step++;
        }
        if ((m + n) % 2 == 0) {
            return (left + right) / 2.0;
        }
        return right;
    }

    /**
     * 方法三 找到一条中位线，这条线满足：
     * 1.中位数的左侧值都小于它，右侧值都大于它
     * 2.数组1的右侧第一个值大于数组2的左侧第一个值，数组2的右侧第一个值大于数组1的左侧第一个值
     *
     * 核心思路：nums1的长度为m，nums2的长度为n，中位数的位置为k。因为中位数的左侧值都小于它，右侧值都大于它
     * 所以，就有如下关系，nums1存在一个位置mx，nums2存在一个位置ny，使得mx + ny = k = (m + n)/2
     * <p>
     * https://github.com/javasmall/bigsai-algorithm/blob/master/leetcode/problems/LeetCode%2004%E5%AF%BB%E6%89%BE%E4%B8%A4%E4%B8%AA%E6%AD%A3%E5%BA%8F%E6%95%B0%E7%BB%84%E7%9A%84%E4%B8%AD%E4%BD%8D%E6%95%B0(%E5%9B%B0%E9%9A%BE)%E4%BA%8C%E5%88%86%E6%B3%95.md
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)//保证num1长度小，如果不小我交换一下
        {
            int team[] = nums2.clone();
            nums2 = nums1;
            nums1 = team;
        }
        int k = (nums1.length + nums2.length + 1) / 2;//理论中位数满足的位置
        int left = 0, right = nums1.length;//二分查找短的

        while (left < right) {//找到对应位置
            int m1 = (left + right) / 2;//在短的位置
            int m2 = k - m1;//在长的第几个
            //System.out.println(m1+" "+m2);
            // -1的原因是数组下标从0开始，m2表示第几个，如第一个对应nums2[0]
            if (nums1[m1] < nums2[m2 - 1])//left右移
                left = m1 + 1;
            else {//right左移
                right = m1;
            }
        }
        //System.out.println(left+" "+k);
        //左侧最大和右侧最小那个先算出来再说，根据奇偶再使用
        double leftbig = Math.max(
                left == 0 ? Integer.MIN_VALUE : nums1[left - 1],
                k - left == 0 ? Integer.MIN_VALUE : nums2[k - left - 1]);
        double rightsmall = Math.min(
                left == nums1.length ? Integer.MAX_VALUE : nums1[left],
                k - left == nums2.length ? Integer.MAX_VALUE : nums2[k - left]);
        //System.out.println(rightsmall);
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (leftbig + rightsmall) / 2;
        } else {
            return leftbig;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 7};
        int[] nums2 = new int[]{3, 4, 5, 6, 9, 10};
        double targetIndex = new LC4_0_FindMedianSortedArrays().findMedianSortedArrays3(nums1, nums2);
        System.out.println("targetIndex:" + targetIndex);
    }
}
