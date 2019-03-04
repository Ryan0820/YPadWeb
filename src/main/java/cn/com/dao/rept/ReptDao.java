package cn.com.dao.rept;

import cn.com.domain.PageBean;
import cn.com.domain.Rept;

import java.util.List;

public interface ReptDao {

    List<Rept> findAll();

    Rept updateFindbyid(int id);

    void updatRept(Rept rept);

    void addRept(Rept rept);

    List<Rept> findbyreptname(String reptname);

    void delRept(String reptid);

    List<Rept> getPageBean(int currentPage, int rows);

    int getTotalCount();

}
