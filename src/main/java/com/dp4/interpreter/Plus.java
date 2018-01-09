package com.dp4.interpreter;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Plus implements Expression{
    public int interpret(Context context) {
        return context.getNum1()+context.getNum2();
    }
}
