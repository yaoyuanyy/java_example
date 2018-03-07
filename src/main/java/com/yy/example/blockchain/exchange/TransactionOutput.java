package com.yy.example.blockchain.exchange;

import com.yy.example.blockchain.EncodeUtil;

import java.security.PublicKey;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/3/7 at 下午11:27
 */
public class TransactionOutput {
    public String id;
    public PublicKey reciepient; //这些币的新持有者
    public float value; //他们持有币的总额
    public String parentTransactionId; //生成这个输出的之前交易的 id

    //构造方法
    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = EncodeUtil.applySha256(EncodeUtil.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
    }

    //检查币是否属于你
    public boolean isMine(PublicKey publicKey) {
        return (publicKey == reciepient);
    }
}

