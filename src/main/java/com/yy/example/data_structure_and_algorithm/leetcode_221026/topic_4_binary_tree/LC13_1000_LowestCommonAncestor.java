package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_4_binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xopaih/
 */
public class LC13_1000_LowestCommonAncestor {

    /**
     * 使用递归迭代的解题方式
     *
     * ＊＊＊ 通过此题体会后序位置的神奇和妙用
     *
     * https://mp.weixin.qq.com/s/njl6nuid0aalZdH5tuDpqQ
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return lowestCommonAncestor(root, p.val, q.val, "-");
    }

    /**
     *        3
     *      /   \
     *     9    20
     *   / \    / \
     *  91 92  21 22
     *      \
     *      102
     * 假如val1=102 val2=91，那么最近公共祖先即是9
     * @param root
     * @param val1
     * @param val2
     * @return
     */
    private TreeNode lowestCommonAncestor(TreeNode root, int val1, int val2, String s) {
        if(root == null) {
            return null;
        }
        System.out.println(s + root.val);
        s += s;
        if(root.val == val1 || root.val == val2) {
            // 这里只有root.val是102或是91时，才会近来
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, val1, val2, s);
        TreeNode right = lowestCommonAncestor(root.right, val1, val2, s);
//        System.out.println(s + root.val);
//        s += s;
        if(left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    /**
     * 方法二：存储父节点
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> valueOfParent = new HashMap<>();
        List<Integer> values = new ArrayList<>();
        // 形成关联父节点的结构
        traverse(root, valueOfParent);
        // 从 val1 开始，记录访问它父节点的轨迹
        while (p != null) {
            values.add(p.val);
            p = valueOfParent.get(p.val);
        }
        while (q != null) {
            if (values.contains(q.val)) {
                return q;
            }
            q = valueOfParent.get(q.val);
        }
        return null;
    }

    private void traverse(TreeNode root, Map<Integer, TreeNode> valueOfParent) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            valueOfParent.put(root.left.val, root);
            traverse(root.left, valueOfParent);
        }
        if(root.right != null) {
            valueOfParent.put(root.right.val, root);
            traverse(root.right, valueOfParent);
        }
    }

    public static void main(String[] args) {
        /**
         *        3
         *      /   \
         *     9    20
         *   / \    / \
         *  91 92  21 22
         *      \
         *      102
         */
        TreeNode treeNode20 = new TreeNode(20);
        treeNode20.left = new TreeNode(21);
        treeNode20.right = new TreeNode(22);

        TreeNode node9 = new TreeNode(9);
        node9.left = new TreeNode(91);
        TreeNode node92 = new TreeNode(92);
        node92.right = new TreeNode(102);
        node9.right = node92;

        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = treeNode20;

        TreeNode treeNode = new LC13_1000_LowestCommonAncestor().lowestCommonAncestor(root, new TreeNode(91), new TreeNode(102));
        System.out.println(treeNode);
    }
}
