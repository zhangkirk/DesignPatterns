package com.drools.executor;

import com.drools.compiler.Cinter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/1/30.
 */
public class CompilerExecutor {

    private Map<String, Cinter> cache =  new ConcurrentHashMap<>();


    public void add(String key, Cinter cinter) {
        cache.put(key,cinter);
    }

    public void exec(String key){
        if(cache.containsKey(key)){
            cache.get(key).cout();
        }else{
            System.out.println("没找到对于的执行器");
        }
    }
}
