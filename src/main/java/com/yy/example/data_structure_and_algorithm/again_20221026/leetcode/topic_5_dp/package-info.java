/**
 * Description: 动态规划专题
 * <pre>
 *  动态规划解决的问题：一般是最值问题
 *  动态规划核心思想：穷举，我们要做的是如何聪明的穷举。聪明穷举：dp 函数/ dp table
 *  动态规划三要素：重叠子问题，最优子结构，状态转移方程
 *
 *  最优子结构：原问题的解由子问题的最优解构成。要符合「最优子结构」，子问题间必须互相独立
 *  状态转移方程：描述问题结构的数学形式
 *  <img src="https://labuladong.github.io/algo/images/动态规划详解进阶/fib.png"/>
 *
 *  思考状态转移方程的思维框架：明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义。
 *
 *  从顶向下：dp 函数
 *          啥叫「自顶向下」？注意我们刚才画的递归树（或者说图），是从上向下延伸，都是从一个规模较大的原问题比如说 f(20)，
 *          向下逐渐分解规模，直到 f(1) 和 f(2) 这两个 base case，然后逐层返回答案，这就叫「自顶向下」。
 *  从底向上：dp table 更常见的动态规划代码是「自底向上」进行「递推」求解。
 *          啥叫「自底向上」？反过来，我们直接从最底下、最简单、问题规模最小、已知结果的 f(1) 和 f(2)（base case）开始往上推，
 *          直到推到我们想要的答案 f(20)。这就是「递推」的思路，这也是动态规划一般都脱离了递归，而是由循环迭代完成计算的原因。
 *
 *  https://labuladong.github.io/algo/3/25/69/
 *
 *  背包问题思路：
 *  01背包问题的思路和策略是装或不装；完全背包问题的思路策略是装0件，装1件，装n件
 *
 *  背包问题讲解大牛：https://leetcode.cn/problems/perfect-squares/solution/by-flix-sve5/
 *    两种背包问题的状态转移方程对比总结如下：
 *    0-1背包：dp[i][j]=max{ dp[i−1][j],dp[i−1][j−wi]+vi},0<=wi<=j
 *    完全背包：dp[i][j]=max{ dp[i−1][j],dp[i][j−wi]+vi},0<=wi<=j
 *
 *  01背包题目：416. 分割等和子集 474. 一和零 494. 目标和 879. 盈利计划 1049. 最后一块石头的重量 II 1230. 抛掷硬币
 *  完全背包题目：1449. 数位成本和为目标值的最大数字 322. 零钱兑换 518. 零钱兑换 II 279. 完全平方数
 *
 *  题库：https://leetcode.cn/tag/dynamic-programming/problemset/
 *  DP 路径问题：https://leetcode.cn/leetbook/detail/path-problems-in-dynamic-programming/
 *  背包问题题目：https://leetcode.cn/problems/coin-change/solution/by-flix-su7s/
 *
 *  背包问题讲解大牛：
 *  https://leetcode.cn/u/flix/
 *  https://leetcode.cn/u/labuladong
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:59 AM
 */
package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_5_dp;