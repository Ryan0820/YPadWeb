package cn.com.domain;

import java.util.Date;

public class Order {
    private int orderid;//订单编号
    private Date ordertime;//订单时间
    private String ordername;//订单名
    private double orderprice;//订单原价
    private double ordersale;//订单优惠
    private double orderpay;//订单金额
    private String ordermodepay;//支付方式
    private String ordertype;//订单内容
    //private String ordersuc;//是否支付成功


    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }

    public double getOrdersale() {
        return ordersale;
    }

    public void setOrdersale(double ordersale) {
        this.ordersale = ordersale;
    }

    public double getOrderpay() {
        return orderpay;
    }

    public void setOrderpay(double orderpay) {
        this.orderpay = orderpay;
    }

    public String getOrdermodepay() {
        return ordermodepay;
    }

    public void setOrdermodepay(String ordermodepay) {
        this.ordermodepay = ordermodepay;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }
}
