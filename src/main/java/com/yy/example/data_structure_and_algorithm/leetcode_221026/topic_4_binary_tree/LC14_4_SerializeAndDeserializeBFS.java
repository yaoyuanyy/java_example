package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_4_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xomr73/
 */
public class LC14_4_SerializeAndDeserializeBFS {

    /**
     * 使用 BFS
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485871&idx=1&sn=bcb24ea8927995b585629a8b9caeed01&chksm=9bd7f7a7aca07eb1b4c330382a4e0b916ef5a82ca48db28908ab16563e28a376b5ca6805bec2&mpshare=1&scene=23&srcid=1122sHv6g9QBbLJvLrGhEZng
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuffer s = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                s.append("#").append(",");
            } else {
                s.append(treeNode.val).append(",");
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
        return s.substring(0, s.length() - 1);
    }

    public TreeNode deserialize(String data) {
        return null;
    }

    public static void main(String[] args) {
        /**
         *        3
         *      /   \
         *     9    20
         *   /      / \
         *  91     21 22
         *
         */
        TreeNode treeNode20 = new TreeNode(20);
        treeNode20.left = new TreeNode(21);
        treeNode20.right = new TreeNode(22);

        TreeNode node9 = new TreeNode(9);
        node9.left = new TreeNode(91);

        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = treeNode20;

        String str = new LC14_4_SerializeAndDeserializeBFS().serialize(root);
        System.out.println(str);

        TreeNode treeNode = new LC14_4_SerializeAndDeserializeBFS().deserialize(str);
        System.out.println(treeNode);
    }
}
