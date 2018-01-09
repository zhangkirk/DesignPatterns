package com.dp2.proxy1;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/21.
 */
public class PersonHandler implements InvocationHandler {
    private Object obj;

    public PersonHandler(Object obj){
        this.obj=obj;
    }


    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(obj, objects);
        System.out.println("after");
        return result;
    }
}
