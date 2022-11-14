package com.yy.example.data_structure_and_algorithm.again_20221026.leetcode.topic_3_digui;

/**
 * Description: 递归乘法
 * <pre>
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。
 * 可以使用加号、减号、位移，但要吝啬一些。
 * 示例 1:
 *  输入：A = 1, B = 10
 *  输出：10
 * 示例 2:
 *  输入：A = 3, B = 4
 *  输出：12
 *
 *
 *
 * 链接：https://leetcode.cn/circle/article/koSrVI/ 作者：GourdErwa
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC2_MultiTwoNumber {

    /**
     * 思路：A * B = A 个 B 相加
     * 自下向上
     * - 递归关系：while A>1 A-- {B += B }
     * - 终止条件：
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply(int A, int B) {
        int sum = 0;
        while (A > 0) {
            sum += B;
            A--;
        }
        return sum;
    }

    /**
     * 思路：A * B = A 个 B 相加
     * 自下向上
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply2(int A, int B) {
        // 终止条件(边界)
        if (A == 1) return B;
        // 递推关系：找到和子问题的关系
        // 传入新参数，得到中间变量
        int res = multiply(A - 1, B) + B;
        // 使用中间变量：与函数参数计算，返回最终结果（这个题无需）
        return res;
    }

    /**
     * 思路：A * B = A 个 B 相加
     * 自上向下
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply3(int A, int B) {
        return doMultiply(A, B, 0);
    }

    public int doMultiply(int A, int B, int sum) {
        // 终止条件(边界) 参数和中间变量计算
        if (A == 1) return B + sum;
        // 当前参数和中间变量计算得到新的中间变量
        sum += B;
        // 递推关系：找到和子问题的关系
        // 传入新参数和新的中间变量
        int res = doMultiply(A - 1, B, sum);
        // 使用中间变量：与函数参数计算，返回最终结果（这个题无需）
        return res;
    }


    public static void main(String[] args) {
        int sum = new LC2_MultiTwoNumber().multiply3(3, 4);
        System.out.println(sum);
    }


}
