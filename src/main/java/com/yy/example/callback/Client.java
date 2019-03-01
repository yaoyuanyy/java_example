package com.yy.example.callback;

import java.util.UUID;

/**
 * Description:
 * <p></p>
 * <pre>
 *   在实际业务中处理中，有这样一种场景，我们会在业务的开始设置线程上下文变量，
 *   在业务结束时对线程上下文变量进行清空，很类似于JDBC的操作后对数据库资源的释放，
 *   我们可以借助回调方法实现其执行步骤
 *
 *   参考：https://kim-miao.iteye.com/blog/1669310
 * </pre>
 * <p>
 * Created by skyler on 2019-03-01 at 15:49
 */
public class Client {

    public static void main(String[] args) {

        Context context = new Context("skyler", UUID.randomUUID().toString());
        ContextHolder.setContext(context);


        BusinessTemplate<Result> template = new BusinessTemplate<>(new CallbackProcessor<Result>() {
            @Override
            public Result process() {
                System.out.println("进入到匿名类的process方法中");
                return new Result();
            }

            @Override
            public void complate() {
                System.out.println("进入到匿名类的complate方法中");
            }
        });

        template.execute();
        System.out.println("context:" + ContextHolder.getContext() + ", current Thread:" + Thread.currentThread().getName());


        // 从另一个线程中去ContextHolder对象中的值
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("context:" + ContextHolder.getContext() + ", current Thread:" + Thread.currentThread().getName());
            }
        }).start();
    }
}
