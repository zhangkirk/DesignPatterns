package com.dp.prototype.p1;

/**
 * Created by dpingxian on 2017/6/2.
 * 测试客服端
 */
public class OrderClient {
    public static void main(String[] args) {
        PersonalOrder po = new PersonalOrder();
        po.setOrderProductNum(2924);
        po.setCustomerName("dd");
        po.setProductId("p1");
        OrderBusiness ob = new OrderBusiness();
        ob.saveOder(po);
    }
}
