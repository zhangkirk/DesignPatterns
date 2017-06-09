package com.dp2.objadapter;

/**
 * Created by dpingxian on 2017/6/9.
 *
 * Source类，拥有一个方法，待适配，目标接口时Targetable，通过Adapter类，将Source的功能扩展到Targetable里
 * 适配器模式
 */
public class Source {

    public void method1() {
        System.out.println("this is original method!");
    }
}
