package com.yy.example.bianchengzhuji.book_x_x_x;

import com.alibaba.fastjson.JSON;

/**
 * Description:
 * <pre>
 * 问题：将一个n元一维的向量向左旋转i个位置。例如，当n=8且i=3时，向量abcdefgh旋转为defghabc。
 * 简单的代码使用一个n元的中间向量在b步内完成该工作。你能否仅使用数十个额外字节的存储空间，在正比于n的时间内完成向量的旋转
 *
 * Java实现基于数组的向量旋转的四种算法。包括：
 * 1. 基于数组移动的思路；                method_1 method_2
 * 2. 基于跳跃交换元素的思路；            method_3
 * 3. 基于数组区域交换的思路：AB---> BA； method_4
 * 4. 基于数组逆置的思路。               method_5
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2021-02-17 at 14:19
 */
public class Test_2_1_2 {

    public static void main(String[] args) {
        char[] target = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
//        char[] target = {'a', 'b', 'c', 'd', 'e'};
//        method_1(target, 3);
//        method_2(target,3);
//        method_3(target,3);
        method_5(target, 3);
    }

    /**
     * 方法1：首先将target的前i个元素，复制到一个临时数组，然后将剩下的n-i个元素向前移动i个位置，最后将最初的i个元素从临时数组复制到target数组的余下的位置
     * <p>
     * 前提：没有资源限制
     * <p>
     * 缺点：需要过大的储存空间
     */
    public static void method_1(char[] target, int location) {
        if (target.length < location) {
            return;
        }
        char[] tmp = new char[location];
        for (int i = 0; i < location; i++) {
            tmp[i] = target[i];
        }

        for (int i = location; i < target.length; i++) {
            target[i - location] = target[i];
        }

        int last_index = target.length - location;
        for (int i = last_index; i < target.length; i++) {
            target[i] = tmp[i - last_index];
        }

        System.out.println("tmp[]" + JSON.toJSONString(tmp));
        System.out.println("target[]" + JSON.toJSONString(target));

    }

    /**
     * 方法2：每次向前移动一个位置，一共移动i次
     * <p>
     * 前提：没有资源限制
     * <p>
     * 缺点：需要过多的运行消耗
     *
     * @param target
     * @param location
     */
    public static void method_2(char[] target, int location) {
        for (int i = 0; i < location; i++) {
            repeatMoveByOne(target);
        }
        System.out.println(GsonUtils.outWithPretty(target));
    }

    private static void repeatMoveByOne(char[] target) {
        if (target.length == 0) {
            return;
        }
        if (target.length == 1) {
            return;
        }
        char tmp = target[0];
        for (int i = 0; i < target.length - 1; i++) {
            target[i] = target[i + 1];
        }
        target[target.length - 1] = tmp;
    }

    /**
     * 方法3：编程珠玑第13页最后一个自然段。即基于跳跃交换元素求解向量旋转问题
     * <p>
     * 参考：https://www.cnblogs.com/lovesqcc/archive/2011/04/18/4037847.html
     *
     * @param target
     * @param location
     */
    public static char[] method_3(char[] target, int location) {
        int _location = processParameters(target, location);
        if (_location == 0) {
            return target;
        }
        int arrLen = target.length;
        for (int k = 0; k < gcd(target.length, _location); k++) {
            char temp = target[k];
            int foreIndex = k;
            int afterIndex = k + _location;
            while (afterIndex != k) {
                target[foreIndex] = target[afterIndex];
                foreIndex = (foreIndex + _location) % arrLen;
                afterIndex = (afterIndex + _location) % arrLen;
            }
            target[foreIndex] = temp;
        }
        System.out.println("method_3:" + GsonUtils.out(target));

        return target;
    }

    /**
     * processParameters: 进行参数处理，若不合法，抛出异常；若合法，返回实际需要移位的位数
     */
    private static int processParameters(char[] arr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("参数错误，指定移位位数必须是正整数！");
        }
        int shiftBits = i % arr.length;
        return shiftBits;
    }


    /**
     * gcd: 求给定两数的最大公约数
     */
    private static int gcd(int m, int n) {
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("参数错误，必须均是正整数!");
        }
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }

    /**
     * 方法4：旋转向量target其实就是交换向量ab的两段，得到向量ba。这里a代表target中的前i个元素。假设a比b短，将b分为b1和b2，使得b2具有与a一样的长度。
     * 交换a和b2，也就是ab1b2转换为b2b1a。序列a此时已处于其最终的位置，因此现在的问题就集中到交换b的部分。由于新问题与原来的问题具有相同的形式，我们可以递归地解决之
     *
     * @param target
     * @param location
     */
    public static void method_4(char[] target, int location) {

    }

    /**
     * 方法5：我们把问题看做是把数组ab转换成ba，同时假设我们拥有一个函数可以将数组中特定部分的元素求逆。从ab开始，首先对a求逆，得到a`b，然后对b求逆，得到a`b`，
     * 最后整体求逆，得到(a`b`)`，此时就恰好是ba。此时可想象拿两个手掌做比划
     * reverse(0, i-1)
     * reverse(i, ab.length)
     * reverse(0, ab.length)
     *
     * @param target
     * @param location
     */
    public static void method_5(char[] target, int location) {
        reverse(target, 0, location - 1);
        reverse(target, location, target.length - 1);
        reverse(target, 0, target.length - 1);
        System.out.println(GsonUtils.out(target));
    }

    /**
     * 数组求逆
     *
     * @param target
     * @return
     */
    public static void reverse(char[] target, int front, int after) {
        while (front < after) {
            swap(target, front, after);
            front++;
            after--;
        }
    }

    /**
     * 交互变量
     *
     * @param target
     * @return
     */
    public static void swap(char[] target, int front, int after) {
        char tmp = target[front];
        target[front] = target[after];
        target[after] = tmp;
    }
}
