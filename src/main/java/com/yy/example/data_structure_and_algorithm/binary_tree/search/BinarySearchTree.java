package com.yy.example.data_structure_and_algorithm.binary_tree.search;

import com.yy.example.data_structure_and_algorithm.binary_tree.TreeNode;

/**
 * Description:
 * <p> 二叉查找(搜索)(排序)树：定义：在二叉树的基础上，每个节点大于他的左子树，且小于他的右子树。</p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/4/12 at 下午5:19
 */
public interface BinarySearchTree {
    /**
     * 查找节点
     */
    TreeNode find(int key);

    /**
     * 插入新节点
     *
     * @param data
     * @return
     */
    boolean insert(int data);

    TreeNode getRoot();

    /**
     * 中序遍历
     *
     * @param current
     */
    void infixOrder(TreeNode current);

    /**
     * 前序遍历
     *
     * @param current
     */
    void preOrder(TreeNode current);

    /**
     * 后序遍历
     *
     * @param current
     */
    void postOrder(TreeNode current);

    /**
     * 查找最大值
     *
     * @return
     */
    TreeNode findMax();

    /**
     * 查找最小值
     *
     * @return
     */
    TreeNode findMin();

    /**
     * 删除节点
     *
     * @param key
     * @return
     */
    boolean delete(int key);

    // Other Method......
}


