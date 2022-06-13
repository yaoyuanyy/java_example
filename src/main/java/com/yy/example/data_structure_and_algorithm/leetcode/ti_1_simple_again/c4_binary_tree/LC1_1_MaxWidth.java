package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple_again.c4_binary_tree;

/**
 * Description: 二叉树的最大宽度
 * <pre>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 2 。
 *
 * 链接：https://www.bilibili.com/video/BV13g41157hK?p=6 01:50:00
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-06 at 08:15
 */
public class LC1_1_MaxWidth {

    /**
     * @param root
     * @return
     */
    public int maxWidth(TreeNode root) {
        // todo
        return 0;
    }

    public static void main(String[] args) {
        LC1_1_MaxWidth maxHeight = new LC1_1_MaxWidth();

        TreeNode treeNode20 = new TreeNode(20);
        treeNode20.left = new TreeNode(15);
        treeNode20.right = new TreeNode(7);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = treeNode20;

        int maxDepth = maxHeight.maxWidth(root);
        System.out.println(maxDepth);
    }
}
