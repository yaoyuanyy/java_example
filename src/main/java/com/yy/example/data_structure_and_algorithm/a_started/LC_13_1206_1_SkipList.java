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
 * Created by yaoliang on 2023/2/9 at 09:44
 */
public class LC_13_1206_1_SkipList {

    int MAX_LEVEL = 32;
    double P = 0.25;
    // 跳表的头节点，不是真实数据节点
    // head 为啥 nexts 长度是MAX_LEVEL
    Node head = new Node(null, MAX_LEVEL);
    // 当前跳表的实际层数
    int level = 0;

    class Node{
        Integer value; // 节点值
        Node[] next; // 节点在不同层的下一个节点

        public Node(Integer value,int size) { // 用size表示当前节点在跳表中索引几层
            this.value = value;
            this.next = new Node[size];
        }
    }

    public LC_13_1206_1_SkipList() {

    }

    public void add(int num) {

    }

    public boolean search(int target) {
        return true;
    }

    /**
     * 删除
     * @param num
     * @return
     */
    public boolean erase(int num) {
        return true;
    }
}
