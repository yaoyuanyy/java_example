package com.yy.example.bianchengzhuji.book_x_x_x;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <pre>
 *          ——
 *         |  |
 *          ——
 *         |  |
 *          ——
 * </pre>
 *
 * <img src="https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/f45b308777ad4712a8af9aef4a052e37~tplv-k3u1fbpfcp-watermark.image" height="400" width="800"/>
 * <pre>
 *   [S.C.Johnson]七段显示设备实现了十进制数字 0 - 9。
 *   编写一个使用 5 个七段显示数字来显示 16 位正整数的程序。
 *   输出为一个 5 个字节的数组，当且仅当数字 j 中的第 i 段点亮时，字节 j 中的位 i 置 1
 *
 *   16位正整数：2¹⁶ = 2⁴*2⁴*2⁴*2⁴ = 16*16*16*16 = 256*256 < 300*300=90000；5个七段显示数字最大可表示99999。
 *   所有5个七段显示数字足以显示16位正整数了。
 *
 *   输入：456
 *   输出                  ——           ——
 *         |  |           |            |
 *          ——             ——           ——
 *            |              |         |  |
 *                         ——           ——
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-04-25 at 10:34
 */
public class Test_3_7_8 {

    private static final Map<Integer, byte[]> map = new HashMap<>();

    public static void main(String[] args) {
        //尝试凑出8的形状
        init();
        int[] array = getArray(6789);
        getOut(array);
    }

    private static void getOut(int[] array) {
        for (int value : array) {
            byte[] showSegments = map.get(value);
            showSegment(showSegments);
            System.out.println("\t\n");
        }
    }

    private static void showSegment(byte[] showSegments) {
        if (showSegments[2] == 1) {
            System.out.println(" - ");
        }
        if (showSegments[3] == 1) {
            System.out.print("|");
        } else {
            System.out.print(" ");
        }

        if (showSegments[4] == 1) {
            System.out.print(" |");
        }
        System.out.println("");
        if (showSegments[1] == 1) {
            System.out.println(" - ");
        }

        if (showSegments[5] == 1) {
            System.out.print("|");
        } else {
            System.out.print(" ");
        }

        if (showSegments[6] == 1) {
            System.out.print(" |");
        }
        System.out.println("");
        if (showSegments[0] == 1) {
            System.out.println(" - ");
        }
    }

    /**
     * @param num
     * @return 得到int正整数各 位上的数字形成的数组
     */
    private static int[] getArray(int num) {
        System.out.println("原始值：" + JSON.toJSONString(getArray(num)));
        
        if (num > 99999) {
            throw new RuntimeException("入参不合法 num:" + num);
        }
        if (num < 10) {
            return new int[]{num};
        }

        int length = getLengthOf(num);
        int[] array = new int[length];
        for (int i = 1; i <= length; i++) {
            int valueOfIndex = num / (int) Math.pow(10, (length - i));
            array[i - 1] = valueOfIndex;
            num = num - ((int) Math.pow(10, (length - i))) * valueOfIndex;
        }

        return array;
    }

    private static int getLengthOf(int num) {
        return String.valueOf(num).length();
    }

    private static void init() {
        map.put(0, new byte[]{1, 0, 1, 1, 1, 1, 1});
        // {3,5}
        map.put(1, new byte[]{0, 0, 0, 1, 0, 1, 0});
        // {0,1,2,4,5})
        map.put(2, new byte[]{1, 1, 1, 0, 1, 1, 0});
        // {0,1,2,4,6})
        map.put(3, new byte[]{1, 1, 1, 0, 1, 1, 0});
        // {1,3,4,6})
        map.put(4, new byte[]{0, 1, 0, 1, 1, 0, 1});
        // {0,1,2,3,6})
        map.put(5, new byte[]{1, 1, 1, 1, 0, 0, 1});
        // {0,1,2,3,5,6})
        map.put(6, new byte[]{1, 1, 1, 1, 0, 1, 1});
        // {2,4,6}
        map.put(7, new byte[]{0, 0, 1, 0, 1, 0, 1});
        // {0,1,2,3,4,5,6}
        map.put(8, new byte[]{1, 1, 1, 1, 1, 1, 1});
        // {0,1,2,3,4,6}
        map.put(9, new byte[]{1, 1, 1, 1, 1, 0, 1});
    }
}
