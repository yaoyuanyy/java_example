package com.yy.example.data_structure_and_algorithm.binary_tree;

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


    TreeNode getRoot();

    /**
     * 使用一个数组创建二叉树
     */
    default TreeNode create(String[] array, int i) {
        TreeNode tmp = null;
        if (i != array.length) {
            tmp = new TreeNode(array[i]);
        }
        if (i < array.length / 2) {
            tmp.left = create(array, 2 * i + 1);
            tmp.right = create(array, 2 * i + 2);
        }
        return tmp;
    }

    /**
     * 求二叉树长度
     *
     * @param treeNode
     * @return
     */
    int size(TreeNode treeNode);

    /**
     * 求二叉树深度
     *
     * @param node
     * @return
     */
    int depth(TreeNode node);

    /**
     * 求二叉树中叶子节点的个数
     *
     * @return
     */
    int leafNodeCount(TreeNode node);


    /**
     * 求二叉树第K层以上的节点个数
     *
     * @param k
     * @return
     */
    int overKLayCount(TreeNode node, int k);

    /**
     * 求二叉树第K层的节点个数
     *
     * @param k
     * @return
     */
    int onKLayCount(TreeNode node, int k);

}
