package com.dp3.command;

/**
 * Created by dpingxian on 2017/6/13.
 */
public class MyCommand implements Command{

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void exe() {
        receiver.action();
    }
}
