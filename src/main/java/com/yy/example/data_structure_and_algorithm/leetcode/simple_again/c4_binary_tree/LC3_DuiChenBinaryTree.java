package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c4_binary_tree;

/**
 * Description: 对称二叉树
 * <pre>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * <img src="https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg">
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * <img src="https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg">
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-17 at 20:30
 */
public class LC3_DuiChenBinaryTree {

    public boolean isSymmetric(TreeNode root) {
        if(null == root) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(null == left && null == right) {
            return true;
        }
        if(null == left || null == right || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


    public static void main(String[] args) {
        LC3_DuiChenBinaryTree duiChenBinaryTree = new LC3_DuiChenBinaryTree();

        /**
         *        1
         *      /   \
         *     2     2
         *   /  \   /  \
         *  3    4 4    3
         */
        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(4);

        TreeNode treeNode22 = new TreeNode(2);
        treeNode22.left = new TreeNode(4);
        treeNode22.right = new TreeNode(3);

        TreeNode root = new TreeNode(1);
        root.left = treeNode2;
        root.right = treeNode22;

        boolean res = duiChenBinaryTree.isSymmetric(root);
        System.out.println(res);
    }
}
