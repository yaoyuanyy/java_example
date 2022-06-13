package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c4_binary_tree;

import java.util.LinkedList;

/**
 * Description: 是否为完全二叉树
 * <pre>
 * 若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * 翻译成白话文就是，除了最后一层都是满的，最后一层从左到右都是满的，中间没有空的。
 *
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 *
 * 针对完全二叉树的特点：我们采用宽度优先遍历。同时判断两个条件
 * 1. 一个节点没有左子树 & 有右子树时，不是完全二叉树
 * 2. 在不违反 1 的情况下，出现左右子树不双全时，不是完全二叉树
 *
 * https://www.bilibili.com/video/BV13g41157hK?p=7 00:20:00
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-18 at 07:46
 */
public class LC2_2_IsWanQuanBinaryTree {

    /**
     * 应用广度优先遍历
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            root = queue.poll();
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(left == null && right != null) {
                return false;
            }
            if(leaf && (left != null || right != null)){
                return false;
            }
            if(left == null || right == null) {
                leaf = true;
            }
            if(null != root.left) {
                queue.add(root.left);
            }
            if(null != root.right) {
                queue.add(root.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC2_2_IsWanQuanBinaryTree isWanQuanBinaryTree = new LC2_2_IsWanQuanBinaryTree();

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

        boolean res = isWanQuanBinaryTree.isCompleteTree(root);
        System.out.println(res);
    }

}
