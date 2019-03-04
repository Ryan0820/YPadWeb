package cn.com.service.foodservice;

import cn.com.domain.Food;
import cn.com.domain.PageBean;

import java.util.List;

/**
 *@author Yan
 */
public interface FoodService {
    public List<Food> findAll();

    void delFood(String id);

    Food updateFindbyid(String foodid);

    void updatFood(Food food);

    void addFood(Food food);

    List<Food> findbyname(String name);

    List<Food> findFoodsci(String foodsci);

    void delCksAll(String[] fids);

    PageBean<Food> getPageBean(String currentPage, String rows);
}
