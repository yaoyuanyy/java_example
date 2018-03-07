package com.yy.example.blockchain;

import com.yy.example.blockchain.exchange.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * Description:
 * <p></p>
 * <pre>
 *     Part 1:http://blog.csdn.net/u010093971/article/details/79358730 原文：https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
 *     Part 2:https://github.com/xitu/gold-miner/blob/master/TODO/creating-your-first-blockchain-with-java-part-2-transactions.md 原文：https://medium.com/programmers-blockchain/creating-your-first-blockchain-with-java-part-2-transactions-2cdac335e0ce
 * </pre>
 * NB.
 * Created by skyler on 2018/3/4 at 下午10:34
 */
public class Block {

    public String hash;
    public String previousHash;
    public String merkleRoot;
    public ArrayList<Transaction> transactions = new ArrayList<Transaction>(); //我们的数据就是一个简单的信息
    public long timeStamp; //从1970/1/1到现在经过的毫秒时间
    public int nonce;

    //构造方法
    public Block(String previousHash ) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();

        this.hash = calculateHash(); //确保设置了其它值之后再计算哈希值
    }

    //基于区块内容计算新的哈希值
    public String calculateHash() {
        String calculatedhash = EncodeUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        merkleRoot
        );
        return calculatedhash;
    }

    //哈希目标达成的话，增加 nonce 值
    public void mineBlock(int difficulty) {
        merkleRoot = EncodeUtil.getMerkleRoot(transactions);
        String target = EncodeUtil.getDificultyString(difficulty); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

    //添加交易到区块
    public boolean addTransaction(Transaction transaction) {
        //process transaction and check if valid, unless block is genesis block then ignore.
        if(transaction == null) return false;
        if((previousHash != "0")) {
            if((transaction.processTransaction() != true)) {
                System.out.println("Transaction failed to process. Discarded.");
                return false;
            }
        }
        transactions.add(transaction);
        System.out.println("Transaction Successfully added to Block");
        return true;
    }
}
