package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_4_binary_tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xo566j/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC8_PathSum {

    /**
     * 递归：分解问题的解题方式：
     * 思路：要想知道整个路径的和是不是targetSum，只要知道去掉root剩下的总和是否等于targetSum-root.val就可以了，以此类推
     * 终止条件是啥呢，题目要求是到叶子节点，所以，当是叶子节点时，判断targatSum == root.val，即可
     * 所以，可以用分解问题的方式解题
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        boolean l = hasPathSum(root.left, targetSum - root.val);
        boolean r = hasPathSum(root.right, targetSum - root.val);
        return l || r;
    }

    /**
     * BFS: 将遍历过程中的节点val累加，到叶子节点时与targetSum比较
     *
     * BTW: 此题关键是遍历到叶子节点，然后val值比较。至于如何遍历，DFS，BFS，迭代都可以
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queue.add(root);
        queueValue.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int tmpSum = queueValue.poll();
            // 到叶子节点时，判断累加val是否等于targetSum
            if(node.left == null && node.right == null) {
                if(tmpSum == targetSum) {
                    return true;
                }
                continue;
            }
            if(node.left != null) {
                queue.add(node.left);
                queueValue.add(node.left.val + tmpSum);
            }
            if(node.right != null) {
                queue.add(node.right);
                queueValue.add(node.right.val + tmpSum);
            }
        }
        return false;
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
        treeNode20.left = new TreeNode(21);
        treeNode20.right = new TreeNode(22);

        TreeNode node9 = new TreeNode(9);
        node9.left = new TreeNode(91);
        node9.right = new TreeNode(92);

        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = treeNode20;

        boolean symmetric = new LC8_PathSum().hasPathSum(root, 103);
        System.out.println(symmetric);
    }
}
