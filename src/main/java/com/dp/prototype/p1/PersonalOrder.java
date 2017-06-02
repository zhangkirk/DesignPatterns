package com.dp.prototype.p1;

/**
 * Created by dpingxian on 2017/6/2.
 * 个人订单，实现克隆方法
 */
public class PersonalOrder implements OrderApi {

    private String customerName;

    private String productId;

    private int orderProductNum = 0;

    public int getOrderProductNum() {
        return this.orderProductNum;
    }

    public void setOrderProductNum(int num) {
        orderProductNum = num;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public OrderApi clone() {
        PersonalOrder order = new PersonalOrder();
        order.setCustomerName(this.customerName);
        order.setProductId(this.productId);
        order.setOrderProductNum(this.orderProductNum);
        return order;
    }
}
