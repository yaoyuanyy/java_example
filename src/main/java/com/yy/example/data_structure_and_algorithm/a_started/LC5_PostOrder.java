package com.yy.example.data_structure_and_algorithm.a_started;

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
public class LC5_PostOrder {

    /**
     * 前序，中序，后序 递归遍历方法模板
     * 进一步思考：
     * 为什么这样就是答案了呢，能提取出自己的理解吗
     * @param root
     * @return
     */
    public void order0(TreeNode root) {
        // 逻辑在这里，就是根前序遍历
        order0(root.left);
        // 逻辑在这里，就是根中序遍历
        order0(root.right);
        // 逻辑在这里，就是根后序遍历
    }

    List<Integer> res = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorder1(TreeNode root) {
        // 终止条件
        if(root == null) {
            return res;
        }
        // 递推关系：问题与子问题的关系
        postorder1(root.left);   // 先做左子节点的事，再做右子节点的事，再做自己的事
        postorder1(root.right);  // 先做左子节点的事，再做右子节点的事，再做自己的事
        // 业务逻辑
        res.add(root.val);       // 先做左子节点的事，再做右子节点的事，再做自己的事
        System.out.print(root.val + " ");

        return res;
    }

    /**
     * 迭代：
     * 思路：对比下根前序遍历和根后续遍历：根前后和前后根，如果先将根前后转为根后前，再整体调转，就是前后根了
     * @param root
     * @return
     */
    public List<Integer> postorder2(TreeNode root) {
        if(null == root) {
            return null;
        }
        // 两个栈存的数据是相反的，从栈1出来的时候进入栈2，这样栈2出来的时候正好与栈1相反
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> resStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 栈1出来进入栈2
            TreeNode node = stack.pop();
            resStack.push(node.val);
            // 根前序遍历是先放入右子树，再左子树；这里是先左子树，再右子树
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        while (!resStack.isEmpty()) {
            System.out.print(resStack.pop()+ " ");
        }

        // 91 92 9 21 22 20 3
        return null;
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

        List<Integer> res = new LC5_PostOrder().postorder1(root);
        System.out.println();
        List<Integer> res2 = new LC5_PostOrder().postorder2(root);
    }
}
