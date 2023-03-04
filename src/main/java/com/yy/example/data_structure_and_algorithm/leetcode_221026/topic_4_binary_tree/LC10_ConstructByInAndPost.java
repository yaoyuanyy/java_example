package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_4_binary_tree;

/**
 * Description: 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xo98qt/
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC10_ConstructByInAndPost {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);

        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new LC10_ConstructByInAndPost().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(treeNode);
    }
}
