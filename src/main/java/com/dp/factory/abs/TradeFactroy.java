package com.dp.factory.abs;

/**
 * Created by Administrator on 2017/5/26.
 */
public class TradeFactroy implements Provider {
    public Sender produce() {
        return new TradeSender();
    }
}
