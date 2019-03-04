package cn.com.dao.order.impl;

import cn.com.dao.order.OrderDao;
import cn.com.domain.Order;
import cn.com.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public int getTotalCount() {
        String sql = "SELECT COUNT(*) FROM orders";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Order> getAllOrder(int start, int newRows) {
        String sql = "select * from orders limit ? , ?";
        List<Order> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), start, newRows);
        return list;
    }

    @Override
    public void delOrder(int orderid) {
        String sql = "delete FROM  orders WHERE orderid = ?";
        jdbcTemplate.update(sql,orderid);
    }

    @Override
    public Order findbyid(int id) {
        String sql = "select * FROM  orders WHERE orderid = ?";
        Order order = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Order>(Order.class), id);
        return order;
    }
}

