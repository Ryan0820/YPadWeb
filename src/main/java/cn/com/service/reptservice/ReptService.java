package cn.com.service.reptservice;

import cn.com.domain.Food;
import cn.com.domain.PageBean;
import cn.com.domain.Rept;

import java.util.List;

public interface ReptService {
    List<Rept> findAll();

    Rept updateFindbyid(String reptid);

    void updatRept(Rept rept);

    void addRept(Rept rept);

    List<Rept> findbyreptname(String reptid);

    void delRept(String reptid);

    PageBean<Rept> getPageBean(String currentPage, String rows);
}
