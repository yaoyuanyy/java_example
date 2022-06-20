package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c4_binary_tree;

/**
 * Description: 将有序数组转换为二叉搜索树
 * <pre>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-17 at 22:18
 */
public class LC5_SortedArray2SearchBinaryTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(end < start) {
            return null;
        }
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        LC5_SortedArray2SearchBinaryTree sortedArray2SearchBinaryTree = new LC5_SortedArray2SearchBinaryTree();
        TreeNode root = sortedArray2SearchBinaryTree.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
