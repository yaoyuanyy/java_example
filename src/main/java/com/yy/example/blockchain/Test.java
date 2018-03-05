package com.yy.example.blockchain;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/3/4 at 下午10:45
 */
public class Test {

    public static void main(String[] args) {
        // 产生第一个区块
        Block first = new Block("fisrt block come ","0");

        System.out.println(first.getCurHash());

        // 产生第一个区块
        Block second = new Block("2 block come ",first.getCurHash());

        System.out.println(second.getCurHash());

        List<Block> blocks = new ArrayList<>();
        blocks.add(first);
        blocks.add(second);
        blocks.add(new Block("3 block come ", first.getCurHash()));


        String blockChain = new GsonBuilder().setPrettyPrinting().create().toJson(blocks);
        //String blockChain = JSON.toJSONString(blocks);
        System.out.println(blockChain);

        String hashTarget = new String(new char[5]).replace('\0', '0');
        System.out.println(hashTarget);

    }
}
