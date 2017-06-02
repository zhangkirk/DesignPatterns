package com.dp.prototype.p1;

import com.dp.prototype.p1.OrderApi;

/**
 * Created by dpingxian on 2017/6/2.
 */
public class OrderBusiness {
    public void saveOder(OrderApi order){
        while (order.getOrderProductNum()>1000){
            OrderApi newOrder = order.clone();
            newOrder.setOrderProductNum(1000);
            order.setOrderProductNum(order.getOrderProductNum()-1000);
        }
    }
}
