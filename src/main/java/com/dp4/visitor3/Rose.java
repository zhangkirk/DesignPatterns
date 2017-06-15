package com.dp4.visitor3;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Rose implements Flower {
    public void accept(Visitor visitor) {
        visitor.visite(this);
    }
}
