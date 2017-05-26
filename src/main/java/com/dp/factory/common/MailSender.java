package com.dp.factory.common;

/**
 * Created by Administrator on 2017/5/26.
 */
public class MailSender implements Sender{
    public void send() {
        System.out.println("this is MailSender");
    }
}
