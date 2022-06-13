package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c4_binary_tree;

/**
 * Description: 二叉树节点总数
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-24 at 09:11
 */
public class LC0_1_SumOfBinaryTreeNode {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private int sum(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    private int sum2(TreeNode root) {
        // todo
        return 0;
    }

    public static void main(String[] args) {
        LC0_1_SumOfBinaryTreeNode sumOfBinaryTreeNode = new LC0_1_SumOfBinaryTreeNode();
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

        int sum = sumOfBinaryTreeNode.sum(root);
        System.out.println(sum);
    }
}
