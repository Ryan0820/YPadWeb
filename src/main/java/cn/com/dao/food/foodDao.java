package cn.com.dao.food;

import cn.com.domain.Food;

import java.util.List;

/**
 * @author Yan
 */
public interface foodDao {
    public List<Food> findAll();

    void delFood(int id);

    Food updateFindbyid(int foodid);

    void updateFood(Food food);

    void addFood(Food food);

    List<Food> findbyname(String foodname);

    List<Food> findFoodsci(String foodsci);

    int getTotalCount();

    List<Food> getFindAll(int start, int row);
}
