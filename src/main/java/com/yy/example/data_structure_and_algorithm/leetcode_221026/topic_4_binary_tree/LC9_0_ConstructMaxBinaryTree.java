package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_4_binary_tree;

/**
 * Description: 给定一个不重复的整数数组 nums。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 *
 * 示例 1：
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 *
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC9_0_ConstructMaxBinaryTree {

    /**
     * 构建二叉树思路：使用分解问题的解题方式
     * 先构建根节点，在构建左子数和右子树
     * 整个树 = root + 整个左子树 + 整个右子树
     *
     * refer to https://labuladong.github.io/algo/2/21/38/
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if(lo > hi) {
            return null;
        }
        // 找到最大值及下标
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        // 构建root
        TreeNode root = new TreeNode(max);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new LC9_0_ConstructMaxBinaryTree().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println(treeNode);
    }
}
