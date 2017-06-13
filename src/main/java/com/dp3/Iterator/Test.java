package com.dp3.Iterator;

/**
 * Created by dpingxian on 2017/6/12.
 */
public class Test {
    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
