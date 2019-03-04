package cn.com.service.homeservice;

import cn.com.domain.Food;
import cn.com.domain.PageBean;

import java.util.List;

/**
 *
 */
public interface HomeService {

    PageBean<Food> getPageBean(String currentPage, String rows);

    /**
     * 根据菜系展示菜品
     * @param currentPage
     * @param rows
     * @param foodsci
     * @return
     */
    PageBean<Food> getPageBeanforsci(String currentPage, String rows, String foodsci);

    /**
     * 搜索菜品
     * @param currentPage
     * @param rows
     * @param
     * @return
     */
    PageBean<Food> getPageBeanforSearch(String currentPage, String rows, String searchname);

}
