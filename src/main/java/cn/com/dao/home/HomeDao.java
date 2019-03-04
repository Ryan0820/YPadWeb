package cn.com.dao.home;

import cn.com.domain.Food;

import java.util.List;

/**
 * @author Yan
 */
public interface HomeDao {

    Food findbyname(String foodname);

    List<Food> findFoodsci(String foodsci);

    int getTotalCount();

    int getTotalCountcx(String foodsci);

    List<Food> getFindAll(int start, int row);

    List<Food> getFindAllcx(int start, int row,String foodsci);


    int getTotalCountse(String searchname);

    List<Food> getFindAllse(int start, int newrows, String searchname);
}
