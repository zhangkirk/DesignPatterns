package com.algorithm.test2;

/**
 * Created by Administrator on 2017/6/27.
 */
public class FixedCapacityStackOfStrings<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = (Item[])new Object[cap];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(Item item){
        a[N++] = item;
    }

    public Item pop(){
        return a[--N];
    }
}
