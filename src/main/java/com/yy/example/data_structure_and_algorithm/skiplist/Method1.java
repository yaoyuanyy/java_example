package com.yy.example.data_structure_and_algorithm.skiplist;

import lombok.Data;

import java.util.Objects;

/**
 * Description:
 * <pre>
 * 来自 leetCode
 * https://leetcode-cn.com/problems/design-skiplist/solution/javashou-xie-shi-xian-tiao-biao-by-feng-omdm0/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-08 at 08:19
 */
public class Method1 {

    private static int DEFAULT_MAX_LEVEL = 4;
    private static double DEFAULT_P_RATE = 0.25;

    /**
     * 表示整个跳表的实际层数，它从1开始
     */
    private int currentLevel = 1;

    private SkipNode head = null;

    // 辅助数据
    private int step = 0;


    public Method1() {
        this.head = new SkipNode(0, DEFAULT_MAX_LEVEL);
    }

    /**
     * <pre>
     * 我插入一个节点Node，它到底应该是索引到第几层呢？
     *   1 先随机出来一个层数，new要插入的节点，先叫做插入节点newNode；
     *   2 根据跳表实际的总层数从上往下分析，要插入一个节点newNode时，先找到节点在该层的位置：因为是链表，所以需要一个节点node，满足插入插入节点newNode的值刚好不大于node的下一个节点值，当然，如果node的下个节点为空，那么也是满足的。
     *   3 确定插入节点newNode在该层的位置后，先判断下newNode的随机层数是否小于当前跳表的总层数，如果是，则用链表的插入方法将newNode插入即可。
     *   4 如此循环，直到最底层插入newNode完毕。
     *   5 循环完毕后，还需要判断下newNode随机出来的层数是否比跳表的实际层数还要大，如果是，直接将超过实际层数的跳表的头节点指向newNode即可，该跳表的实际层数也就变为newNode的随机层数了。
     * 以上就是插入的算法。
     *
     * Tips 不管是插入、查找还是删除，均是从跳表上层往下层分析，复用上面的findClosest方法(节点在某一层位置的方法)，找到要查询的值 在该层closest的节点。
     * 比如查询，只需要判断findClosest方法(节点在某一层位置的方法)出来的节点值是否等于该查询值即可，是就返回，不是则继续往下层判断。删除方法思想也是一致的。
     *
     * </pre>
     */
    public void add(int value) {
        int randomLevel = randomLevel();
        SkipNode newNode = new SkipNode(value, randomLevel);

        /// 从头节点开始操作.
        // 定义一个节点引用，用于操作
        SkipNode oprNode = head;

        // 1. 先从当前跳表的实际层数开始添加newNode
        for (int i = currentLevel - 1; i >= 0; i--) {
            if (i < randomLevel) {
                // 同一i层查找小于value的最大值的skipNode
                oprNode = findClosestBySameLayer(oprNode, i, value);
                if (Objects.isNull(oprNode.next[i])) {
                    oprNode.next[i] = newNode;
                } else {
                    SkipNode tmp = oprNode.next[i];
                    oprNode.next[i] = newNode;
                    newNode.next[i] = tmp;
                }
            }
        }

        // 2. 再操作大于当前跳表的实际层数开始添加newNode
        if (randomLevel > currentLevel) {
            for (int i = currentLevel; i < randomLevel; i++) {
                head.next[i] = newNode;
            }
            // 设置跳表的新层次
            currentLevel = randomLevel;
        }
    }

    /**
     * 同一level层遍历查找小于value的最大值的skipNode
     * 如 2 -> 4 -> 6 -> 8，当value=7，返回的是为6的skipNode
     *
     * @param skipNode
     * @param levelIndex
     * @param value
     * @return
     */
    public SkipNode findClosestBySameLayer(SkipNode skipNode, int levelIndex, int value) {
        while (skipNode.next[levelIndex] != null && skipNode.next[levelIndex].value < value) {
            skipNode = skipNode.next[levelIndex];
            step++;
        }
        return skipNode;
    }

    /**
     * 随机出来一个层数
     *
     * @return
     */
    public int randomLevel() {
        int level = 1;
        while (Math.random() < DEFAULT_P_RATE && level < DEFAULT_MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public void out() {
        System.out.println("-------------------------");

        SkipNode node = head;
        while (node != null) {
            System.out.print(node.value + "(" + (Objects.isNull(node.next) ? 0 : node.next.length) + ")" + "  ");
            if (node.next != null) {
                node = node.next[0];
            }
        }
        System.out.print("currentLevel:" + currentLevel);
        System.out.println("\n-------------------------");
    }

    private boolean search(int value) {
        SkipNode oprNode = head;

        for (int i = currentLevel - 1; i >= 0; i--) {
            // 同一level层遍历查找小于value的最大值的skipNode
            oprNode = findClosestBySameLayer(oprNode, i, value);
            if (Objects.nonNull(oprNode.next[i]) && oprNode.next[i].value == value) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(int value) {
        boolean result = false;
        SkipNode oprNode = head;

        for (int i = currentLevel - 1; i >= 0; i--) {
            // 同一level层遍历查找小于value的最大值的skipNode
            oprNode = findClosestBySameLayer(oprNode, i, value);
            if (Objects.nonNull(oprNode.next[i]) && oprNode.next[i].value == value) {
                oprNode.next[i] = oprNode.next[i].next[i];
                result = true;
            }
        }

        // 重新计算当前跳表的层级
        for (int level = DEFAULT_MAX_LEVEL - 1; level > 0; level--) {
            if(head.next[level] != null){
                currentLevel = level + 1;
                break;
            }
        }

        return result;
    }

    @Data
    class SkipNode {

        Integer value;
        SkipNode[] next;

        public SkipNode(Integer value, int size) { // 用size表示当前节点在跳表中索引几层
            this.value = value;
            this.next = new SkipNode[size];
        }
    }

    public static void main(String[] args) {
        Method1 method1 = new Method1();
        method1.add(4);
        method1.add(2);
        method1.add(13);
        method1.add(23);
        method1.add(6);
        method1.add(8);
        method1.add(10);
        method1.add(1);

        System.out.println("新增后的结果:");
        method1.out();

        System.out.println("-------------------------");
        boolean find = method1.search(10);
        System.out.println("search 10的结果 find:" + find + " 经过" + method1.step + "步");
        System.out.println("-------------------------");

        boolean result = method1.remove(10);
        System.out.println("remove 10的结果 result:" + result + " 结果:");
        method1.out();

    }

}
