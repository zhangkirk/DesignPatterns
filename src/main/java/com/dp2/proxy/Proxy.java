package com.dp2.proxy;

/**
 * Created by dpingxian on 2017/6/9.
 */
public class Proxy implements Sourceable{

    private Source source;

    /**
     * 这里是代理模式和装饰模式不一样的地方
     */
    public Proxy() {
        this.source = new Source();
    }

    public void method() {
        before();
        source.method();
        atfer();
    }

    private void atfer() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }
}
