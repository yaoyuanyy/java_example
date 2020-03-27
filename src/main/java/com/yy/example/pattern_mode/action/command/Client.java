package com.yy.example.pattern_mode.action.command;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-26 at 12:00
 */
public class Client {

    /**
     * 都是调用的invoker.action()，却打印出了不同的菜，原因是传入了不同的命令command
     */
    public static void main(String[] args) {

        // 做凉菜。有客人点了凉菜，老板下做凉菜命令给凉菜厨师
        Receiver receiver = new LiangCaiReceiver();
        AbstractCommand liangcaiCommand = new LiangCaiCommand(receiver);
        Invoker invoker = new Invoker(liangcaiCommand);
        invoker.action();

        System.out.println("===================");
        // 做锅包肉
        Receiver receiver2 = new HotCaiReceiver();
        AbstractCommand hotCaiCommand = new HotCaiCommand(receiver2);
        invoker.setCommand(hotCaiCommand);
        invoker.action();
    }
}
