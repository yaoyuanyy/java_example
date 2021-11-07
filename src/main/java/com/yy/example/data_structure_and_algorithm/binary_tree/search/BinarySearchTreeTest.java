package com.yy.example.data_structure_and_algorithm.binary_tree.search;

import com.yy.example.data_structure_and_algorithm.binary_tree.TreeNode;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020/3/26 at 10:37 上午
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl(10);
        binarySearchTree.insert(20);
        binarySearchTree.insert(80);
        binarySearchTree.insert(50);
        binarySearchTree.insert(90);
        binarySearchTree.insert(15);

        TreeNode root = binarySearchTree.getRoot();
        System.out.println("root.data:" + root.data);

        System.out.println("找到50了吗：" + binarySearchTree.find(50).data);
    }
}
