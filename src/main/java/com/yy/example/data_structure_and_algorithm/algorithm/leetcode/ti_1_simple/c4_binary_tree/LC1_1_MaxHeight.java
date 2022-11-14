package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_1_simple.c4_binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: 二叉树的最大深度
 * <pre>
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/
 * refer to https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-06 at 08:15
 */
public class LC1_1_MaxHeight {

    /**
     * DFS：使用递归
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if(null == root) {
            return 0;
        }

        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    /**
     * BFS：使用队列
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                if(treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        LC1_1_MaxHeight maxHeight = new LC1_1_MaxHeight();

        TreeNode treeNode20 = new TreeNode(20);
        treeNode20.left = new TreeNode(15);
        treeNode20.right = new TreeNode(7);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = treeNode20;

        int maxDepth = maxHeight.maxDepth2(root);
        System.out.println(maxDepth);
    }
}
