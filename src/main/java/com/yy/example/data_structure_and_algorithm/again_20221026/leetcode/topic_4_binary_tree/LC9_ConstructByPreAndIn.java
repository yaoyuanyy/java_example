package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_4_binary_tree;

/**
 * Description: 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xoei3r/
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC9_ConstructByPreAndIn {

    /**
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE) {
        if(preS > preE) return null;
        // 找到root 节点，前序遍历的第一个就是root 节点
        int rootValue = preorder[preS];
        TreeNode root = new TreeNode(rootValue);
        // 找到root两边的左右子树的数组范围
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootValue) {
                index = i;
                break;
            }
        }
        int leftSize = index - inS;
        root.left = build(preorder, preS + 1, preS + leftSize, inorder, inS, index - 1);
        root.right = build(preorder, preS + leftSize + 1, preE, inorder, index + 1, inE);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new LC9_ConstructByPreAndIn().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(treeNode);
    }
}
