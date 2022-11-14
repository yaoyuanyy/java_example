package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c4_binary_tree;

/**
 * Description: 是否为满二叉树
 * <pre>
 *  二叉树题目递归套路：解决树形DP（树形动态规划）练习
 *  refer to https://www.bilibili.com/video/BV13g41157hK?p=7 01:10:00
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-24 at 09:16
 */
public class LC2_4_IsFullBinaryTree {

    /**
     * 满二叉树的条件
     * 1. 左子树是满二叉树
     * 2. 右子树是满二叉树
     * 3. sum = 2^height - 1
     *
     * 未满足以上条件：
     * 每个节点要给出信息：height，nodes
     * @param root
     * @return
     */
    private boolean isFull(TreeNode root) {
        if(null == root) {
            return true;
        }
        ResultData resultData = process(root);
        return resultData.nodes == 1 << resultData.height - 1;
    }

    private ResultData process(TreeNode root) {
        if(null == root) {
            return new ResultData(0, 0);
        }
        ResultData leftData = process(root.left);
        ResultData rightData = process(root.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new ResultData(height, nodes);
    }

    public static class ResultData {
        private int height;
        private int nodes;
        public ResultData() {
        }
        public ResultData(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
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
