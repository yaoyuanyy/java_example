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

    BinaryTreeNode<Integer> root;

    public BinarySearchTreeImpl(Integer data) {
        this.root = new BinaryTreeNode<>(data);
    }

    @Override
    public BinaryTreeNode getRoot() {
        return root;
    }

    @Override
    public boolean insert(int data) {
        if(root == null) {
            root = new BinaryTreeNode<>(data);
            return true;
        }

        BinaryTreeNode<Integer> node = root;

        while (node != null) {
            if(data < node.data) {
                if(node.leftChild == null) {
                    BinaryTreeNode newNode = new BinaryTreeNode<>(data);
                    node.leftChild = newNode;
                    return true;
                }
                node = node.leftChild;
            }else {
                if(node.rightChild == null) {
                    BinaryTreeNode newNode = new BinaryTreeNode<>(data);
                    node.rightChild = newNode;
                    return true;
                }
                node = node.rightChild;
            }
        }

        return false;
    }

    @Override
    public BinaryTreeNode<Integer> find(int targetData) {
        BinaryTreeNode<Integer> node = root;

        while (node != null){
            if(targetData == node.data) {
                return node;
            }else if(targetData < node.data) {
                node = node.leftChild;
            }else {
                node = node.rightChild;
            }
        }

        return null;
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
}
