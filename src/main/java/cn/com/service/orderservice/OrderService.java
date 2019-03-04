package cn.com.service.orderservice;

import cn.com.domain.Order;
import cn.com.domain.PageBean;

public interface OrderService {
    PageBean<Order> getListOrder(String currentPage, String rows);

    void delOrder(String orderid);

    void delOrderCks(String[] fids);

    Order findbyid(String orderid);

}
