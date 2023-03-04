package com.yy.example.data_structure_and_algorithm.leetcode_230102_important;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 二叉树的中序遍历
 * <pre>
 * 给定一个二叉树的根节点 root ，返回 它的 中序遍历 。
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
public class LC4_InOrder {

    /**
     * 前序，中序，后序 递归遍历方法模板
     * 进一步思考：
     * 为什么这样就是答案了呢，能提取出自己的理解吗
     * @param root
     * @return
     */
    public void inOrder0(TreeNode root) {
        // 逻辑在这里，就是根前序遍历
        inOrder0(root.left);
        // 逻辑在这里，就是根中序遍历
        inOrder0(root.right);
        // 逻辑在这里，就是根后序遍历
    }

    List<Integer> res = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inOrder1(TreeNode root) {
        // 终止条件
        if(root == null) {
            return res;
        }
        // 递推关系：问题与子问题的关系
        inOrder1(root.left);   // 先做左子节点的事，再做自己的事，再做右子节点的事
        // 业务逻辑
        res.add(root.val);      // 先做左子节点的事，再做自己的事，再做右子节点的事
        System.out.print(root.val + " ");

        inOrder1(root.right);  // 先做左子节点的事，再做自己的事，再做右子节点的事

        return res;
    }

    /**
     * 迭代：使用数据结构栈(stack) 作为存储容器。
     * 需要使左侧节点一直到底
     * @param root
     * @return
     */
    public List<Integer> inOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return null;
        }
        while (!stack.isEmpty() || root != null) {
            // 将左侧子树们放在栈中
            while (root != null) {  //(1)
                stack.push(root);
                root = root.left;
            }
            TreeNode selfNode = stack.pop();
            System.out.print(selfNode.val + " ");

            if(selfNode.right != null) {
                // 将右节点赋值给root，从而使此节点的左子树们放入栈中，即走入(1)代码
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

        List<Integer> res = new LC4_InOrder().inOrder1(root);
        System.out.println();
        List<Integer> res2 = new LC4_InOrder().inOrder2(root);
    }
}
