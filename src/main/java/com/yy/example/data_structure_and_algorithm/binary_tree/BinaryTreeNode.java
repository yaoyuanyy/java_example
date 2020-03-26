package com.yy.example.data_structure_and_algorithm.binary_tree;

/**
 * Description:
 * <pre>
 *   二叉树节点类结构
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020/3/24 at 5:42 下午
 */
public class BinaryTreeNode<T> {
    /**
     * 这里的属性定义为public，完全是为了试验方便，工作中不要这样
     */
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
    public T data;
    
    public BinaryTreeNode(final T data) {
        this.leftChild = null;
        this.rightChild = null;
        this.data = data;
    }

    public BinaryTreeNode(final BinaryTreeNode leftChild, final BinaryTreeNode rightChild, final T data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return  leftChild;
    }

    public void setLeft( BinaryTreeNode leftChild) {
        this. leftChild =  leftChild;
    }

    public BinaryTreeNode getRight() {
        return rightChild;
    }

    public void setRight( BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", data=" + data +
                '}';
    }
}
