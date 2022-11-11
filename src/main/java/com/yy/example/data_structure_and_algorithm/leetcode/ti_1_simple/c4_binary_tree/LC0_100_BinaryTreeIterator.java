package com.yy.example.data_structure_and_algorithm.leetcode.ti_1_simple.c4_binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description:
 * Note: 递归序的概念：左程云
 * <pre>
 *     refer to https://www.nowcoder.com/issue/tutorial?tutorialId=10016&uuid=433f30570fc0428fb41c83ea2c2bf138
 *
 * 这里是 4 道相关题目：
 *   144. 二叉树的前序遍历
 *    94. 二叉树的中序遍历
 *   145. 二叉树的后序遍历
 *   102. 二叉树的层序遍历
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-10 at 17:30
 */
public class LC0_100_BinaryTreeIterator {

    /**
     * 广度优先遍历：辅助数据结构是队列
     * refer to https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
     *
     * @param node
     */
    public void iterator_BFS(TreeNode node) {
        // 1放入队列
        // 2从队列取出
        // 3打印
        // 4左重复 1
        // 5右重复 1
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.val + " ");
            if(null != treeNode.left) {
                queue.add(treeNode.left);
            }
            if(null != treeNode.right) {
                queue.add(treeNode.right);
            }
        }
    }

    /**
     * 前序遍历：头左右 /_
     * 递归
     *
     * @param node
     * @return
     */
    public void iterator_PreOrder_DiGui(TreeNode node) {
        if (null == node) {
            return;
        }
        System.out.print(node.val + " ");
        iterator_PreOrder_DiGui(node.left);
        iterator_PreOrder_DiGui(node.right);
    }

    /**
     * 前序遍历：头左右 /_
     * 非递归 - 借助数据结构：栈
     *
     * @param node
     * @return
     */
    public void iterator_PreOrder_NotDiGui(TreeNode node) {
        if (null == node) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val + " ");
            if(null != treeNode.right) {
                stack.push(treeNode.right);
            }
            if(null != treeNode.left) {
                stack.push(treeNode.left);
            }
        }
    }

    /**
     * 中序遍历：左头右 /\
     * 递归
     *
     * @param node
     * @return
     */
    public void iterator_InOrder_DiGui(TreeNode node) {
        if (null == node) {
            return;
        }
        iterator_InOrder_DiGui(node.left);
        System.out.print(node.val + " ");
        iterator_InOrder_DiGui(node.right);
    }

    /**
     * 中序遍历：左头右 /\
     * 非递归
     * 借助数据结构：栈
     *
     * refer to https://www.nowcoder.com/issue/tutorial?tutorialId=10016&uuid=433f30570fc0428fb41c83ea2c2bf138
     * @param node
     * @return
     */
    public void iterator_InOrder_NotDiGui(TreeNode node) {
        // 左子树一直进栈，直到为null
        // 打印自身
        // 轮到右子树，再按左子树进栈
        if(null != node) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || node != null) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    /**
     * 迭代
     *
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/solution/jian-dan-yi-dong-javac-pythonjs-er-cha-s-w80i/
     */
    public void iterator_InOrder_NotDiGui2(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            // 遍历左子树，一直到 null
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 左子树为null，操作自己
            TreeNode self = stack.pop();
            System.out.print(self.val + " ");

            // 操作其右子树
            cur = self.right;
        }
    }

    /**
     * 后序遍历：左右头 _\
     * 递归
     *
     * @param node
     * @return
     */
    public void iterator_AfterOrder_DiGui(TreeNode node) {
        if (null == node) {
            return;
        }
        iterator_AfterOrder_DiGui(node.left);
        iterator_AfterOrder_DiGui(node.right);
        System.out.print(node.val + " ");
    }

    /**
     * 后序遍历：左右头 _\
     * 非递归
     *
     * 前序遍历是 头左右，后序遍历是左右头。如果将前序遍历改造下，变成 头右左，放入 栈，然后再出栈，就是 左右头了，即后续遍历
     *
     * @param node
     * @return
     */
    public void iterator_AfterOrder_NotDiGui(TreeNode node) {
        Stack<TreeNode> resultStack = new Stack<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val + " ");
            resultStack.push(treeNode);
            if(treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if(treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }

        System.out.println("\n后序遍历：");
        while (!resultStack.isEmpty()) {
            System.out.print(resultStack.pop().val + " ");
        }
    }

    public static void main(String[] args) {
        LC0_100_BinaryTreeIterator binaryTreeIterator = new LC0_100_BinaryTreeIterator();

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

//        System.out.println("\n广度优先遍历:");
//        binaryTreeIterator.iterator_BFS(root);
//
//        System.out.println("\n前序遍历-递归:");
//        binaryTreeIterator.iterator_PreOrder_DiGui(root);
        System.out.println("\n前序遍历-非递归:");
        binaryTreeIterator.iterator_PreOrder_NotDiGui(root);
//
//        System.out.println("\n中序遍历-递归:");
//        binaryTreeIterator.iterator_InOrder_DiGui(root);
//        System.out.println("\n中序遍历-非递归:");
//        binaryTreeIterator.iterator_InOrder_NotDiGui(root);
//        System.out.println("\n中序遍历-非递归2:");
//        binaryTreeIterator.iterator_InOrder_NotDiGui2(root);
//
//        System.out.println("\n后序遍历-递归:");
//        binaryTreeIterator.iterator_AfterOrder_DiGui(root);
//
//        System.out.println("\n后序遍历-非递归:");
//        binaryTreeIterator.iterator_AfterOrder_NotDiGui(root);
    }
}
