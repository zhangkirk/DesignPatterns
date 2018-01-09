package com.othertest.interfaceextends;

import com.dp2.proxy1.PersonDao;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/20.
 */
public  class Person implements PersonBehavior, InvocationHandler {


    LaughBehavior laughBehavior = new LaughBehaviorImpl();

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("");
        Object result = method.invoke(o, objects);
        return result;
    }

    public void laugh() {

//        PersonDao proxy = (PersonDao) Proxy.newProxyInstance(laughBehavior.getClass().getClassLoader(), laughBehavior.getClass().getInterfaces(), );
//        this.invoke()
    }

    public void speak() {

    }
}
