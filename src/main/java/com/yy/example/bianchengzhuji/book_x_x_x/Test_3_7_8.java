package com.yy.example.bianchengzhuji.book_x_x_x;

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
        init();
        byte[] values = cal(5);
        System.out.println("values:" + values);
    }

    private static byte[] cal(int n) {
        if(n < 1 || n > 10) {
            return new byte[0];
        }

        return new byte[0];
    }

    private static void init() {
        map.put(0, new byte[]{});
        map.put(1, new byte[]{3,5});
        map.put(2, new byte[]{0,1,2,4,5});
        map.put(3, new byte[]{0,1,2,4,6});
        map.put(4, new byte[]{1,3,4,6});
        map.put(5, new byte[]{0,1,2,3,6});
        map.put(6, new byte[]{0,1,2,3,5,6});
        map.put(7, new byte[]{2,4,6});
        map.put(8, new byte[]{0,1,2,3,4,5,6});
        map.put(9, new byte[]{0,1,2,3,4,6});
    }

}
