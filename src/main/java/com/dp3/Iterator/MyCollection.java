package com.dp3.Iterator;

/**
 * Created by dpingxian on 2017/6/12.
 */
public class MyCollection implements Collection{
    public String string[] = null;

    public MyCollection(String[] string) {
        this.string = string;
    }

    public Iterator iterator() {
        return new MyIterator(this);
    }


    public Object get(int i) {
        return string[i];
    }


    public int size() {
        return string.length;
    }
}
