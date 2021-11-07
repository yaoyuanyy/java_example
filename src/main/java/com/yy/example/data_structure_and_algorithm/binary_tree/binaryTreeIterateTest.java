package com.yy.example.data_structure_and_algorithm.binary_tree;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-08 at 11:13
 */
public class binaryTreeIterateTest {

    /**
     * 原始数据：a  b  c  d  e  f  g  h  i
     * <pre>
     *             a
     *        b          c
     *    d      e   f       g
     * h     i
     * </pre>
     *
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTreeImpl();
        BinaryTreeIterate binaryTreeIterate = new BinaryTreeIterate();
//        binaryTreeIterate.iterByLayer(binaryTree.getRoot());
//        binaryTreeIterate.iterByDepth(binaryTree.getRoot());
//        binaryTreeIterate.iterByQianXu(binaryTree.getRoot());
        binaryTreeIterate.iterByZhongXu(binaryTree.getRoot());
    }
}
