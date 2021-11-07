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
public class TreeNode<T> {
    /**
     * 这里的属性定义为public，完全是为了试验方便，工作中不要这样
     */
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T data;
    
    public TreeNode(final T data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public TreeNode(final TreeNode left, final TreeNode right, final T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public TreeNode getLeft() {
        return  left;
    }

    public void setLeft( TreeNode leftChild) {
        this. left =  left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight( TreeNode rightChild) {
        this.right = right;
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
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}
