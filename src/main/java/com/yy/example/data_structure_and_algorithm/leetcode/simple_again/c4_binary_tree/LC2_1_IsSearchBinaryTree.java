package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c4_binary_tree;

import java.util.Stack;

/**
 * Description: 验证二叉搜索树
 * <pre>
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 * https://www.bilibili.com/video/BV13g41157hK?p=7 时间：00:03:00
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-10 at 08:20
 */
public class LC2_1_IsSearchBinaryTree {



    /**
     * 使用二叉树题目递归套路
     * https://www.bilibili.com/video/BV13g41157hK?p=7 时间：00:46:40
     * 搜索二叉树条件
     * 1. 左子树是搜索二叉树
     * 2. 左子树是搜索二叉树
     * 3. 左max < 父min && 右min > 父max
     *
     * 为满足以上的条件：每个节点要返回的数据：是否为搜索二叉树、max、min
     *
     * @param root
     * @return
     */
    public boolean isBST0(TreeNode root) {
        if(null == root) {
            return true;
        }
        return process(root).isSearch;
    }

    public static class ResultData {
        private boolean isSearch;
        private int max;
        private int min;
        private ResultData(boolean isSearch, int max, int min) {
            this.isSearch = isSearch;
            this.max = max;
            this.min = min;
        }
    }

    private ResultData process(TreeNode root) {
        if(null == root) {
            return null;
        }
        ResultData leftData = process(root.left);
        ResultData rightData = process(root.right);

        boolean isSearch = true;
        if(null != leftData && (!leftData.isSearch || leftData.max >= root.val)) {
            isSearch = false;
        }
        if(null != rightData && (!rightData.isSearch || rightData.min <= root.val)) {
            isSearch = false;
        }

        int min = root.val;
        int max = root.val;
        if(null != leftData) {
            min = Math.min(leftData.min, min);
            max = Math.max(leftData.max, max);
        }
        if(null != rightData) {
            min = Math.min(rightData.min, min);
            max = Math.max(rightData.max, max);
        }

        return new ResultData(isSearch, max, min);
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode treeNode, int minValue, int maxValue) {
        if(null == treeNode) {
            return true;
        }

        if(treeNode.val > maxValue || treeNode.val < minValue) {
            return false;
        }

        return isValidBST(treeNode.left, minValue, treeNode.val) && isValidBST(treeNode.right, treeNode.val, maxValue);
    }

    TreeNode pre;
    /**
     * 中序遍历-递归
     *
     * 对于二叉查找树来说，中序遍历的结果正好的从小到大的数值。所以只要判断前面的数大于等于后面的数，就不是二叉查找树
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if(null == root) {
            return true;
        }

        if(!isValidBST2(root.left)) {
            return false;
        }

        if(pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;

        if(!isValidBST2(root.right)) {
            return false;
        }
        return true;
    }

    int preValue = Integer.MIN_VALUE;

    /**
     * 中序遍历-非递归
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        if(null == root) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                if(preValue > root.val) {
                    return false;
                }
                preValue = root.val;
                root = root.right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        LC2_1_IsSearchBinaryTree searchErChaTree = new LC2_1_IsSearchBinaryTree();

        /**
         *     10
         *    / \
         *   3  15
         *     /  \
         *    12   19
         *   /  \
         *  2   14
         */
        TreeNode treeNode12 = new TreeNode(12);
        treeNode12.left = new TreeNode(2);
        treeNode12.right = new TreeNode(14);

        TreeNode treeNode15 = new TreeNode(15);
        treeNode15.left = treeNode12;
        treeNode15.right = new TreeNode(19);

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.right = treeNode15;

        boolean res = searchErChaTree.isBST0(root);
        System.out.println(res);
    }
}
