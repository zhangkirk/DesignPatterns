package com.dp.singleton;

/**
 * Created by Administrator on 2017/5/31.
 * 该写法有并发问题
 */
public class Singleton {

    private static Singleton instance = null;

    public Singleton() {
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
