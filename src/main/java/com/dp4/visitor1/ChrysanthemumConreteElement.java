package com.dp4.visitor1;

/**
 * Created by Administrator on 2017/6/15.
 */
public class ChrysanthemumConreteElement implements FlowerElement{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
