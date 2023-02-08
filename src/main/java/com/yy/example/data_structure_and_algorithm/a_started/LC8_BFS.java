package com.yy.example.data_structure_and_algorithm.a_started;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 二叉树的广度优先遍历
 * <pre>
 * 从上向下一层一层的打印节点
 *
 * BFS的应用：层序遍历相关问题、最短路径相关问题
 *
 * 可以看到，「BFS 遍历」、「层序遍历」、「最短路径」实际上是递进的关系。在 BFS 遍历的基础上区分遍历的每一层，就得到了层序遍历。在层序遍历的基础上记录层数，就得到了最短路径。
 * BFS 遍历是一类很值得反复体会和练习的题目。一方面，BFS 遍历是一个经典的基础算法，需要重点掌握。另一方面，我们需要能根据题意分析出题目是要求最短路径，知道是要做 BFS 遍历。
 * 本文讲解的只是两道非常典型的例题。LeetCode 中还有许多层序遍历和最短路径的题目
 *
 * LeetCode 例题精讲 | 12 岛屿问题：网格结构中的 DFS(启发性的文章＊＊＊https://mp.weixin.qq.com/s?__biz=MzA5ODk3ODA4OQ==&mid=2648167208&idx=1&sn=d8118c7c0e0f57ea2bdd8aa4d6ac7ab7&chksm=88aa236ebfddaa78a6183cf6dcf88f82c5ff5efb7f5c55d6844d9104b307862869eb9032bd1f&token=1064083695&lang=zh_CN#rd)
 *
 * 层序遍历的一些变种题目：
 * LeetCode 103. Binary Tree Zigzag Level Order Traversal 之字形层序遍历
 * LeetCode 199. Binary Tree Right Side View 找每一层的最右结点
 * LeetCode 515. Find Largest Value in Each Tree Row 计算每一层的最大值
 * LeetCode 637. Average of Levels in Binary Tree 计算每一层的平均值
 *
 * 对于最短路径问题，还有两道题目也是求网格结构中的最短路径，和我们讲解的距离岛屿的最远距离非常类似：
 * LeetCode 542. 01 Matrix
 * LeetCode 994. Rotting Oranges
 *
 * 还有一道在真正的图结构中求最短路径的问题：
 * LeetCode 310. Minimum Height Trees
 * 经过了本文的讲解，相信解决这些题目也不是难事。
 *
 * BFS及应用总结：https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC8_BFS {

    /**
     * 层序遍历打印：从上向下一层一层的遍历节点
     * 迭代方式
     *
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
     * @param root
     * @return
     */
    public void bfsOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
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

        new LC8_BFS().bfsOrder(root);
    }
}
