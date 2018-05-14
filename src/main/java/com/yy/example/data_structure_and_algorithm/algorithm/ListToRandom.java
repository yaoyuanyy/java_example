package com.yy.example.data_structure_and_algorithm.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Description: 把一个列表随机打乱。如[1,2,3,4,5]-->[3,2,5,4,1]
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/5/14 at 下午9:05
 */
public class ListToRandom {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List list = Arrays.asList(array);
        ListToRandom arrayToRandom = new ListToRandom();
        arrayToRandom.shuffle1(list);
    }

    /**
     * 打乱列表实现方法
     */
    public <T> void shuffle1(List<T> list) {
        int size = list.size();
        Random random = new Random();

        for(int i = 0; i < size; i++) {
            // 获取随机位置
            int randomPos = random.nextInt(size);
            // 当前元素与随机元素交换
            T temp = list.get(i);
            list.set(i, list.get(randomPos));
            list.set(randomPos, temp);
        }
    }

    // 打乱列表实现方法2
    public <T> void shuffle2(List<T> list) {
        int size = list.size();
        Random random = new Random();

        for(int i = 0; i < size; i++) {
            // 获取随机位置
            int randomPos = random.nextInt(size);

            // 当前元素与随机元素交换
            Collections.swap(list, i, randomPos);
        }
    }

    // 打乱列表实现方法3
    public <T> void shuffle3(List<T> list) {

        Collections.shuffle(list);
    }
}
