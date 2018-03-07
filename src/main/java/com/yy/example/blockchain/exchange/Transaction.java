package com.yy.example.blockchain.exchange;

import com.yy.example.blockchain.EncodeUtil;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/3/7 at 下午11:13
 */
public class Transaction {

    public String transactionId; // 这个也是交易的哈希值
    public PublicKey sender; // 发送方地址/公钥
    public PublicKey reciepient; // 接受方地址/公钥
    public float value;
    public byte[] signature; // 用来防止他人盗用我们钱包里的资金

    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

    private static int sequence = 0; // 对已生成交易个数的粗略计算

    // 构造方法：
    public Transaction(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        this.inputs = inputs;
    }

    // 用来计算交易的哈希值（可作为交易的 id）
    private String calulateHash() {
        sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
        return EncodeUtil.applySha256(
                EncodeUtil.getStringFromKey(sender) +
                        EncodeUtil.getStringFromKey(reciepient) +
                        Float.toString(value) + sequence
        );
    }


    //对所有我们不想被篡改的数据进行签名
    public byte[] generateSignature(PrivateKey privateKey) {
        String data = EncodeUtil.getStringFromKey(sender) + EncodeUtil.getStringFromKey(reciepient) + Float.toString(value)	;
        signature = EncodeUtil.applyECDSASig(privateKey,data);
        return signature;

    }
    //验证我们已签名的数据
    public boolean verifiySignature() {
        String data = EncodeUtil.getStringFromKey(sender) + EncodeUtil.getStringFromKey(reciepient) + Float.toString(value)	;
        return EncodeUtil.verifyECDSASig(sender, data, signature);
    }



    //如果新交易可以生成，返回 true
    public boolean processTransaction() {

        if(verifiySignature() == false) {
            System.out.println("#Transaction Signature failed to verify");
            return false;
        }

        //整合所有交易输入（确保是未花费的）
        for(TransactionInput i : inputs) {
            i.UTXO = NoobChain.UTXOs.get(i.transactionOutputId);
        }

        //检查交易是否合法
        if(getInputsValue() < NoobChain.minimumTransaction) {
            System.out.println("#Transaction Inputs to small: " + getInputsValue());
            return false;
        }

        //生成交易输出
        float leftOver = getInputsValue() - value; //获取剩余的零钱
        transactionId = calulateHash();
        outputs.add(new TransactionOutput( this.reciepient, value,transactionId)); //send value to recipient
        outputs.add(new TransactionOutput( this.sender, leftOver,transactionId)); //把剩下的“零钱“发回给发送方

        //添加输出到未花费的 list 中
        for(TransactionOutput o : outputs) {
            NoobChain.UTXOs.put(o.id , o);
        }

        //从 UTXO list里面移除已花费的交易输出
        for(TransactionInput i : inputs) {
            if(i.UTXO == null) continue; //if Transaction can't be found skip it
            NoobChain.UTXOs.remove(i.UTXO.id);
        }

        return true;
    }

    //返回输入(UTXOs) 值的总额
    public float getInputsValue() {
        float total = 0;
        for(TransactionInput i : inputs) {
            if(i.UTXO == null) continue; //if Transaction can't be found skip it
            total += i.UTXO.value;
        }
        return total;
    }

    //返回输出总额
    public float getOutputsValue() {
        float total = 0;
        for(TransactionOutput o : outputs) {
            total += o.value;
        }
        return total;
    }
}

