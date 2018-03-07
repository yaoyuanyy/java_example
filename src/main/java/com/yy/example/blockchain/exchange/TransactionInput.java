package com.yy.example.blockchain.exchange;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/3/7 at 下午11:27
 */
public class TransactionInput {
    public String transactionOutputId; //把 TransactionOutputs 标识为对应的transactionId
    public TransactionOutput UTXO; //包括了所有未花费的交易输出

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
}

