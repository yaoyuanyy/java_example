package com.yy.example.data_structure_and_algorithm.sort_8big;

/**
 * Description: 二叉树与二叉堆的联系与区别
 * <pre>
 *                 二叉树                                 二叉堆
 *  联系：                                            逻辑上是一颗完全二叉树
 *  表示方式：    链表式表示，指针是链表指针               数组表示，指针为数组下标
 *  节点关系表示：节点间用next指针联系                    节点间用数组下标联系 父：i/2; 左子：2*i; 右子：2*i+1
 *  操作：       C U R D                              sink（下沉）和 swim（上浮）
 *  类型：                                            1.最大堆；2.最小堆
 *  应用：       大多数                                1.堆排序；2.优先队列（优先队列可以用大顶堆或者小顶堆实现）
 *
 *    二叉树               二叉搜索(排序)树              二叉堆(大顶堆)
 * 节点间关系：无序       左子 < root < 右子            左子 < root > 右子
 * https://labuladong.github.io/algo/2/23/65/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 11/24/22 at 12:01 PM
 */
public class P4_02_DiffBinaryHeapAndBinaryTree {

}
