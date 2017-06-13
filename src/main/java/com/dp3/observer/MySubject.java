package com.dp3.observer;

/**
 * Created by dpingxian on 2017/6/12.
 */
public class MySubject extends AbstractSubject{
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
