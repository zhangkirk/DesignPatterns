package com.dp.factory.common;

/**
 * Created by Administrator on 2017/5/26.
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.send();
    }
}
