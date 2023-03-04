package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_4_binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 二叉树的前序遍历
 * <pre>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xeywh5/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC1_PreOrder {

    /**
     * 前序，中序，后序 递归遍历方法模板
     * 进一步思考：
     * 为什么这样就是答案了呢，能提取出自己的理解吗
     * @param root
     * @return
     */
    public void preorderTraversal0(TreeNode root) {
        // 逻辑在这里，就是根前序遍历
        preorderTraversal0(root.left);
        // 逻辑在这里，就是根中序遍历
        preorderTraversal0(root.right);
        // 逻辑在这里，就是根后序遍历
    }

    List<Integer> res = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        // 终止条件
        if(root == null) {
            return res;
        }
        // 业务逻辑
        res.add(root.val);               // 先做自己的事，再做左子节点的事，再做右子节点的事
        // 递推关系：问题与子问题的关系
        preorderTraversal1(root.left);   // 先做自己的事，再做左子节点的事，再做右子节点的事
        preorderTraversal1(root.right);  // 先做自己的事，再做左子节点的事，再做右子节点的事

        return res;
    }

    /**
     * 迭代：使用数据结构栈(stack) 作为存储容器。
     * 由于是先进后出特性，所以，为保证根前序遍历，右子节点先进栈，左子节点后进栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(null == root) {
            return new ArrayList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if(treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if(treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }

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

        List<Integer> res = new LC1_PreOrder().preorderTraversal1(root);
        res.forEach(i -> System.out.println(i));
    }
}
