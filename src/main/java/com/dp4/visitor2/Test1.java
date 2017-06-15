package com.dp4.visitor2;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Test1 {
    public static void main(String[] args) {
        //采用访问者模式解决
        Service saving = new Saving();
        Service fund = new Fund();
        Service draw = new Draw();
        Visitor visitor = new Visitor();
        saving.accept(visitor);
        fund.accept(visitor);
        draw.accept(visitor);
        //上述中accept中实际上有观察者的影子 实际上 访问者我们也可以理解成一个对业务熟悉的观察者
        //他不断观察者是否有新的业务需求 有的话 进行相应的业务处理
    }
}
