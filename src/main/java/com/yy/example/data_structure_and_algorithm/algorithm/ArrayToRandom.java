package com.yy.example.data_structure_and_algorithm.algorithm;

import java.util.Random;

/**
 * Description: 把一个数据随机打乱。如[1,2,3,4,5]-->[3,2,5,4,1]
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/5/14 at 下午9:05
 */
public class ArrayToRandom {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayToRandom arrayToRandom = new ArrayToRandom();
        arrayToRandom.shuffle_method1(array, new Random());
    }

    /**
     * 数组列表实现方法
     */
    public void shuffle_method1(int[] array, Random random) {
        for (int i = array.length; i >= 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
