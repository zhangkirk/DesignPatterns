package com.dp.factory.abs;

/**
 * Created by Administrator on 2017/5/26.
 */
public class DepositFactory implements Provider{
    public Sender produce() {
        return new DepositSender();
    }
}
