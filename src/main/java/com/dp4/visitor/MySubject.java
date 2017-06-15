package com.dp4.visitor;

/**
 * Created by dpingxian on 2017/6/15.
 */
public class MySubject implements Subject {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    public String getSubject() {
        return "love";
    }
}
