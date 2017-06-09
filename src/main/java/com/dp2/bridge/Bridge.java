package com.dp2.bridge;

/**
 * Created by dpingxian on 2017/6/9.
 */
public abstract class Bridge {
    private Sourceable source;

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }

    public void method(){
        source.method();
    }
}
