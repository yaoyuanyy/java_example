package com.yy.example.code.simple;

/**
 * Description: 删除排序数组中的重复项
 * <pre>
 * refer to https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-05 at 10:44
 */
public class Test1 {

    public static void main(String[] args) {
        int[] array = {10, 11, 11, 12, 13, 13, 13, 14, 15};
        int fast = 1;
        int slow = 1;
        while (fast < array.length) {
            if(array[fast] != array[fast-1]) {
                array[slow] = array[fast];
                slow++;
            }

            fast++;
        }

        System.out.println("slow:" + slow);
        for (int i = 0; i < slow; i++) {
            System.out.println(array[i]);
        }
    }
}
