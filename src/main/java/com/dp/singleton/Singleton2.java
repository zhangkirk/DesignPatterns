package com.dp.singleton;

/**
 * Created by Administrator on 2017/5/31.
 */
public class Singleton2 {

    private static Singleton2 instance= null;

    public Singleton2() {
    }

    private static synchronized void init(){
        if(instance == null){
            instance = new Singleton2();
        }
    }

    public synchronized Singleton2 getInstance(){
        if(instance == null){
            init();
        }
        return instance;
    }
}
