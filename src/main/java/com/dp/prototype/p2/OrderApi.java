package com.dp.prototype.p2;

/**
 *
 * Created by dpingxian on 2017/6/2.
 * 原型模式
 * 订单接口
 * <p>提供一个克隆自身的方法<p/>
 *
 */
public interface OrderApi extends Cloneable{

    public int getOrderProductNum();

}
