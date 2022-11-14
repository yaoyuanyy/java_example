package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.interviews;

import com.yy.example.data_structure_and_algorithm.binary_tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description: LC199 二叉树的右视图
 * <pre>
 * LC199: 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例 1:
 * <img src="https://assets.leetcode.com/uploads/2021/02/14/tree.jpg">
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 *
 * 示例 3:
 * 输入: []
 * 输出: []
 *
 * 方法一：广度优先搜索
 * 思路
 * 我们可以对二叉树进行层次遍历，那么对于每层来说，最右边的结点一定是最后被遍历到的。二叉树的层次遍历可以用广度优先搜索实现。
 * 算法
 * 执行广度优先搜索，左结点排在右结点之前，这样，我们对每一层都从左到右访问。因此，只保留每个深度最后访问的结点，我们就可以在遍历完整棵树后得到每个深度最右的结点。
 *
 * 方法二：深度优先搜索
 * 思路
 * 我们对树进行深度优先搜索，在搜索过程中，我们总是先访问右子树。那么对于每一层来说，我们在这层见到的第一个结点一定是最右边的结点。
 * 算法
 * 这样一来，我们可以存储在每个深度访问的第一个结点，一旦我们知道了树的层数，就可以得到最终的结果数组。
 *
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-08 at 07:21
 */
public class LC199_Binary_Tree_Right_Side_View {
    TreeNode<Integer> root;
    public static void main(String[] args) {
        LC199_Binary_Tree_Right_Side_View obj = new LC199_Binary_Tree_Right_Side_View();
        obj.init();
        obj.doRightSideView(obj.root);
    }

    /**
     * 使用深度优先算法为基础。其实最理想的方式是每个节点上附带层级字段，这样插入时把层级字段赋值，在遍历时直接获取每个层级的最后一个就好了。
     * 但是二叉树的节点结构不能改变。所以为了实现这个效果，再定义一个和 deque同步的levelValueDeque，充当deque的层级字段，从而实现功能
     * @param root
     */
    private void doRightSideView(TreeNode<Integer> root) {
        Map<Integer, TreeNode<Integer>> levelValueMap = new TreeMap<>();

        ArrayDeque<TreeNode<Integer>> deque = new ArrayDeque<>();
        ArrayDeque<Integer> levelValueDeque = new ArrayDeque<>();

        deque.add(root);
        levelValueDeque.add(0);

        while (!deque.isEmpty()) {
            TreeNode<Integer> node = deque.remove();
            int level = levelValueDeque.remove();

            levelValueMap.put(level, node);

            if(node.left!= null) {
                deque.add(node.left);
                levelValueDeque.add(level + 1);
            }

            if(node.right!= null) {
                deque.add(node.right);
                levelValueDeque.add(level + 1);
            }
        }

        levelValueMap.forEach((k,v) -> System.out.println("k:" + k + " v.data:" + v.data));
    }

    private TreeNode init() {
        this.root = new TreeNode(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node7 = new TreeNode<>(4);

        root.left = node2;
        root.right = node3;

        node2.right = node5;

        node3.right = node7;

        System.out.println("root.data:" + root.data);
        return root;
    }
}
