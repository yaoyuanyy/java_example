package com.yy.example.data_structure_and_algorithm.binary_tree;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020/3/26 at 7:27 下午
 */
public class BinaryTreeTest {

    /**
     * <pre>
     *            a
     *        b          c
     *    d      e   f       g
     * h     i
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        final String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        BinaryTree binaryTree = new BinaryTreeImpl(array);

        //System.out.println("size:" + binaryTree.size(binaryTree.getRoot()));

        //System.out.println("depth:" + binaryTree.depth(binaryTree.getRoot()));

        //System.out.println("onKLayCount:" + binaryTree.onKLayCount(binaryTree.getRoot(), 4));

        System.out.println("overKLayCount:" + binaryTree.overKLayCount(binaryTree.getRoot(), 3));

    }
}
