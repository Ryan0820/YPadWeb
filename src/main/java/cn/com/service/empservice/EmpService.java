package cn.com.service.empservice;

import cn.com.domain.Emp;

import java.util.List;

/**
 *
 */
public interface EmpService {
    public List<Emp> findAll();

    void delEmp(String id);

    Emp updateFindbyid(String empid);

    void updatEmp(Emp emp);

    void addEmp(Emp emp);

    Emp findbyid(String empid);

    void daySubtract(String empday,String empid);

    Emp empLogin(String empid, String empname);
}
