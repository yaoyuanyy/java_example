package com.yy.example.data_structure_and_algorithm.binary_tree;

import java.util.Objects;

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
public class BinaryTreeImpl implements BinaryTree{

    BinaryTreeNode root;

    /**
     * 创建带有根节点的二叉树
     *
     */
    public BinaryTreeImpl(String[] array) {
        this.root = create(array, 0);
        System.out.println("root.data:" + root.data);
    }

    public BinaryTreeImpl(BinaryTreeNode root) {
        this.root = root;
    }

    @Override
    public BinaryTreeNode getRoot() {
        return root;
    }

    @Override
    public int size(BinaryTreeNode treeNode) {
        if(Objects.isNull(treeNode)) {
            return 0;
        }
        return 1 + size(treeNode.leftChild) + size(treeNode.rightChild);
    }

    /**
     * 求二叉树深度
     */
    @Override
    public int depth(BinaryTreeNode node) {

        if(node == null) {
            return 0;
        }
        int depth1 = depth(node.leftChild);
        int depth2 = depth(node.rightChild);

        return Math.max(depth1, depth2) + 1;
    }

    @Override
    public int leafNodeCount(BinaryTreeNode node) {

        if(node == null) {
            return 0;
        }

        if (node.leftChild == null && node.rightChild == null) {
            return 1;
        }

        return leafNodeCount(node.leftChild) + leafNodeCount(node.rightChild);
    }

     @Override
    public int overKLayCount(BinaryTreeNode node, int k) {
        return overKLayCount(node, k, 0);
    }

    private int overKLayCount(BinaryTreeNode node, int k, int i) {
        i ++;
        if(node == null) {
            return 0;
        }

        if(i > k) {
            return 0;
        }

        return overKLayCount(node.leftChild, k, i) + overKLayCount(node.rightChild, k, i) + 1;
    }


    @Override
    public int onKLayCount(BinaryTreeNode node, int k) {
        return onKLayCount(node, k, 0);
    }

    private int onKLayCount(BinaryTreeNode node, int k, int i) {
        i ++;
        if(node == null) {
            return 0;
        }

        if(i == k) {
            return 1;
        }

        return onKLayCount(node.leftChild, k, i) + onKLayCount(node.rightChild, k, i);
    }
}
