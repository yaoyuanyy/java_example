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
public class HotCaiCommand extends AbstractCommand {

    public HotCaiCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.prepareRou();
        receiver.prepareTool();
        receiver.zuocai();
    }
}
