package com.dp4.visitor;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface  Subject {
    public void accept(Visitor visitor);
    public String getSubject();
}
