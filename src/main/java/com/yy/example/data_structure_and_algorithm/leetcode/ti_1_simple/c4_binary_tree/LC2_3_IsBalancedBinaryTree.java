package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c4_binary_tree;

import lombok.Data;

/**
 * Description: 是否为平衡二叉树
 * <pre>
 *  二叉树题目递归套路：解决树形DP（树形动态规划）练习
 *
 *  平衡二叉树条件：
 *  1. 左子树是平衡二叉树
 *  2. 右子树是平衡二叉树
 *  3. |左高 - 右高| >= 1
 *
 *  为使用上这三个条件：我们需要左子树提供的信息有 1.左子树是否是平衡的 & 高度；1.右子树是否是平 衡的 & 高度
 *
 *  https://www.bilibili.com/video/BV13g41157hK?p=7 00:36:00
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-18 at 07:51
 */
public class LC2_3_IsBalancedBinaryTree {

    @Data
    public static class ResultData {
        private boolean isBalanced;
        private int height;

        private ResultData(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    /**
     * 使用二叉树题目递归套路
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(null == root) {
            return true;
        }

        return process(root).isBalanced;
    }

    private ResultData process(TreeNode root) {
        if(null == root) {
            return new ResultData(true, 0);
        }
        ResultData leftData = process(root.left);
        ResultData rightData = process(root.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = (leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2);
        return new ResultData(isBalanced, height);
    }

    public static void main(String[] args) {
        LC2_3_IsBalancedBinaryTree isBalancedBinaryTree = new LC2_3_IsBalancedBinaryTree();

        /**
         *     10
         *    / \
         *   3  15
         *     /  \
         *    12   19
         *   /  \
         *  2   14
         */
        TreeNode treeNode12 = new TreeNode(12);
        treeNode12.left = new TreeNode(2);
        treeNode12.right = new TreeNode(14);

        TreeNode treeNode15 = new TreeNode(15);
        treeNode15.left = treeNode12;
        treeNode15.right = new TreeNode(19);

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.right = treeNode15;

        boolean res = isBalancedBinaryTree.isBalanced(root);
        System.out.println(res);
    }
}
