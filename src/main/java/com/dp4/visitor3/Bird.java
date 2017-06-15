package com.dp4.visitor3;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Bird implements Visitor {
    public void visite(Lily lily) {
        System.out.println("bird visite lily");
    }

    public void visite(Rose rose) {
        System.out.println("bird visite rose");
    }
}
