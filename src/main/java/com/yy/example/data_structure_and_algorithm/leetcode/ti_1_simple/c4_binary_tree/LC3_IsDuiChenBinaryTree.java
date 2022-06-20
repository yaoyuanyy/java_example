package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c4_binary_tree;

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
public class LC3_IsDuiChenBinaryTree {

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
        LC3_IsDuiChenBinaryTree duiChenBinaryTree = new LC3_IsDuiChenBinaryTree();

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

        int a = 260;
        System.out.println((byte)(a >> 8));
        System.out.println((byte)(a >> 16));
        System.out.println((byte)(a >> 24));

        //69314
        System.out.println(Integer.toBinaryString(69314));
        System.out.println(Integer.toBinaryString(69314).length());
        //        0000 0000  0000 0000  0000 0000  0000 0000
        // a:      0000 0000  0000 0001  0000 1110  1100 0010  ---  (byte) a: 1100 0010 => 反码：1100 0001 => 原码：1011 1110 = -(2⁵ + 2⁴ + 2³ + 2² + 2) = -62
        //a >> 8:             0000 0000  0000 0001  0000 1110 & 0xFF = 1110 = 8 + 4 + 2 = 14
        //a >> 16:                       0000 0000  0000 0001 & 0xFF = 1
        //a >> 24:                                  0000 0000 & 0xFF = 0

        System.out.println(Integer.parseInt("10000111011000010", 2));

        System.out.println("=======");
        byte[] bytes = toBEIntByteArray(69314);
        for (byte b : bytes) {
            System.out.println(b);
        }
    }

    public static byte[] toBEIntByteArray(int value) {
        byte[] data = new byte[4];
        data[0] = (byte) (value); // -62
        data[1] = (byte) (value >>> 8);
        data[2] = (byte) (value >>> 16);
        data[3] = (byte) (value >>> 24);
        return data;
    }
}
