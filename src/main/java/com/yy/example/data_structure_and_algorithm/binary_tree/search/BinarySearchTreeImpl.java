package com.yy.example.data_structure_and_algorithm.binary_tree.search;

import com.yy.example.data_structure_and_algorithm.binary_tree.TreeNode;

import java.util.Objects;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020/3/26 at 10:35 上午
 */
public class BinarySearchTreeImpl implements BinarySearchTree {

    TreeNode<Integer> root;

    public BinarySearchTreeImpl(Integer data) {
        this.root = new TreeNode<>(data);
    }

    @Override
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public boolean insert(int data) {
        if (root == null) {
            root = new TreeNode<>(data);
            return true;
        }

        TreeNode<Integer> node = root;

        while (node != null) {
            if (data < node.data) {
                if (node.left == null) {
                    TreeNode newNode = new TreeNode<>(data);
                    node.left = newNode;
                    return true;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    TreeNode newNode = new TreeNode<>(data);
                    node.right = newNode;
                    return true;
                }
                node = node.right;
            }
        }

        return false;
    }

    @Override
    public TreeNode<Integer> find(int targetData) {
        TreeNode<Integer> node = root;

        while (node != null) {
            if (targetData == node.data) {
                return node;
            } else if (targetData < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return null;
    }

    @Override
    public TreeNode findMax() {
        return null;
    }

    @Override
    public TreeNode findMin() {
        return null;
    }

    @Override
    public boolean delete(int key) {
        return false;
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    @Override
    public void infixOrder(TreeNode node) {

        if (Objects.isNull(node)) return;
        System.out.println("node.data:" + node.data);
        infixOrder(node.left);
        infixOrder(node.right);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    @Override
    public void preOrder(TreeNode node) {
        if (Objects.isNull(node)) return;

        preOrder(node.left);
        System.out.println("node.data:" + node.data);
        preOrder(node.right);
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    @Override
    public void postOrder(TreeNode node) {
        if (Objects.isNull(node)) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println("node.data:" + node.data);
    }
}
