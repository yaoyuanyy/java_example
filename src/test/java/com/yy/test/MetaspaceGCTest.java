package com.yy.test;

import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description: metaspace GC
 * <p></p>
 * <pre>
 *      JVM参数:-XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=128m -XX:+PrintFlagsInitial
 *
 *  Metaspace 各个字段的含义，refer to:
 *     http://www.importnew.com/28571.html
 *     http://www.cnblogs.com/benwu/articles/8312699.html
 *     https://stackoverflow.com/questions/40891433/understanding-metaspace-line-in-jvm-heap-printout
 * </pre>
 * NB.
 * Created by skyler on 2018/5/21 at 下午5:26
 */
public class MetaspaceGCTest {

    public static void main(final String[] args) {
        int i = 0;
        try {
            for (; ; ) {
                i++;

                final Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMObject.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {

                    @Override
                    public Object intercept(final Object obj, final Method method, final Object[] args, final MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper(obj, args);
                    }
                });
                enhancer.create();
            }
        } catch (final Exception e) {
            System.out.println("第" + i + "次时发生异常");
            e.printStackTrace();
        }
    }

    static class OOMObject {

    }
}
