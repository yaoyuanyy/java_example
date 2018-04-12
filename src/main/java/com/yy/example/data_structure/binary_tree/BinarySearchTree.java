package com.yy.example.data_structure.binary_tree;

import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Description:
 * <p> 二叉查找树：定义：当前根节点的左边全部比根节点小，当前根节点的右边全部比根节点大。</p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/4/12 at 下午5:19
 */
public class BinarySearchTree {

    private TreeNode<Integer> root;

    public TreeNode<Integer> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<Integer> root) {
        this.root = root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree2 = new BinarySearchTree();

        for(int i: new int[]{6,3,51,92,132,22,8}) {
            tree2.createBinaryTree(tree2.getRoot(), i);
        }

        preTraverseBTree(tree2.getRoot());
    }

    public void createBinaryTree(TreeNode<Integer> root, int i) {
        // 这么写有问题，分析一下
//        if (Objects.isNull(root)) {
//            root = new TreeNode(i);
//            return;
//        }

        if (Objects.isNull(getRoot())) {
            setRoot(new TreeNode(i));
            return;
        }

        TreeNode<Integer> tmp = root;
        while (tmp != null) {
            if(i <= tmp.getData()) {
                if(tmp.getLeft() == null) {
                    tmp.setLeft(new TreeNode(i));
                    return;
                }else {
                    tmp = tmp.getLeft();
                }
            }else {
                if(tmp.getRight() == null){
                    tmp.setRight(new TreeNode(i));
                    return;
                }else {
                    tmp = tmp.getRight();
                }
            }
        }
    }


    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public static void preTraverseBTree(TreeNode root) {

        if (root != null) {

            //访问左节点
            preTraverseBTree(root.getLeft());

            //访问根节点
            System.out.println(root.getData());

            //访问右节点
            preTraverseBTree(root.getRight());
        }
    }


    static class TreeNode<T> {
        private TreeNode left;
        private TreeNode right;
        private T data;

        public TreeNode(T data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }


}


