package com.yy.example.data_structure_and_algorithm.leetcode_230102_important;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 二叉树的前序遍历 ＊＊
 *
 * <pre>
 * 给你二叉树的根节点 root ，返回它节点值的前序遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xeywh5/
 *
 * </pre>
 */
public class LC6_PreOrder {

    /**
     * 前序遍历，中序遍历，后续遍历模板
     *
     * @param root
     * @return
     */
    public void preorder0(TreeNode root) {
        // 前序遍历
        preorder0(root.left);

        // 中序遍历

        preorder0(root.right);

        // 后续遍历
    }

    List<Integer> res = new ArrayList<>();
    /**
     * 递归
     */
    public List<Integer> preorder1(TreeNode root) {
        if(root == null) {
            return null;
        }
        res.add(root.val);
        System.out.print(root.val + " ");
        preorder1(root.left);
        preorder1(root.right);
        return res;
    }

    /**
     * 迭代：递归的方式使用了程序内在的栈；迭代方式自己定义栈
     *
     * @param root
     * @return
     */
    public List<Integer> preorder2(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        /**
         *        3
         *      /   \
         *     29    20
         *   / \    / \
         *  91 92  21 22
         */
        TreeNode treeNode20 = new TreeNode(20);
        treeNode20.left = new TreeNode(21);
        treeNode20.right = new TreeNode(22);

        TreeNode node9 = new TreeNode(29);
        node9.left = new TreeNode(91);
        node9.right = new TreeNode(92);

        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = treeNode20;

        List<Integer> res = new LC6_PreOrder().preorder1(root);
        System.out.println();
        List<Integer> res2 = new LC6_PreOrder().preorder2(root);
        // res.forEach(i -> System.out.println(i));
    }
}
