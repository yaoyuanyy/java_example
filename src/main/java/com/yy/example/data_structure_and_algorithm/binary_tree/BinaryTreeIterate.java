package com.yy.example.data_structure_and_algorithm.binary_tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 二叉树遍历方法汇集
 * <pre>
 *  eg: 前序遍历，中序遍历，后序遍历，广度优先搜索，深度优先搜索
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-08 at 11:14
 */
public class BinaryTreeIterate {

    /**
     * 广度优先搜索
     */
    public void iterByLayer(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.remove();
            System.out.println(node.data + " ");
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
    }

    /**
     * 深度优先搜索
     */
    public void iterByDepth(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            System.out.println(node.data + " ");
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
    }


    /**
     * 原始数据：a  b  c  d  e  f  g  h  i
     * <pre>
     *             a
     *        b          c
     *    d      e   f       g
     * h     i
     *
     * 前序遍历 先输出父节点，再输出左子树，最后输出右子树
     *
     * result: a  b  d  h  i  e  c  f  g
     * </pre>
     */
    public void iterByQianXu(TreeNode root) {
        if(null == root) {
            return;
        }
        System.out.println(root.data);
        iterByQianXu(root.left);
        iterByQianXu(root.right);
    }

    /**
     * 原始数据：a  b  c  d  e  f  g  h  i
     * <pre>
     *             a
     *        b          c
     *    d      e   f       g
     * h     i
     *
     * 中序遍历 先输出左子树，再输出父节点，最后输出右子树
     *
     * result:
     * </pre>
     */
    public void iterByZhongXu(TreeNode root) {
        if(null == root) {
            return;
        }
        iterByZhongXu(root.left);
        System.out.println(root.data);
        iterByZhongXu(root.right);
    }

    /**
     * 原始数据：a  b  c  d  e  f  g  h  i
     * <pre>
     *             a
     *        b          c
     *    d      e   f       g
     * h     i
     *
     * 后序遍历 先输出左子树，再输出右子树，最后输出父节点
     *
     * result:
     * </pre>
     */
    public void iterByHouXu(TreeNode root) {
        if(null == root) {
            return;
        }
        iterByHouXu(root.left);
        iterByHouXu(root.right);
        System.out.println(root.data);
    }
}
