package com.yy.example.data_structure_and_algorithm.leetcode_221026.topic_3_digui;

/**
 * Description: 1+2+3+4+...+n
 * <pre>
 * 累加：1+2+3+4+...+n
 *
 * 递归实现
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC1_NumberNAdd {

    /**
     * 递归
     * 自下向上：先找(递推关系)再计算，即找到底部边界（终止条件），然后开始逐一计算
     *
     * 由下到上-范式
     *  - 寻找递归基本条件(终止条件)，跳出时返回基本情况的结果
     *  - 寻找递归递推关系
     *  - 修改递归函数的参数
     *  - 递归调用并返回中间变量
     *  - 使用递归函数的返回值与当前参数进行计算，并返回最终结果
     *
     *  public 返回值 f(参数) {
     *     if (基本情况条件) return 基本情况的结果;
     *
     *     修改参数；
     *     返回值 = f(参数);
     *
     *     最终结果 = 根据参数与返回值计算
     *     return 最终结果;
     * }
     *
     * 链接：https://leetcode.cn/circle/article/koSrVI/ 作者：GourdErwa
     * @param n
     * @return
     */
    public int sum(int n) {
        // 终止条件（边界）
        if(n==1) return 1;
        // 递推关系
        int res = sum(n-1) + n;
        // 返回值运算，此处无需，直接返回
        return res;
    }

    /**
     * 自上向下：先计算再找(递推关系)，即我们先计算，然后把计算好的结果传递给递归函数进行下一次计算
     *
     * 由上到下-范式
     *  - 寻找递归基本情况，跳出时返回基本情况的结果与中间变量的计算结果
     *  - 计算函数参数，根据函数参数与中间变量重新计算出新的中间变量
     *  - 寻找递归递推关系，传入参数和新的中间变量给递归函数
     *  - 递归调用并返回
     *
     * public 返回值 f(参数，中间变量) {
     *     if (基本情况条件) return 基本情况的结果与中间变量的计算结果;
     *
     *     中间变量 = 根据参数与中间变量重新计算
     *     修改参数；
     *
     *     return f(参数,中间变量);
     * }
     *
     * 链接：https://leetcode.cn/circle/article/koSrVI/ 作者：GourdErwa
     *
     * @param n
     * @return
     */
    public int sum2(int n, int sum) {
        // 终止条件（边界）
        if(n==1) return 1 + sum;
        // 递推关系
        sum += n;
        int res = sum2(n-1, sum);
        // 返回值运算，此处无需，直接返回
        return res;
    }


    public static void main(String[] args) {
        int sum = new LC1_NumberNAdd().sum2(5,0);
        System.out.println(sum);
    }


}
