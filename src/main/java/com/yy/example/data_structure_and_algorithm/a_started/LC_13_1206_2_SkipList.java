package com.yy.example.data_structure_and_algorithm.a_started;
/**
 * Description: 跳表
 * <pre>
 *  跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 *  https://leetcode.cn/problems/design-skiplist/solution/javashou-xie-shi-xian-tiao-biao-by-feng-omdm0/
 * </pre>
 * 跳表之数据结构定义
 * 跳表的节点数据值是有顺序的
 * 跳表是在链表的基础上跳，链表的next指向一个节点next，跳表的next指向多个节点nexts
 *
 * 重点：插入一个节点时，节点在第几层？执行插入操作时计算随机数的过程，是一个很关键的过程，它对skiplist的统计特性有着很重要的影响。
 * 确认在哪层的算法是随机产生层数的算法，具体为：
 *   如果一个节点有第i层(i>=1)指针（即节点已经在第1层到第i层链表中），那么它有第(i+1)层指针的概率为p。
 *   int randomLevel() {
 *     int level = 1;
 *     while (Math.random()<p && level<MaxLevel) {
 *         level ++ ;
 *     }
 *     return level;
 *   }
 *   在Redis的skiplist实现中，这两个参数的取值为：
 *   p = 1/4
 *   MaxLevel = 32
 *
 *  核心逻辑：从上帝视角向下逐层看，每一层从左到右的比较
 *     上帝视角： for (int i = curLevel-1; i >= 0; i--) {}
 *     从左到右： while (node.next[levelIndex] != null && node.next[levelIndex].value > value) {
 *                  return node.next[levelIndex];
 *              }
 * Created by yaoliang on 2023/2/9 at 09:44
 */
public class LC_13_1206_2_SkipList {

    int MAX_LEVEL = 32;
    double P = 0.25;
    // 跳表的头节点，不是真实数据节点
    // head 为啥 nexts 长度是MAX_LEVEL
    Node head = new Node(null, MAX_LEVEL);
    // 当前跳表的实际层数
    int curLevel = 1;

    class Node{
        Integer value; // 节点值
        Node[] next; // 节点在不同层的下一个节点
        public Node(Integer value,int size) { // 用size表示当前节点在跳表中索引几层
            this.value = value;
            this.next = new Node[size];
        }
    }

    public LC_13_1206_2_SkipList() {
    }

    /**
     * 添加一个节点时，首先要确定这个节点的level
     * @param num
     */
    public void add(int num) {
        int newLevel = randomLevel();
        System.out.println("新的层级：" + newLevel + " num:" + num);
        Node newNode = new Node(num, newLevel);

        Node curNode = head;
        if(newLevel > curLevel) {
            // 将那些新层的head.next[x] 赋值新节点
            for (int i = curLevel; i < newLevel; i++) {
                head.next[i] = newNode;
            }
        }
        // 从curLevel 开始逐层往下遍历，在每层找到它的位置，赋值
        // curLevel从1开始，数组下标从0开始，所以，要curLevel - 1
        for (int level = curLevel-1; level >= 0; level--) {
            // 找到本层小于等于num 的最大节点，即新节点是这个节点的下一个节点
            curNode = findClosest(curNode, level, num);
            // 新节点的层数高于当前操作层，意味着需要在本次加入新节点
            if(level < newLevel) {
                if(curNode.next[level] == null) {
                    curNode.next[level] = newNode;
                }else {
                    Node tmp = curNode.next[level];
                    curNode.next[level] = newNode;
                    newNode.next[level] = tmp;
                }
            }
        }

        // 跳表的层数更新为新层数
        if(curLevel < newLevel) {
            curLevel = newLevel;
        }
    }

    public boolean search(int target) {
        Node searchNode = head;
        for (int level = curLevel - 1; level >= 0; level--) {
            searchNode = findClosest(searchNode, level, target);
            if(searchNode.next[level] != null && searchNode.next[level].value == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
     */
    public boolean erase(int num) {
        boolean removeOk = false;
        Node searchNode = head;
        for (int level = curLevel - 1; level >= 0; level--) {
            searchNode = findClosest(searchNode, level, num);
            if(searchNode.next[level] != null && searchNode.next[level].value == num) {
                searchNode.next[level] = searchNode.next[level].next[level];
                removeOk = true;
            }
        }
        return removeOk;
    }

    /**
     * 核心逻辑：找出level 层小于等于value 的最近的节点
     * @param node
     * @param levelIndex
     * @param value
     * @return
     */
    private Node findClosest(Node node,int levelIndex,int value){
        // 找到value 小于 node.next.value的前一个节点，那么value 是大于 node.value 的，返回这个node
        while (node.next[levelIndex] != null && value > node.next[levelIndex].value) {
            node = node.next[levelIndex];
        }
        return node;
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        LC_13_1206_2_SkipList skiplist = new LC_13_1206_2_SkipList();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));   // 返回 false
        skiplist.add(4);
        System.out.println(skiplist.search(1));   // 返回 true
        System.out.println(skiplist.erase(0));    // 返回 false，0 不在跳表中
        System.out.println(skiplist.erase(1));    // 返回 true
        System.out.println(skiplist.search(1));   // 返回 false，1 已被擦除

    }
}
