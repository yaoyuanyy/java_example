package com.yy.example.pattern_mode.structure.proxy.dynamic_proxy.spring_aop;

import org.springframework.aop.aspectj.AspectJAfterAdvice;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.aspectj.AspectJPointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
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


        Client client = new Client();
        client.getProxyStyle3();

        // 将jvm中的代理对象输出到硬盘的.class文件 方法二
        // writeProxyClass2File("/Users/yaoliang/skyler/project/mytest/java_example/target/classes/com/yy/example/pattern_mode/structure/proxy/dynamic_proxy/spring_aop/$Proxy2.class");
    }

    public void getProxyStyle1() {

        ProxyFactory factory = CustomProxyFactory.getProxyObject(House.class, new SkylerHouse());
        House house = (House) factory.getProxy();

        house.address("test");

        house.desc();
    }

    /**
     * 当proxyFactory.setProxyTargetClass(true)时，不管proxyFactory.addInterface(House.class)有没有，代理都是走cglib proxy。
     * 而当proxyFactory.setProxyTargetClass(false)时，如果没有proxyFactory.addInterface(House.class)，则走cglib proxy，如果有jdk proxy
     */
    public void getProxyStyle2() {
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setAdvice(new ParemterMethodBeforeAdvice());
        advisor.setMappedName("address");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.addInterface(House.class);
        proxyFactory.setTarget(new SkylerHouse());

        // value=true时目标类有接口，也用cglib生成代理
        // proxyFactory.setProxyTargetClass(true);

        //proxyFactory.setTarget(new CustomHouse());

        House house = (House)proxyFactory.getProxy();
        house.address("cc");
    }

    public void getProxyStyle3(){
        RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
        advisor.setAdvice(new ParemterMethodBeforeAdvice());
        advisor.setPattern(".*House.*");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new CustomHouse());
        proxyFactory.setExposeProxy(true);

        CustomHouse customHouse = (CustomHouse) proxyFactory.getProxy();
        customHouse.address("dd");
        customHouse.desc();

    }

    /**
     * 将内存中的$ProxyX对象生成$ProxyX.class文件存放到指定的硬盘位置
     *
     * @param outPath 存放到的硬盘位置
     */
    public static void writeProxyClass2File(String outPath) {
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy2", new Class[]{House.class});
        try (OutputStream outputStream = new FileOutputStream(new File(outPath))) {
            outputStream.write(bytes);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
