package com.yy.example.data_structure_and_algorithm.binary_tree.search;

import com.yy.example.data_structure_and_algorithm.binary_tree.BinaryTreeNode;

/**
 * Description:
 * <p> 二叉查找树：定义：在二叉树的基础上，当前节点的左边全部比当前节点小，当前节点的右边全部比当前节点大。</p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/4/12 at 下午5:19
 */
public interface BinarySearchTree {
    /**
     * 查找节点
     */
    BinaryTreeNode find(int key);

    /**
     * 插入新节点
     * @param data
     * @return
     */
    boolean insert(int data);

    BinaryTreeNode getRoot();

    /**
     * 中序遍历
     * @param current
     */
    void infixOrder(BinaryTreeNode current);

    /**
     * 前序遍历
     * @param current
     */
    void preOrder(BinaryTreeNode current);

    /**
     * 后序遍历
     * @param current
     */
    void postOrder(BinaryTreeNode current);

    /**
     * 查找最大值
     * @return
     */
    BinaryTreeNode findMax();

    /**
     * 查找最小值
     * @return
     */
    BinaryTreeNode findMin();

    /**
     * 删除节点
     * @param key
     * @return
     */
    boolean delete(int key);

    // Other Method......
}


