package com.dp.factory.abs;

/**
 * Created by Administrator on 2017/5/26.
 */
public class FactoryTest {
    public static void main(String[] args) {
        Sender send = new DepositFactory().produce();
        send.send();
        Sender sender1 = new TradeFactroy().produce();
        sender1.send();
    }
}
