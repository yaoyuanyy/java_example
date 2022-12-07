package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_4_binary_tree;

/**
 * Description: 数组的最大值
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC6_2_MaxValueOfArray {

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public int maxValue(TreeNode root) {
        return 0;
    }

    public static void main(String[] args) {
        /**
         *        3
         *      /   \
         *     9    20
         *   / \    / \
         *  91 92  21 22
         */
        TreeNode treeNode20 = new TreeNode(20);
//        treeNode20.left = new TreeNode(21);
//        treeNode20.right = new TreeNode(22);

        TreeNode node9 = new TreeNode(9);
        node9.left = new TreeNode(91);
        node9.right = new TreeNode(92);

        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = treeNode20;

        int maxDepth = new LC6_2_MaxValueOfArray().maxValue(root);
        System.out.println(maxDepth);
    }
}
