package com.yy.example.java.java_base;

import com.alibaba.fastjson.util.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p></p>
 * <pre>
 *     refer to:
 *     https://mp.weixin.qq.com/s?__biz=MzI3NzE0NjcwMg==&mid=2650120882&idx=1&sn=8e355b5ee3cce0a2d0108edbdf88e606&chksm=f36bbf93c41c3685340d4f658dddec6bcbd5903b5d92875bb06d51a0dfc49ee7326417a0edff&scene=21#wechat_redirect
 * </pre>
 * NB.
 * Created by skyler on 2018/4/25 at 上午10:55
 */
public class SerializableTest {

    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        final List<String> stringList = new ArrayList<String>();
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hollis");
        stringList.add("chuang");
        System.out.println("init StringList" + stringList);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("stringlist"));
        objectOutputStream.writeObject(stringList);

        IOUtils.close(objectOutputStream);
        final File file = new File("stringlist");
        final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        final List<String> newStringList = (List<String>) objectInputStream.readObject();
        IOUtils.close(objectInputStream);
        if (file.exists()) {
            file.delete();
        }
        System.out.println("new StringList" + newStringList);
    }
}
