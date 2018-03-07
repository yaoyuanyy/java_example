package com.yy.example.blockchain;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/3/5 at 上午12:12
 */
public class Test2 {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;

//    public static void main(String[] args) {
//        //把区块增加到数组中去
//
//        blockchain.add(new Block("Hi im the first block", "0"));
//        System.out.println("Trying to Mine block 1... ");
//        blockchain.get(0).mineBlock(difficulty);
//
//        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).getCurHash()));
//        System.out.println("Trying to Mine block 2... ");
//        blockchain.get(1).mineBlock(difficulty);
//
//        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).getCurHash()));
//        System.out.println("Trying to Mine block 3... ");
//        blockchain.get(2).mineBlock(difficulty);
//
//        System.out.println("Blockchain is Valid: " + isChainValid());
//
//        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//        System.out.println("The block chain: ");
//        System.out.println(blockchainJson);
//    }
//
//    public static Boolean isChainValid() {
//        Block currentBlock;
//        Block previousBlock;
//        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
//        for(int i=1; i < blockchain.size(); i++) {
//            currentBlock = blockchain.get(i);
//            previousBlock = blockchain.get(i-1);
//            if(!currentBlock.getCurHash().equals(currentBlock.produceHash()) ){
//                System.out.println("Current Hashes not equal");
//                return false;
//            }
//            if(!previousBlock.getCurHash().equals(currentBlock.getPrefixHash()) ) {
//                System.out.println("Previous Hashes not equal");
//                return false;
//            }
//            //增加hash值是否已经计算过
//            if(!currentBlock.getCurHash().substring( 0, difficulty).equals(hashTarget)) {
//                System.out.println("This block hasn't been mined");
//                return false;
//            }
//        }
//        return true;
//    }
}
