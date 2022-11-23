package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_4_binary_tree;

/**
 * Description: 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xoxzgv/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC7_IsDuiChen {

    /**
     * 迭代
     * 技巧：引入一个队列，这是把递归程序改写成迭代程序的常用方法。
     * https://leetcode.cn/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
     * @param root
     * @return
     */
    public boolean isSymmetric0(TreeNode root) {
        return false;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        boolean f1 = symmetric(node1.left, node2.right);
        boolean f2 = symmetric(node1.right, node2.left);
        return f1 && f2;
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
        treeNode20.left = new TreeNode(21);
        treeNode20.right = new TreeNode(22);

        TreeNode node9 = new TreeNode(9);
        node9.left = new TreeNode(91);
        node9.right = new TreeNode(92);

        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = treeNode20;

        boolean symmetric = new LC7_IsDuiChen().isSymmetric(root);
        System.out.println(symmetric);
    }
}
