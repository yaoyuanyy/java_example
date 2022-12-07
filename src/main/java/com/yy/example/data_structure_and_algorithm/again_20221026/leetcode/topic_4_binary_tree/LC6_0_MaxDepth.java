package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_4_binary_tree;

/**
 * Description: 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xoh1zg/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC6_0_MaxDepth {

    /**
     * 使用分解问题的解题方式
     * 要想获取整个二叉树的最大高度，其子问题就是先获取其子数的最大高度，然后+1，即可
     * 所以，涉及子问题，逻辑代码放在后序位置
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        // *** 后序位置：逻辑代码
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    int maxDepth = 0;
    /**
     * 使用遍历的解题方式
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 值传1的原因：根节点本身的高度是1
        doMaxDepth(root, 1);
        return maxDepth;
    }

    /**
     * 从根节点逐一的计算到叶子节点的高度，不断取最大的高度
     *
     * @param root
     * @param depth
     */
    private void doMaxDepth(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        // 说明已到叶子节点，算下根节点到这个叶子节点的告诉；有很多叶子节点都要算高度，不断取最大的高度
        if(root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        doMaxDepth(root.left, depth + 1);
        doMaxDepth(root.right, depth + 1);
    }

    public static void main(String[] args) {
        /**
         *        3
         *      /   \
         *     9    20
         *   / \    / \
         *  91 92  21 22
         */
        TreeNode treeNode20 = new TreeNode(20);
//        treeNode20.left = new TreeNode(21);
//        treeNode20.right = new TreeNode(22);

        TreeNode node9 = new TreeNode(9);
        node9.left = new TreeNode(91);
        node9.right = new TreeNode(92);

        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = treeNode20;

        int maxDepth = new LC6_0_MaxDepth().maxDepth2(root);
        System.out.println(maxDepth);
    }
}
