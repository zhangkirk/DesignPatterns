package com.dp2.bridge;

/**
 * Created by dpingxian on 2017/6/9.
 */
public class MyBridge extends Bridge{
    public void method(){
        getSource().method();
    }
}
