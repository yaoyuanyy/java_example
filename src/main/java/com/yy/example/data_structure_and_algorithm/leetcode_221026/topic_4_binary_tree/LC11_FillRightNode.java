package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_4_binary_tree;

/**
 * Description: 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xoo0ts/
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC11_FillRightNode {

    /**
     * 层序遍历的解题方式
     *
     * @param root
     * @return
     */
    public TreeNode connect0(TreeNode root) {

        return root;
    }

    /**
     * 递归迭代的解题方式
     *
     * @param root
     * @return
     */
    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        doConnect(root.left, root.right);
        return root;
    }

    /**
     * 分解问题的关键：定义这个方法是干啥的，目的是啥
     * 递归的将node1.next 指向 node2
     *
     * @param node1
     * @param node2
     * @return
     */
    private void doConnect(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        doConnect(node1.left, node1.right);
        doConnect(node2.left, node2.right);
        doConnect(node1.right, node2.left);
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

        TreeNode treeNode = new LC11_FillRightNode().connect(root);
        System.out.println(treeNode);
    }
}
