package com.dp4.visitor3;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure flowers = new ObjectStructure();
        flowers.attach(new Rose());
        flowers.attach(new Lily());

        flowers.accept(new Bee());
        flowers.accept(new Bird());
    }
}
