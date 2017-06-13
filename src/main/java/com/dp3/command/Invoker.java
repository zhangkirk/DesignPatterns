package com.dp3.command;

/**
 * Created by dpingxian on 2017/6/13.
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
