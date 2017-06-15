package com.dp4.visitor;

/**
 * Created by dpingxian on 2017/6/15.
 */
public class Test {
    public static void main(String[] args) {

        Visitor visitor = new MyVisitor();
        Subject sub = new MySubject();
        sub.accept(visitor);
    }
}
