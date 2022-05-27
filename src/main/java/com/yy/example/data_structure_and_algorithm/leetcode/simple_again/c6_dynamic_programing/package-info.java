/**
 * Description:
 * <pre>
 * 这就是DP（动态规划，dynamic programming）
 *    将一个问题拆成几个子问题，分别求解这些子问题，即可推断出大问题的解。
 *
 * 算法步骤
 *  * step1：刻画一个最优解的结构特征
 *  * step2：递归的定义最优解的值
 *  * step3：计算最优解的值
 *  * step4：利用计算出的信息构造最优解
 *
 * 动态规划详解：
 * https://www.zhihu.com/question/23995189
 * https://m.imooc.com/wiki/algorithmlesson-dynamicprogrammingintro
 *
 * 背包问题汇总：
 *
 * 背包问题分类：
 * 常见的背包类型主要有以下几种：
 * 1、0/1背包问题：每个元素最多选取一次
 * 2、完全背包问题：每个元素可以重复选择
 * 3、组合背包问题：背包中的物品要考虑顺序
 * 4、分组背包问题：不止一个背包，需要遍历每个背包
 *
 * 而每个背包问题要求的也是不同的，按照所求问题分类，又可以分为以下几种：
 * 1、最值问题：要求最大值/最小值
 * 2、存在问题：是否存在…………，满足…………
 * 3、组合问题：求所有满足……的排列组合
 *
 * 因此把背包类型和问题类型结合起来就会出现以下细分的题目类型：
 * 1、0/1背包最值问题
 * 2、0/1背包存在问题
 * 3、0/1背包组合问题
 * 4、完全背包最值问题
 * 5、完全背包存在问题
 * 6、完全背包组合问题
 * 7、分组背包最值问题
 * 8、分组背包存在问题
 * 9、分组背包组合问题
 * 这九类问题我认为几乎可以涵盖力扣上所有的背包问题
 *
 * 分类解题模板
 * 背包问题大体的解题模板是两层循环，分别遍历物品nums和背包容量target，然后写转移方程，
 * 根据背包的分类我们确定物品和容量遍历的先后顺序，根据问题的分类我们确定状态转移方程的写法
 *
 * 首先是背包分类的模板：
 * 1、0/1背包：外循环nums,内循环target,target倒序且target>=nums[i];
 * 2、完全背包：外循环nums,内循环target,target正序且target>=nums[i];
 * 3、组合背包(考虑顺序)：外循环target,内循环nums,target正序且target>=nums[i];
 * 4、分组背包：这个比较特殊，需要三重循环：外循环背包bags,内部两层循环根据题目的要求转化为1,2,3三种背包类型的模板
 *
 * 然后是问题分类的模板：
 * 1、最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1)或dp[i] = max/min(dp[i], dp[i-num]+nums);
 * 2、存在问题(bool)：dp[i]=dp[i]||dp[i-num];
 * 3、组合问题：dp[i]+=dp[i-num];
 *
 * 这样遇到问题将两个模板往上一套大部分问题就可以迎刃而解
 * 下面看一下具体的题目分析：
 * 本题322. 零钱兑换 https://leetcode.cn/problems/coin-change/ {@link com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c6_dynamic_programing.LC5_01_CoinChange_1}
 * 零钱兑换：给定amount,求用任意数量不同面值的零钱换到amount所用的最少数量
 * 完全背包最值问题：外循环coins,内循环amount正序,应用状态方程1
 *
 * https://leetcode.cn/problems/coin-change/solution/yi-pian-wen-zhang-chi-tou-bei-bao-wen-ti-sq9n/
 *
 *
 * 背包相关问题
 * 「力扣」上的 0-1 背包问题：
 *   「力扣」第 416 题：分割等和子集（中等）；
 *   「力扣」第 474 题：一和零（中等）；
 *   「力扣」第 494 题：目标和（中等）；
 *   「力扣」第 879 题：盈利计划（困难）；
 *
 * 「力扣」上的 完全背包问题：
 *   「力扣」第 322 题：零钱兑换（中等）；
 *   「力扣」第 518 题：零钱兑换 II（中等）；
 *   「力扣」第 1449 题：数位成本和为目标值的最大数字（困难）。
 * 链接：https://leetcode.cn/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-03-14 at 08:18
 */
package com.yy.example.data_structure_and_algorithm.leetcode.simple_again.c6_dynamic_programing;