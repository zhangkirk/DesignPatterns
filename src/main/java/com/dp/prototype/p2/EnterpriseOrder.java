package com.dp.prototype.p2;


/**
 * Created by dpingxian on 2017/6/2.
 * 企业订单
 */
public class EnterpriseOrder implements OrderApi{

    private String enterpriseName;

    private String productId;

    private int orderProductNum = 0;


    public int getOrderProductNum() {
        return this.orderProductNum;
    }

    public void setOrderProductNum(int orderProductNum) {
        this.orderProductNum = orderProductNum;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }
}
