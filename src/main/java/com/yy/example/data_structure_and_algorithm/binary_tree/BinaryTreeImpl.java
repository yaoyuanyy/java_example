package com.yy.example.data_structure_and_algorithm.binary_tree;

import java.util.*;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020/3/24 at 5:56 下午
 */
public class BinaryTreeImpl implements BinaryTree {

    TreeNode root;

    /**
     * 创建带有根节点的二叉树
     */
    public BinaryTreeImpl(String[] array) {
        this.root = create(array, 0);
        System.out.println("root.data:" + root.data);
    }

    public BinaryTreeImpl() {
        this.root = init();
    }

    /**
     * <pre>
     *            a
     *        b          c
     *    d      e   f       g
     * h     i
     * </pre>
     */
    private TreeNode init() {
        this.root = new TreeNode("a");
        TreeNode node2 = new TreeNode("b");
        TreeNode node3 = new TreeNode("c");
        TreeNode node4 = new TreeNode("d");
        TreeNode node5 = new TreeNode("e");
        TreeNode node6 = new TreeNode("f");
        TreeNode node7 = new TreeNode("g");
        TreeNode node8 = new TreeNode("h");
        TreeNode node9 = new TreeNode("i");

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        System.out.println("root.data:" + root.data);
        return root;
    }

    public BinaryTreeImpl(TreeNode root) {
        this.root = root;
    }

    @Override
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public int size(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return 0;
        }
        return 1 + size(treeNode.left) + size(treeNode.right);
    }

    /**
     * 求二叉树深度
     */
    @Override
    public int depth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int depth1 = depth(node.left);
        int depth2 = depth(node.right);

        return Math.max(depth1, depth2) + 1;
    }

    @Override
    public int leafNodeCount(TreeNode node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return leafNodeCount(node.left) + leafNodeCount(node.right);
    }

    @Override
    public int overKLayCount(TreeNode node, int k) {
        return overKLayCount(node, k, 0);
    }

    private int overKLayCount(TreeNode node, int k, int i) {
        i++;
        if (node == null) {
            return 0;
        }

        if (i > k) {
            return 0;
        }

        return overKLayCount(node.left, k, i) + overKLayCount(node.right, k, i) + 1;
    }


    @Override
    public int onKLayCount(TreeNode node, int k) {
        return onKLayCount(node, k, 0);
    }

    private int onKLayCount(TreeNode node, int k, int i) {
        i++;
        if (node == null) {
            return 0;
        }

        if (i == k) {
            return 1;
        }

        return onKLayCount(node.left, k, i) + onKLayCount(node.right, k, i);
    }
}
