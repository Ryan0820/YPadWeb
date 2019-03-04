package cn.com.dao.food.impl;

import cn.com.dao.food.foodDao;
import cn.com.domain.Food;
import cn.com.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Yan
 */
public class foodDaoImpl implements foodDao {
    /**
     * 调用工具类
     */

    private JdbcTemplate jt = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public List<Food> findAll() {
        String sql = "select * from food";
        List<Food> foods = jt.query(sql, new BeanPropertyRowMapper<Food>(Food.class));
        return foods;
    }

    @Override
    public void delFood(int id) {
        String sql = "DELETE FROM food WHERE foodid = ?";
        jt.update(sql, id);
    }

    @Override
    public Food updateFindbyid(int foodid) {
        String sql = "SELECT * FROM food WHERE foodid = ?";
        Food food = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Food.class), foodid);
        return food;
    }

    @Override
    public void updateFood(Food food) {
        String sql = "UPDATE food SET foodname=?,foodsci=?,foodprice=?,foodtype=? WHERE foodid = ?";
        jt.update(sql, food.getFoodname(),food.getFoodsci(),food.getFoodprice(),food.getFoodtype(),food.getFoodid());

    }

    @Override
    public void addFood(Food food) {
        String sql ="INSERT INTO food VALUES (?,?,?,?,?)";
        jt.update(sql,food.getFoodid(), food.getFoodname(),food.getFoodsci(),food.getFoodprice(),food.getFoodtype());

    }

    @Override
    public List<Food> findbyname(String foodname) {
        String sql = "SELECT * FROM food WHERE foodname LIKE ?";
        System.out.println(foodname);
        List<Food> food = jt.query(sql, new BeanPropertyRowMapper<>(Food.class),foodname);
        return food;
    }

    @Override
    public List<Food> findFoodsci(String foodsci) {
        String sql = "select * from food WHERE foodsci = ?";
        List<Food> foods = jt.query(sql, new BeanPropertyRowMapper<Food>(Food.class),foodsci);
        return foods;
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from food";

        return  jt.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Food> getFindAll(int start, int row) {
        String sql = "select * from food limit ? , ? ";

        List<Food> foodList = jt.query(sql, new BeanPropertyRowMapper<Food>(Food.class), start, row);
        return foodList;
    }


}
