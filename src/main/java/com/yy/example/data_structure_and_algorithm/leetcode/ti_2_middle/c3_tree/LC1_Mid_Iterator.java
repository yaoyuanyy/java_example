package com.yy.example.data_structure_and_algorithm.leetcode.ti_2_middle.c3_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 二叉树的中序遍历
 * <pre>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xv7pir/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 6/20/22 at 10:56 AM
 */
public class LC1_Mid_Iterator {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {

        if(root == null) {
            return;
        }
        // 前序遍历
        inorderTraversal(root.left, res);
        // 中序遍历
        res.add(root.val);
        inorderTraversal(root.right, res);
        // 后续遍历
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);

        TreeNode r2 = new TreeNode(4);
        l1.right = r2;

        TreeNode root = new TreeNode(1);
        root.left = l1;
        root.right = r1;

        LC1_Mid_Iterator mid_iterator = new LC1_Mid_Iterator();
        List<Integer> res = mid_iterator.inorderTraversal(root);

        res.forEach(o -> System.out.print(o + " "));
    }
}
