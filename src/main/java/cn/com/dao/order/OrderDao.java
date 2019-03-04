package cn.com.dao.order;

import cn.com.domain.Order;

import java.util.List;

public interface OrderDao {
    int getTotalCount();

    List<Order> getAllOrder(int start, int newRows);

    void delOrder(int orderid);

    Order findbyid(int id);
}
