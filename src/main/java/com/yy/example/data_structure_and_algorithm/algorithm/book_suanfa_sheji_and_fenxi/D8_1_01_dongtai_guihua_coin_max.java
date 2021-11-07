package com.yy.example.data_structure_and_algorithm.algorithm.book_suanfa_sheji_and_fenxi;

/**
 * Description: 动态规划 - 币值最大化问题 Page221
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-09-13 at 21:35
 */
public class D8_1_01_dongtai_guihua_coin_max {

    public static void main(String[] args) {

        int[] array = new int[]{5, 1, 2, 10, 6, 2};

        // int value = getMaxValue(array);
        int value = getMaxValue_right(array);

        System.out.println("value:" + value);
    }

    /**
     * 错误的思路
     *
     * @param array
     * @return
     */
    private static int getMaxValue_error(int[] array) {
        if(array == null) {
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        if(array.length == 2){
            return Math.max(array[0], array[1]);
        }

        int max = 0;
        for (int i = 2; i < array.length; i++) {
            max = max + Math.max(array[i] + array[i -2], array[i- 1]);
            System.out.println("i:" + i +" max:" + max);
        }

        System.out.println("max:" + max);

        return max;
    }


    /**
     * 参考：https://www.codeleading.com/article/77363537574/
     * @param c
     * @return
     */
    private static int getMaxValue_right(int[] c) {
        int[] F = new int[c.length];

        F[0] = 0;
        F[1] = c[0];
        for (int i = 2; i < c.length; i++) {
            F[i] = Math.max(c[i] + F[i - 2], F[i -1]);
            System.out.println("i:" + i + " F[i]:" + F[i]);
        }
        return F[c.length - 1];
    }

}
