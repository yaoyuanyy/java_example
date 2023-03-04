package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_4_binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 二叉树的后序遍历
 * <pre>
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xebrb2/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC3_PostOrder {

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
    public List<Integer> postorderTraversal1(TreeNode root) {
        // 终止条件
        if(root == null) {
            return res;
        }
        // 递推关系：问题与子问题的关系
        postorderTraversal1(root.left);   // 先做左子节点的事，再做右子节点的事，再做自己的事
        postorderTraversal1(root.right);  // 先做左子节点的事，再做右子节点的事，再做自己的事
        // 业务逻辑
        res.add(root.val);                // 先做左子节点的事，再做右子节点的事，再做自己的事

        return res;
    }

    /**
     * 迭代：
     * 思路：前序遍历是头左右，后续遍历是左右头，如果我们将前序遍历稍微改动成：头右左，然后在倒过来，就是后续遍历了
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if(null == root) {
            return new ArrayList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> reverseStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            reverseStack.push(stack.pop());
            if(root.left != null) {
                stack.push(root.left);
            }
            if(root.right != null) {
                stack.push(root.right);
            }
        }

        while (!reverseStack.isEmpty()) {
            res.add(reverseStack.pop().val);
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

        List<Integer> res = new LC3_PostOrder().postorderTraversal2(root);
        res.forEach(i -> System.out.println(i));
    }
}
