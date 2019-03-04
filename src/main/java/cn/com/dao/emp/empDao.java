package cn.com.dao.emp;

import cn.com.domain.Emp;
import cn.com.domain.Food;

import java.util.List;
import java.util.Map;

/**
 * @author Yan
 */
public interface empDao {

    public List<Emp> findAll();

    void delEmp(int id);

    Emp updateFindbyid(int empid);

    void updateEmp(Emp emp);

    void addEmp(Emp emp);

    Emp findbyid(int id);


    void daySubtract(int empday, int empid);

    Emp empLogin(int empid, String empname);
}
