package com.dp2.decorator;

/**
 * Created by dpingxian on 2017/6/9.
 */
public class Decorator implements Sourceable{
    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = source;
    }

    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
