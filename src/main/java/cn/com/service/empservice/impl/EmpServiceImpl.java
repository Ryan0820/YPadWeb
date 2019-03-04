package cn.com.service.empservice.impl;

import cn.com.dao.emp.impl.empDaoImpl;
import cn.com.dao.emp.empDao;
import cn.com.domain.Emp;
import cn.com.service.empservice.EmpService;

import java.util.List;

/**
 * @author Yan
 */
public class EmpServiceImpl implements EmpService {

    private empDao dao = new empDaoImpl();

    /**
     * @return
     */
    @Override
    public List<Emp> findAll() {
        return dao.findAll();
    }

    @Override
    public void delEmp(String id) {
        dao.delEmp(Integer.parseInt(id));
    }

    @Override
    public Emp updateFindbyid(String empid) {
        return dao.updateFindbyid(Integer.parseInt(empid));
    }

    @Override
    public void updatEmp(Emp emp) {
        dao.updateEmp(emp);
    }

    @Override
    public void addEmp(Emp emp) {
        dao.addEmp(emp);
    }

    @Override
    public Emp findbyid(String empid) {
        return dao.findbyid(Integer.parseInt(empid));
    }

    @Override
    public void daySubtract(String empday, String empid) {
        int day = Integer.parseInt(empday);
        if (day < 0 || day > 31 || day == -1) {
            day = 1;
        } else if (day == 0) {
            day = 0;
        } else {
            day--;
        }

        dao.daySubtract(day, Integer.parseInt(empid));
    }

    @Override
    public Emp empLogin(String empid, String empname) {
        return dao.empLogin(Integer.parseInt(empid),empname);
    }

}
