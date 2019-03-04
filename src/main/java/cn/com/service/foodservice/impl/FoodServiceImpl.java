package cn.com.service.foodservice.impl;

import cn.com.dao.food.foodDao;
import cn.com.dao.food.impl.foodDaoImpl;
import cn.com.domain.Food;
import cn.com.domain.PageBean;
import cn.com.service.foodservice.FoodService;

import java.util.List;


/**
 * @author Yan
 */
public class FoodServiceImpl implements FoodService {

    private foodDao dao = new foodDaoImpl();

    @Override
    public List<Food> findAll() {
        return dao.findAll();
    }

    @Override
    public void delFood(String id) {
        dao.delFood(Integer.parseInt(id));
    }

    @Override
    public Food updateFindbyid(String foodid) {
        return dao.updateFindbyid(Integer.parseInt(foodid));
    }

    @Override
    public void updatFood(Food food) {
        dao.updateFood(food);
    }

    @Override
    public void addFood(Food food) {
        dao.addFood(food);
    }

    @Override
    public  List<Food> findbyname(String foodname) {
        return dao.findbyname(foodname);
    }

    @Override
    public List<Food> findFoodsci(String foodsci) {
        return dao.findFoodsci(foodsci);
    }

    @Override
    public void delCksAll(String[] fids) {
        for (String fid : fids) {
            dao.delFood(Integer.parseInt(fid));
        }
    }

    /**
     * 分页查询
     *
     * @param currentPage
     * @param rows
     * @return
     */
    @Override
    public PageBean<Food> getPageBean(String currentPage, String rows) {

        PageBean<Food> pb = new PageBean<Food>();
        int newcurrentPage = Integer.parseInt(currentPage);
        int newrows = Integer.parseInt(rows);
        //1获取总记录数
        int totalCount = dao.getTotalCount();
        pb.setTotalCount(totalCount);
        //总页数
        int totalPage = (totalCount % newrows) == 0 ? (totalCount / newrows) : (totalCount / newrows) + 1;
        pb.setTotalPage(totalPage);
        //判断前一页后一页的页码
        if (newcurrentPage <= 0) {
            newcurrentPage = 1;
        }
        if (newcurrentPage >= totalPage) {
            newcurrentPage = totalPage;
        }
        pb.setCurrentPage(newcurrentPage);
        pb.setRows(newrows);
        //*******计算每次开始查询的索引
        int start = ((newcurrentPage - 1) * newrows);

        List<Food> foods = dao.getFindAll(start, newrows);
        pb.setList(foods);
        return pb;
    }
}
