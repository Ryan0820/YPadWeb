package cn.com.dao.home.impl;

import cn.com.dao.home.HomeDao;
import cn.com.domain.Food;
import cn.com.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yan
 */
public class HomeDaoImpl implements HomeDao {
    /**
     * 调用工具类
     */
    private JdbcTemplate jt = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public int getTotalCountse(String searchname) {
        String sql = "select count(*) from food where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List obj = new ArrayList<>();
        if (searchname != null) {
            sb.append(" and foodname like ? ");
            obj.add("%" + searchname + "%");
        }
        sql = sb.toString();
        return jt.queryForObject(sql,Integer.class,obj.toArray());
    }

    @Override
    public List<Food> getFindAllse(int start, int newrows, String searchname) {
        String sql = "select * from food where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List obj = new ArrayList<>();
        if (searchname != null) {
            sb.append(" and foodname like ? ");
            obj.add("%" + searchname + "%");
        }
        sb.append(" limit ? , ? ");
        obj.add(start);
        obj.add(newrows);
        sql = sb.toString();
        return jt.query(sql,new BeanPropertyRowMapper<Food>(Food.class),obj.toArray());
    }

    @Override
    public int getTotalCountcx(String foodsci) {

        String sql = "select count(*) from food where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List obj = new ArrayList<>();
        if (foodsci != null) {
            sb.append(" and foodsci like ? ");
            obj.add("%" + foodsci + "%");
        }
        sql = sb.toString();
        return jt.queryForObject(sql,Integer.class,obj.toArray());
    }


    @Override
    public List<Food> getFindAllcx(int start, int row, String foodsci) {

        String sql = "select * from food where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List obj = new ArrayList<>();
        if (foodsci != null) {
            sb.append(" and foodsci like ? ");
            obj.add("%" + foodsci + "%");
        }
        sb.append(" limit ? , ? ");
        obj.add(start);
        obj.add(row);
        sql = sb.toString();
        return jt.query(sql,new BeanPropertyRowMapper<Food>(Food.class),obj.toArray());
    }

    @Override
    public Food findbyname(String foodname) {
        String sql = "SELECT * FROM food WHERE foodname = ?";
        Food food = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Food.class), foodname);
        return food;
    }

    @Override
    public List<Food> findFoodsci(String foodsci) {
        String sql = "select * from food WHERE foodsci = ?";
        List<Food> foods = jt.query(sql, new BeanPropertyRowMapper<Food>(Food.class), foodsci);
        return foods;
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from food";

        return jt.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Food> getFindAll(int start, int row) {
        String sql = "select * from food limit ? , ? ";

        List<Food> foodList = jt.query(sql, new BeanPropertyRowMapper<Food>(Food.class), start, row);
        return foodList;
    }


}
