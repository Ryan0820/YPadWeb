package cn.com.service.orderservice.impl;

import cn.com.dao.order.OrderDao;
import cn.com.dao.order.impl.OrderDaoImpl;
import cn.com.domain.Order;
import cn.com.domain.PageBean;
import cn.com.service.orderservice.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDaoImpl();

    @Override
    public PageBean<Order> getListOrder(String currentPage, String rows) {
        PageBean<Order> pb = new PageBean<>();
        int newCurrentPage = Integer.parseInt(currentPage);
        int newRows = Integer.parseInt(rows);
        int totalCount = dao.getTotalCount();
        pb.setTotalCount(totalCount);

        //总页数
        int totalPage = (totalCount % newRows) == 0 ? (totalCount / newRows) : (totalCount / newRows) + 1;
        pb.setTotalPage(totalPage);
        if (newCurrentPage <= 0) {
            newCurrentPage = 1;
        }
        if (newCurrentPage >= totalPage) {
            newCurrentPage = totalPage;
        }
        pb.setCurrentPage(newCurrentPage);
        pb.setRows(newRows);
        //开始查找的索引
        int start = (newCurrentPage - 1) * newRows;

        List<Order> list = dao.getAllOrder(start, newRows);
        pb.setList(list);

        return pb;
    }

    @Override
    public void delOrder(String orderid) {
        dao.delOrder(Integer.parseInt(orderid));
    }

    @Override
    public void delOrderCks(String[] fids) {
        for (String id:fids) {
            dao.delOrder(Integer.parseInt(id));
        }
    }

    @Override
    public Order findbyid(String orderid) {
        return dao.findbyid(Integer.parseInt(orderid));
    }
}
