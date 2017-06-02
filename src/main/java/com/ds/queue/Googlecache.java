package com.ds.queue;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * guava cache 使用实例
 * Created by dpingxian on 2017/6/2.
 */
public class Googlecache {
    LoadingCache<String, String> testCache = CacheBuilder.newBuilder()
            .expireAfterWrite(20, TimeUnit.MINUTES)// 缓存20分钟
            .maximumSize(1000)// 最多缓存1000个对象
            .build(new CacheLoader<String, String>() {
                public String load(String key) throws Exception {
                    if (key.equals("hi")) {
                        return null;
                    }
                    return key + "-world";
                }
            });

    public static void main(String[] args) {
        Googlecache hello = new Googlecache();
        System.out.println(hello.testCache.getIfPresent("hello"));//null
        hello.testCache.put("123", "nana");//存放缓存
        System.out.println(hello.testCache.getIfPresent("123"));//nana
        try {
            System.out.println(hello.testCache.get("hello"));//hello-world
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(hello.testCache.getIfPresent("hello"));//hello-world
        /***********测试null*************/
        System.out.println(hello.testCache.getIfPresent("hi"));//null
        try {
            System.out.println(hello.testCache.get("hi"));//抛异常
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
