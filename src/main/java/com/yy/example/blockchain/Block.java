package com.yy.example.blockchain;

import java.time.LocalDateTime;
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

    private String curHash;
    private String prefixHash;
    private Object data;
    private long timestamp;
    private int rdm;


    public Block(Object data,String prefixHash) {
        this.timestamp = System.currentTimeMillis();
        this.prefixHash = prefixHash;
        this.data = data;
        this.curHash = produceHash();
    }

    /**
     * 产生hash值
     * @param
     * @return
     */
    public String produceHash(){
        return EncodeUtil.applySha256(prefixHash + timestamp + rdm +data.toString() );
    }

    public void mineBlock(int difficulty) {
        //创建一个string值由难度的位数来决定

        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!curHash.substring( 0, difficulty).equals(target)) {
            rdm ++;
            curHash = produceHash();
        }
        System.out.println("Block Mined!!! : " + curHash);
    }

    public String getCurHash() {
        return curHash;
    }

    public void setCurHash(String curHash) {
        this.curHash = curHash;
    }

    public String getPrefixHash() {
        return prefixHash;
    }

    public void setPrefixHash(String prefixHash) {
        this.prefixHash = prefixHash;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
