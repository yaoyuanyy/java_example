package com.yy.example.jvm.gc.memory;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 *
 * </p>
 * <pre>
 *     堆内存溢出: jvm参数：-Xms5m -Xmx5m -Xmn2m -XX:NewSize=1m
 *     方法区内存溢出: jvm参数：-XX:PermSize=2m -XX:MaxPermSize=2m java8已经去掉了这个配置
 *
 *     refer to:
 *     http://www.imooc.com/article/15379
 * </pre>
 * NB.
 * Created by skyler on 2018/4/24 at 下午10:37
 */
public class MemoryLeak {

    private String[] s = new String[1000];

    public static void main(String[] args) throws InterruptedException {
        System.out.println("args" + JSONObject.toJSONString(args));

        Map<String,Object> m =new HashMap<>();
        int i =0;
        int j=10000;
        while(true){
            for(;i<j;i++){
                // System.out.format("%d %5d\n", i, j);

                MemoryLeak memoryLeak = new MemoryLeak();
                m.put(String.valueOf(i), memoryLeak);
            }
        }
    }
}