package com.yy.example.data_structure_and_algorithm.binary_tree.search;

import com.yy.example.data_structure_and_algorithm.binary_tree.BinaryTreeNode;

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
public class BinarySearchTreeImpl implements BinarySearchTree{

    @Override
    public BinaryTreeNode find(int key) {
        return null;
    }

    @Override
    public boolean insert(int data) {
        return false;
    }

    /**
     * 前序遍历
     * @param node
     */
    @Override
    public void infixOrder(BinaryTreeNode node){

        if(Objects.isNull(node)) return;
        System.out.println("node.data:" + node.data);
        infixOrder(node.leftChild);
        infixOrder(node.rightChild);
    }

    /**
     * 中序遍历
     * @param node
     */
    @Override
    public void preOrder(BinaryTreeNode node){
        if(Objects.isNull(node)) return;

        preOrder(node.leftChild);
        System.out.println("node.data:" + node.data);
        preOrder(node.rightChild);
    }

    /**
     * 后序遍历
     * @param node
     */
    @Override
    public void postOrder(BinaryTreeNode node){
        if(Objects.isNull(node)) return;

        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.println("node.data:" + node.data);
    }

    @Override
    public BinaryTreeNode findMax() {
        return null;
    }

    @Override
    public BinaryTreeNode findMin() {
        return null;
    }

    @Override
    public boolean delete(int key) {
        return false;
    }

}
