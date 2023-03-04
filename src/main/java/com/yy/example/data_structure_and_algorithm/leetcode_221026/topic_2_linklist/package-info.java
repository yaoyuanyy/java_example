/**
 * Description: 数据结构 - 链表
 * <pre>
 *  refer to
 *  1. https://leetcode.cn/leetbook/read/linked-list/x6ybqh/ 链表专题
 *  2. https://leetcode.cn/tag/linked-list/problemset/       链表题库
 *
 *  思路：
 *  https://labuladong.github.io/algo/1/2/                   链表部分
 *  https://labuladong.github.io/algo/2/19/18/               链表题技巧
 *
 * 双指针题：
 *  链表中的双指针
 *  环形链表
 *  环形链表 II
 *  相交链表
 *  删除链表的倒数第N个节点
 *
 * 经典题：
 *  反转链表：迭代，递归，栈，头部虚节点 + 新对象
 *  移除链表元素：头部虚节点 + 迭代，递归，头部虚节点 + 新对象
 *  奇偶链表：双指针
 *  回文链表：双指针
 *
 * 链表中常用的技巧：
 *  使用双指针技巧（快指针慢指针技巧）；使用双指针的同时，两指针产生一定的逻辑联系
 *  头部虚节点
 *  递归：链表的递归是通向二叉树递归的梯子
 *  关键一点：while 中条件使用技巧，注意：s.next 和 s.next.next的技巧使用
 *  ＊ 符号表示重要等级高
 *
 *  递归：＊＊
 *  递归的基本思想是某个函数直接或者间接地调用自身，这样就把原问题的求解转换为许多性质相同但是规模更小的子问题。
 *  递归代码的精髓在于调用自己去解决规模更小的子问题，直到到达结束条件；
 *  递归算法，最重要的就是明确递归函数的定义。不要跳进递归（你的脑袋能压几个栈呀？），而是要根据刚才的函数定义，来弄清楚这段代码会产生什么结果。
 *  所以，递归的一个技巧：不要跳进递归，而是利用明确的定义来实现算法逻辑。
 *  https://mirrors.gitcode.host/labuladong/fucking-algorithm/think_like_computer/RecursionInDetail.html
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:59 AM
 */
package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_2_linklist;