package cn.com.service.homeservice.impl;

import cn.com.dao.home.HomeDao;
import cn.com.dao.home.impl.HomeDaoImpl;
import cn.com.domain.Food;
import cn.com.domain.PageBean;
import cn.com.service.homeservice.HomeService;

import java.util.List;

/**
 * @author Yan
 */
public class HomeServiceImpl implements HomeService {

    private HomeDao dao = new HomeDaoImpl();

    /**
     * 搜索菜品
     *
     * @param currentPage
     * @param rows
     * @param foodsci
     * @return
     */
    @Override
    public PageBean<Food> getPageBeanforSearch(String currentPage, String rows, String searchname) {
        PageBean<Food> pb = new PageBean<Food>();
        int newcurrentPage = Integer.parseInt(currentPage);
        int newrows = Integer.parseInt(rows);
        //1获取总记录数
        int totalCount = dao.getTotalCountse(searchname);
        pb.setTotalCount(totalCount);
        //总页数
        int totalPage  = (totalCount % newrows) == 0 ? (totalCount / newrows ) : (totalCount / newrows ) + 1;
        pb.setTotalPage(totalPage);
        //判断前一页后一页的页码
        if (newcurrentPage <=0){
            newcurrentPage = 1;
        }
        if (newcurrentPage >= totalPage){
            newcurrentPage = totalPage;
        }
        pb.setCurrentPage(newcurrentPage);
        pb.setRows(newrows);
        //*******计算每次开始查询的索引
        int start= ((newcurrentPage -1) * newrows);

        List<Food> foods = dao.getFindAllse(start,newrows,searchname);
        pb.setList(foods);
        return pb;
    }

    /**
     * 根据菜系展示菜品
     *
     * @param currentPage
     * @param rows
     * @param foodsci
     * @return
     */
    @Override
    public PageBean<Food> getPageBeanforsci(String currentPage, String rows, String foodsci) {
        PageBean<Food> pb = new PageBean<Food>();
        int newcurrentPage = Integer.parseInt(currentPage);
        int newrows = Integer.parseInt(rows);
        //1获取总记录数
        int totalCount = dao.getTotalCountcx(foodsci);
        pb.setTotalCount(totalCount);
        //总页数
        int totalPage  = (totalCount % newrows) == 0 ? (totalCount / newrows ) : (totalCount / newrows ) + 1;
        pb.setTotalPage(totalPage);
        //判断前一页后一页的页码
        if (newcurrentPage <=0){
            newcurrentPage = 1;
        }
        if (newcurrentPage >= totalPage){
            newcurrentPage = totalPage;
        }
        pb.setCurrentPage(newcurrentPage);
        pb.setRows(newrows);
        //*******计算每次开始查询的索引
        int start= ((newcurrentPage -1) * newrows);

        List<Food> foods = dao.getFindAllcx(start,newrows,foodsci);
        pb.setList(foods);
        return pb;
    }

    /**
     * 分页查询
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
        int totalPage  = (totalCount % newrows) == 0 ? (totalCount / newrows ) : (totalCount / newrows ) + 1;
        pb.setTotalPage(totalPage);
        //判断前一页后一页的页码
        if (newcurrentPage <=0){
            newcurrentPage = 1;
        }
        if (newcurrentPage >= totalPage){
            newcurrentPage = totalPage;
        }
        pb.setCurrentPage(newcurrentPage);
        pb.setRows(newrows);
        //*******计算每次开始查询的索引
        int start= ((newcurrentPage -1) * newrows);

        List<Food> foods = dao.getFindAll(start,newrows);
        pb.setList(foods);
        return pb;
    }




}
