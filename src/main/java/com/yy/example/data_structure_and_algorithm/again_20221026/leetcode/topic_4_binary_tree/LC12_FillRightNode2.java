package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_4_binary_tree;

import javax.xml.namespace.QName;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description: 填充每个节点的下一个右侧节点指针 II
 * 与填充每个节点的下一个右侧节点指针 I 的区别为 root不是完全二叉树，即有的节点位置可能没有节点
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC12_FillRightNode2 {

    /**
     * 层序遍历的解题方式
     * 此题是横向看，是两个相邻节点之间的联系，所以这正是层序遍历的特点
     *
     * @param root
     * @return
     */
    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
//                System.out.println(node.val);
                if(i != size - 1) {
                    node.next = queue.peek();
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
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

        TreeNode treeNode = new LC12_FillRightNode2().connect(root);
        System.out.println(treeNode);
    }
}
