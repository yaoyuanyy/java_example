package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_4_binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 二叉树的中序遍历
 * <pre>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xecaj6/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_InOrder {

    /**
     * 前序，中序，后序 递归遍历方法模板
     * 进一步思考：
     * 为什么这样就是答案了呢，能提取出自己的理解吗
     * @param root
     * @return
     */
    public void orderTraversal(TreeNode root) {
        // 逻辑在这里，就是根前序遍历
        orderTraversal(root.left);
        // 逻辑在这里，就是根中序遍历
        orderTraversal(root.right);
        // 逻辑在这里，就是根后序遍历
    }

    List<Integer> res = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        // 终止条件
        if(root == null) {
            return res;
        }
        // 递推关系：问题与子问题的关系
        inorderTraversal1(root.left);   // 先做左子节点的事，再做自己的事，再做右子节点的事
        // 业务逻辑
        res.add(root.val);             // 先做左子节点的事，再做自己的事，再做右子节点的事
        inorderTraversal1(root.right); // 先做左子节点的事，再做自己的事，再做右子节点的事

        return res;
    }

    /**
     * 迭代：使用数据结构栈(stack) 作为存储容器。
     * 需要使左侧节点一直到底
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if(null == root) {
            return new ArrayList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            // 一直到左子树底
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 到左子树底了，此时最左子节点在栈顶
            TreeNode selfNode = stack.pop();
            res.add(selfNode.val);
            if(selfNode.right != null) {
                root = selfNode.right;
            }
        }
        // output: 91 9 92 3 21 20 22
        return res;
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

        List<Integer> res = new LC2_InOrder().inorderTraversal2(root);
        res.forEach(i -> System.out.println(i));
    }
}
