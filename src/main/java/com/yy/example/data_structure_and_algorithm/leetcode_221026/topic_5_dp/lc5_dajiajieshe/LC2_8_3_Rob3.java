package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_5_dp.lc5_dajiajieshe;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 337. 打家劫舍 III
 * <pre>
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * 示例 1:
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 *
 * https://leetcode.cn/problems/house-robber-iii/
 * </pre>
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_8_3_Rob3 {

    /**
     * 暴力递归
     * 爷爷+孙子 与 爸爸 的最大值
     * https://leetcode.cn/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int val1 = root.val;
        if(root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }

        int val2 = rob(root.left) + rob(root.right);

        return Math.max(val1, val2);
    }

    /**
     * 带备忘录的递归
     *
     * @param root
     * @return
     */
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Integer val = map.get(root);
        if(val != null) {
            return val;
        }
        int val1 = root.val;
        if(root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }

        int val2 = rob(root.left) + rob(root.right);

        int res = Math.max(val1, val2);
        map.put(root, res);

        return res;
    }

    /**
     * 动态规划的树形版本：解法三、终极解法
     * https://leetcode.cn/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
     *
     * @param root
     * @return
     */
    public int rob3(TreeNode root) {
        // todo
        return 0;
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

        int sum = new LC2_8_3_Rob3().rob(root);
        System.out.println(sum);
    }
}
