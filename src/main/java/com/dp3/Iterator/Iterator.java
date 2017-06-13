package com.dp3.Iterator;

/**
 * Created by dpingxian on 2017/6/12.
 */
public interface Iterator {
    //前移
    public Object previous();

    //后移
    public Object next();
    public boolean hasNext();

    //取得第一个元素
    public Object first();
}
