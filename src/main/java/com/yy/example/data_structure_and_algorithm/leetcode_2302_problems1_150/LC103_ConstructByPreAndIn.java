package com.yy.example.data_structure_and_algorithm.leetcode_2302_problems1_150;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/26 at 18:08
 */
public class LC103_ConstructByPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE) {
        if(preS > preE) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preS]);
        int index = -1;
        // 找到root 节点的索引下标
        for (int i = 0; i < inorder.length; i++) {
            if(preorder[preS] == inorder[i]) {
                index = i;
                break;
            }
        }
        // root 节点左子树的节点个数
        int leftSize = index - inS;
        root.left = doBuildTree(preorder, preS + 1, preS + leftSize, inorder, inS, index - 1);
        root.right = doBuildTree(preorder, preS + leftSize + 1, preE, inorder, index + 1, inE);
        return root;
    }

    public static void main(String[] args) {
        /**
         *        3
         *      /   \
         *     9    20
         *   / \    / \
         *  91 92  21 22
         */
        TreeNode treeNode = new LC103_ConstructByPreAndIn().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(treeNode);
    }
}
