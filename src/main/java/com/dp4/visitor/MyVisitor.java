package com.dp4.visitor;

/**
 * Created by dpingxian on 2017/6/15.
 */
public class MyVisitor implements Visitor {
    public void visit(Subject sub) {
        System.out.println("visit the subject："+sub.getSubject());
    }
}
