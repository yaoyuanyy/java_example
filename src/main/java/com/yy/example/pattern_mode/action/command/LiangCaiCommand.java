package com.yy.example.pattern_mode.action.command;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-26 at 14:51
 */
public class LiangCaiCommand extends AbstractCommand {

    public LiangCaiCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.prepareShucai();
        receiver.prepareTool();
        receiver.zuocai();
    }
}
