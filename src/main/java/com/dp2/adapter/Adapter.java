package com.dp2.adapter;

/**
 * Created by dpingxian on 2017/6/9.
 */
public class Adapter extends Source implements Targetable{

    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
