package com.dp4.visitor2;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Fund implements Service{
    public void accept(Visitor visitor) {
        visitor.process(this);
    }
}
