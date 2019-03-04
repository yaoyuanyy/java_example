package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.spring_aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

import java.io.*;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 18:24
 */
public class Client {



    public static void main(String[] args) {

        // 将jvm中的代理对象输出到硬盘的.class文件 方法一
        // --该设置用于输出cglib动态代理产生的类
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/yaoliang/skyler");

        // --该设置用于输出jdk动态代理产生的类，输出的文件路径为your project下。如我的项目是java_example, $ProxyX.class在java_example/com/sun/proxy/下
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        ProxyFactory factory = CustomProxyFactory.getProxyObject(House.class, new SkylerHouse());
        House house = (House) factory.getProxy();

        house.address("test");

        house.desc();


        // 将jvm中的代理对象输出到硬盘的.class文件 方法二
        // writeProxyClass2File("/Users/yaoliang/skyler/project/mytest/java_example/target/classes/com/yy/example/pattern_mode/structure/proxy/dynamic_proxy/spring_aop/$Proxy2.class");
    }

    /**
     * 将内存中的$ProxyX对象生成$ProxyX.class文件存放到指定的硬盘位置
     *
     * @param outPath 存放到的硬盘位置
     */
    public static void writeProxyClass2File(String outPath){
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy2", new Class[]{House.class});
        try(OutputStream outputStream = new FileOutputStream(new File(outPath))){
            outputStream.write(bytes);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
