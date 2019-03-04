package cn.com.dao.emp.impl;

import cn.com.dao.emp.empDao;
import cn.com.domain.Emp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import cn.com.util.DruidUtils;

import java.util.List;

/**
 * @author Yan
 */
public class empDaoImpl implements empDao {


    /**
     * 调用工具类
     */
    private JdbcTemplate jt = new JdbcTemplate(DruidUtils.getDataSource());


    @Override
    public void addEmp(Emp emp) {
        String sql ="INSERT INTO ypademp VALUES (?,?,?,?,?,?,?,?,?)";
        jt.update(sql, emp.getEmpid(), emp.getEmpname(),emp.getEmpgender(),emp.getEmpsfz(),emp.getEmpphone(), emp.getEmpdept(),emp.getEmpday(), emp.getEmpsal(), emp.getEmpbon());
    }

    @Override
    public Emp findbyid(int id) {
        String sql = "SELECT * FROM ypademp WHERE empid = ?";
        Emp emp = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class),id);
        return emp;
    }

    @Override
    public void daySubtract(int empday,int empid) {
        String sql = "UPDATE ypademp SET empday =? WHERE empid = ?";
        jt.update(sql,empday,empid);

    }

    @Override
    public Emp empLogin(int empid, String empname) {
        String sql = "SELECT * FROM ypademp WHERE empid =? AND  empname =?";
        Emp emp = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class),empid,empname);
        return emp;
    }

    @Override
    public void delEmp(int id) {
        String sql = "DELETE FROM ypademp WHERE empid = ?";
        jt.update(sql, id);
    }

    @Override
    public Emp updateFindbyid(int empid) {
        String sql = "SELECT * FROM ypademp WHERE empid = ?";
        Emp emp = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), empid);
        return emp;
    }

    @Override
    public void updateEmp(Emp emp) {
        String sql = "UPDATE ypademp SET empname=?,empgender=?,empsfz=?,empphone=?, empdept=?,empday=?, empsal=?,empbon=? WHERE empid = ?";
        jt.update(sql, emp.getEmpname(),emp.getEmpgender(),emp.getEmpsfz(),emp.getEmpphone(), emp.getEmpdept(),emp.getEmpday(), emp.getEmpsal(), emp.getEmpbon(),emp.getEmpid());
    }

    @Override
    public List<Emp> findAll() {

        String sql = "select * from ypademp";
        List<Emp> emps = jt.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        return emps;
    }

}
