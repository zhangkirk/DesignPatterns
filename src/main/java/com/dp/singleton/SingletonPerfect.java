package com.dp.singleton;

/**
 * Created by Administrator on 2017/5/31.
 */
public class SingletonPerfect {

    /* 私有构造方法，防止被实例化 */
    private SingletonPerfect() {
    }

    public static Singleton getInstance(){
        return SingletonFactory.instance;
    }

    private static class SingletonFactory{
        private static Singleton instance = new Singleton();
    }
}
