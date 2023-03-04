package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_4_binary_tree;

import java.util.*;

/**
 * Description: 二叉树的广度优先遍历
 * <pre>
 * 从上向下一层一层的打印节点
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC4_BFS {

    /**
     * 层序遍历打印：从上向下一层一层的遍历节点
     * 迭代方式
     *
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
     * @param root
     * @return
     */
    public void bfsorderTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
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

        new LC4_BFS().bfsorderTraversal(root);
    }
}
