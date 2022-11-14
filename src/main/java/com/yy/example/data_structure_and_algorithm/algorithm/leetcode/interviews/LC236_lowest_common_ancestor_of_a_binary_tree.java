package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.interviews;

import com.yy.example.data_structure_and_algorithm.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 236. 二叉树的最近公共祖先
 * <pre>
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * <img src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png">
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * date: 2021-0902 - kuaishou
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-08 at 09:40
 */
public class LC236_lowest_common_ancestor_of_a_binary_tree {

    TreeNode<Integer> root;

    public static void main(String[] args) {
        LC236_lowest_common_ancestor_of_a_binary_tree obj = new LC236_lowest_common_ancestor_of_a_binary_tree();
        obj.init();
        obj.getLowestCommonAncestor();
    }

    private void getLowestCommonAncestor() {

    }

    // 非递归使用
    Map<Integer, TreeNode<Integer>> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    /**
     * 非递归
     *
     * @param root
     */
    public void dfs(TreeNode<Integer> root) {
        if (root.left != null) {
            parent.put(root.left.data, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.data, root);
            dfs(root.right);
        }
    }

    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        dfs(root);
        while (p != null) {
            visited.add(p.data);
            p = parent.get(p.data);
        }
        while (q != null) {
            if (visited.contains(q.data)) {
                return q;
            }
            q = parent.get(q.data);
        }
        return null;
    }

    // ---------------------------------------------------------------------------------

    /**
     * 递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor2(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor2(root.right, p, q);
            if (lNode != null && rNode != null)
                return root;
            else if (lNode == null) {//两个都在右子树
                return rNode;
            } else { //两个都在左子树里面
                return lNode;
            }
        }
        return null;
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
