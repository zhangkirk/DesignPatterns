package com.dp4.visitor3;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface Visitor {
    public void visite(Lily lily);

    public void visite(Rose rose);
}
