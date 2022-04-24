package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c4_binary_tree;

/**
 * Description: 是否为满二叉树
 * <pre>
 *  二叉树题目递归套路：解决树形DP（树形动态规划）练习
 *
 *  https://www.bilibili.com/video/BV13g41157hK?p=7 01:10:00
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-24 at 09:16
 */
public class LC2_4_IsFullBinaryTree {

    private boolean isFull(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {
        LC2_4_IsFullBinaryTree isFullBinaryTree = new LC2_4_IsFullBinaryTree();

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

        boolean res = isFullBinaryTree.isFull(root);
        System.out.println(res);
    }
}
