package com.dp3.Iterator;


/**
 * Created by dpingxian on 2017/6/12.
 */
public interface Collection {
    public Iterator iterator();

    /*取得集合元素*/
    public Object get(int i);

    /*取得集合大小*/
    public int size();
}
