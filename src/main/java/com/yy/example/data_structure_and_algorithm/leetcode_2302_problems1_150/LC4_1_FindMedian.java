package com.yy.example.data_structure_and_algorithm.leetcode_2302_problems1_150;

/**
 * Description: 295. 数据流的中位数
 * <pre>
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 *
 * https://leetcode.cn/problems/find-median-from-data-stream/
 * https://www.cnblogs.com/labuladong/p/13975869.html
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC4_1_FindMedian {


    public LC4_1_FindMedian() {

    }

    public void addNum(int num) {

    }

    public double findMedian() {
        return 0d;
    }

    public static void main(String[] args) {
        LC4_1_FindMedian findMedian = new LC4_1_FindMedian();
        findMedian.addNum(1);    // arr = [1]
        findMedian.addNum(2);    // arr = [1, 2]
        double res = findMedian.findMedian(); // 返回 1.5 ((1 + 2) / 2)
        System.out.println("res:" + res);
        findMedian.addNum(3);    // arr[1, 2, 3]
        double res2 = findMedian.findMedian();  // return 2.0
        System.out.println("res2:" + res2);
    }
}
