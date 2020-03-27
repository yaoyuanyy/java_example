package com.yy.example.pattern_mode.action.command;

/**
 * Description: 调用者，调用命令对象
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-26 at 14:42
 */
public class Invoker {

    protected AbstractCommand command;

    /**
     * 传什么命令，执行什么命令的操作
     */
    public Invoker(AbstractCommand command) {
        this.command = command;
    }

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    public void action(){
        command.execute();
    }
}
