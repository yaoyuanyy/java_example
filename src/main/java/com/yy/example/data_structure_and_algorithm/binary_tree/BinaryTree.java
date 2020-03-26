package com.yy.example.data_structure_and_algorithm.binary_tree;

import javax.swing.tree.TreeNode;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020/3/26 at 6:58 下午
 */
public interface BinaryTree {


    BinaryTreeNode getRoot();

    /**
     * 使用一个数组创建二叉树
     */
    default BinaryTreeNode create(String[] array, int i) {
        BinaryTreeNode tmp = null;
        if(i != array.length){
            tmp = new BinaryTreeNode(array[i]);
        }
        if(i < array.length / 2) {
            tmp.leftChild = create(array, 2*i+1);
            tmp.rightChild = create(array, 2*i+2);
        }
        return tmp;
    }

    /**
     * 求二叉树长度
     *
     * @param treeNode
     * @return
     */
    int size(BinaryTreeNode treeNode);

    /**
     * 求二叉树深度
     *
     * @param node
     * @return
     */
    int depth(BinaryTreeNode node);

    /**
     * 求二叉树中叶子节点的个数
     * @return
     */
    int leafNodeCount(BinaryTreeNode node);


    /**
     * 求二叉树第K层以上的节点个数
     *
     * @param k
     * @return
     */
    int overKLayCount(BinaryTreeNode node, int k);

    /**
     * 求二叉树第K层的节点个数
     * @param k
     * @return
     */
    int onKLayCount(BinaryTreeNode node, int k);

}
