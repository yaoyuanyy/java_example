package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c4_binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 102. 二叉树的层序遍历
 * <pre>
 *
 * 给你二叉树的根节点 root，返回其节点值的 层序遍历。（即逐层地，从左到右访问所有节点）
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * from:
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * refer to:
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
 *
 * LeetCode 中还有许多层序遍历和最短路径的题目
 * 层序遍历的一些变种题目：
 *   LeetCode 103. Binary Tree Zigzag Level Order Traversal 之字形（锯齿形）层序遍历
 *   LeetCode 199. Binary Tree Right Side View 找每一层的最右结点
 *   LeetCode 515. Find Largest Value in Each Tree Row 计算每一层的最大值
 *   LeetCode 637. Average of Levels in Binary Tree 计算每一层的平均值
 *
 * 对于最短路径问题，还有两道题目也是求网格结构中的最短路径，和我们讲解的距离岛屿的最远距离非常类似：
 *   LeetCode 542. 01 Matrix
 *   LeetCode 994. Rotting Oranges
 *
 * 还有一道在真正的图结构中求最短路径的问题：
 *   LeetCode 310. Minimum Height Trees
 *
 * 本文作者 nettee
 * 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-08 at 08:30
 */
public class LC4_100_LayIterator {

    /**
     * 广度优先遍历
     * BFS: 使用队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque();
        List<List<Integer>> res = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (null != node.left) {
                    deque.add(node.left);
                }
                if (null != node.right) {
                    deque.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 深度优先遍历
     * DFS: 使用递归
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        doLevelOrder2(root, 1, res);
        return res;
    }

    /**
     * 执行递归
     *
     * @param treeNode
     * @param level    第几层
     * @param res
     */
    public void doLevelOrder2(TreeNode treeNode, int level, List<List<Integer>> res) {
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        // 层与数组下标的关系
        res.get(level - 1).add(treeNode.val);

        if (null != treeNode.left) {
            doLevelOrder2(treeNode.left, level + 1, res);
        }
        if (null != treeNode.right) {
            doLevelOrder2(treeNode.right, level + 1, res);
        }
    }

    public static void main(String[] args) {
        LC4_100_LayIterator layIterator = new LC4_100_LayIterator();

        TreeNode treeNode20 = new TreeNode(20);
        treeNode20.left = new TreeNode(15);
        treeNode20.right = new TreeNode(7);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = treeNode20;

        List<List<Integer>> res = layIterator.levelOrder1(root);
        System.out.println(res);
    }
}
