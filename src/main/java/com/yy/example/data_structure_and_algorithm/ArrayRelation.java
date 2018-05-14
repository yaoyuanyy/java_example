package com.yy.example.data_structure_and_algorithm;

import com.alibaba.fastjson.JSON;

/**
 * Description:
 * <p></p>
 * <pre>
 *     手写代码找出数组中的最长递增序列？（动态规划)
 * </pre>
 * NB.
 * Created by skyler on 2018/3/20 at 上午7:38
 */
public class ArrayRelation {
    public static void main(String[] args) {
        int[] a = {1,2,3,1,4,4,2,3,5,6,3};
        //int[] a = {1,2,3,4};

        ArrayRelation test = new ArrayRelation();
        int[] target = test.getLongMaxArray(a);
        System.out.println(JSON.toJSONString(target));

        for(int i = target[1]+1; i<=target[2];i++){
            System.out.println(" "+a[i]);
        }
    }

    int endIdx;
    int startIdx;
    int[] target = new int[3];

    public int[] getLongMaxArray(int[] a){
        endIdx = a.length;

        for(int i=a.length-1;i>0;i--){
            if(a[i-1]> a[i]) {
                startIdx = i-1;
                if(target[0] - (endIdx - startIdx) < 0){
                    target[0] = endIdx - startIdx;
                    target[1] = startIdx;
                    target[2] = endIdx;
                }
                endIdx = startIdx;
            }
        }
        if(target[0] == 0){
            target[0] = a.length;
            target[1] = a[0];
            target[2] = a[a.length-1];
        }
        return target;
    }
}
