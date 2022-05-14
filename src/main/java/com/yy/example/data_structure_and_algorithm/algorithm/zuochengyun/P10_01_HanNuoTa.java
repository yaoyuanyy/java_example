package com.yy.example.data_structure_and_algorithm.algorithm.zuochengyun;

/**
 * Description: 暴力递归 - 汉诺塔的故事
 * <pre>
 * 问题描述
 * 有 A,B,C 三根柱子，A 上面有 n 个盘子，我们想把 A 上面的盘子移动到 C 上，但是要满足以下三个条件：
 *
 * 每次只能移动一个盘子;
 * 盘子只能从柱子顶端滑出移到下一根柱子;
 * 盘子只能叠在比它大的盘子上。
 *
 * 代码：https://www.notion.so/f0dcf21dc1f44761a11a7fda4873be58#cd7ccea209484f588c3e6cc86eb68655
 *
 * 打印移动的轨迹：
 * https://www.bilibili.com/video/BV13g41157hK?p=10 00:50:00
 *
 * 从 A 移动到 C：
 * https://leetcode-cn.com/problems/hanota-lcci/solution/tu-jie-yi-nuo-ta-de-gu-shi-ju-shuo-dang-64ge-pan-z/
 *
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/4/22 at 12:41 PM
 */
public class P10_01_HanNuoTa {

    public void move(int n){
        if(n < 1) {
            return;
        }
        this.move0(n, "左", "右", "中");
    }

    private void move0(int i, String start, String end, String other) {
        if(i == 1) {
            System.out.println("Move 1 from " + start + " to " + end);
        }else {
            move0(i - 1, start,  other, end);
            System.out.println("Move " + i + " from " + start + " to " + end);
            move0(i - 1, other, end, start);
        }
    }

    public static void main(String[] args) {
        P10_01_HanNuoTa hanNuoTa = new P10_01_HanNuoTa();
        System.out.println("当是两层时的轨迹：");
        hanNuoTa.move(2);

        System.out.println("当是三层时的轨迹：");
        hanNuoTa.move(3);
    }
}
