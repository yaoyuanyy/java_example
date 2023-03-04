package com.yy.example.data_structure_and_algorithm.leetcode_2302_problems1_150;

/**
 * Description: 11. 盛最多水的容器
 * <pre>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC11_MaxArea {

    /**
     * 双指针：首尾各一个指针，相对方向移动 -> <-
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (i < j) {
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if(height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] waters = new int[]{1,8,6,2,5,4,8,3,7};
        int res = new LC11_MaxArea().maxArea(waters);
        System.out.println("res:" + res);
    }
}
