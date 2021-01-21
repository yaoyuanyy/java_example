package com.yy.example.data_structure_and_algorithm.algorithm;

import java.util.*;

/**
 * Description: 一致性hash算法实现
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020/3/27 at 5:24 下午
 */
public class ConsistenceHash {

    private static TreeMap<Integer, String> nodesMap = new TreeMap<>();

    public String getTargetMachine(String hostIp){
        SortedMap<Integer, String> sortedMap = nodesMap.tailMap(hostIp.hashCode());
        if(sortedMap.size() == 0){
            return nodesMap.firstEntry().getValue();
        }
        Integer key = sortedMap.firstKey();
        return sortedMap.get(key);
    }

    public void add(String hostIp){
        nodesMap.put(hostIp.hashCode(), hostIp);
    }

    public static void main(String[] args) {
        System.out.println(0xff);
        System.out.println(Integer.toHexString(255));
//        ConsistenceHash consistenceHash = new ConsistenceHash();
//        consistenceHash.add("192.168.31.2");
//        consistenceHash.add("192.168.31.20");
//        consistenceHash.add("192.168.31.50");
//        consistenceHash.add("192.168.31.100");
//        consistenceHash.add("192.168.31.200");
//
//        String cacheKey = "1000010";
//        String hostName = consistenceHash.getTargetMachine(cacheKey);
//        System.out.println("cacheKey:" + hostName + " --> hashcode:" + cacheKey.hashCode() + " --> 匹配的机器为" + hostName);
    }
}
