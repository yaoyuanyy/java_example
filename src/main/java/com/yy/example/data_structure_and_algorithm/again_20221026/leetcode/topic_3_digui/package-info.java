/**
 * Description: 递归专项
 * <pre>
 *     递归故事：
 *       从前有座山，山里有座庙，庙里有个老和尚，正在给小和尚讲故事呢！故事是什么呢？“从前有座山，山里有座庙，庙里有个老和尚，正在给小和尚讲故事呢！故事是什么呢？‘从前有座山，山里有座庙，庙里有个老和尚，正在给小和尚讲故事呢！故事是什么呢？……’”
 *     递归：＊＊
 *       递归的基本思想是某个函数直接或者间接地调用自身，这样就把原问题的求解转换为许多性质相同但是规模更小的子问题。
 *       递归代码的精髓在于调用自己去解决规模更小的子问题，直到到达结束条件；
 *       递归算法最重要的就是明确递归函数的定义。不要跳进递归（你的脑袋能压几个栈呀？），而是要根据刚才的函数定义，来弄清楚这段代码会产生什么结果。
 *       所以，递归的一个技巧：不要跳进递归，而是利用明确的定义来实现算法逻辑。
 *       https://mirrors.gitcode.host/labuladong/fucking-algorithm/think_like_computer/RecursionInDetail.html
 *
 *     非常好的讲递归的文章：https://leetcode.cn/circle/article/koSrVI/ 作者：https://leetcode.cn/u/gourderwa/ GourdErwa
 *
 *     PS：[但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复杂度，寻找算法低效的原因都有巨大帮助。](https://labuladong.github.io/algo/3/25/69/)
 *     
 *     递归题：https://leetcode.cn/tag/recursion/problemset/ https://leetcode.cn/problemset/all/?topicSlugs=recursion
 *       21. 合并两个有序链表（多递推公式情况）simple
 *       206. 反转链表                     simple
 *       203. 移除链表元素                  simple
 *       234. 回文链表                     simple
 *       509. 斐波那契数                   simple
 *       231. 2 的幂                      simple
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:59 AM
 */
package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_3_digui;