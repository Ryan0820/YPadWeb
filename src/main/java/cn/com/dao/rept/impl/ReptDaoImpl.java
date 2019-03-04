package cn.com.dao.rept.impl;

import cn.com.dao.rept.ReptDao;
import cn.com.domain.PageBean;
import cn.com.domain.Rept;
import cn.com.util.DruidUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReptDaoImpl implements ReptDao {
    private JdbcTemplate jt = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public List<Rept> findAll() {
        String sql = "select * from ypadrept";
        List<Rept> repts = jt.query(sql, new BeanPropertyRowMapper<Rept>(Rept.class));
        return repts;
    }

    @Override
    public Rept updateFindbyid(int id) {
        String sql = "SELECT * FROM ypadrept WHERE reptid = ?";
        Rept rept = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Rept.class),id);
        return rept;
    }

    @Override
    public void updatRept(Rept rept) {
        String sql = "UPDATE ypadrept SET reptname=?,reptprice=?,reptnumber=?, gname=?, gphone=?,gaddress=? WHERE reptid = ?";
        int update = jt.update(sql, rept.getReptname(), rept.getReptprice(), rept.getReptnumber(), rept.getGname(), rept.getGphone(), rept.getGaddress(), rept.getReptid());
    }
    @Override
    public void addRept(Rept rept) {
        String sql ="INSERT INTO ypadrept VALUES (?,?,?,?,?,?,?)";
        jt.update(sql, rept.getReptid(), rept.getReptname(),rept.getReptprice(),rept.getReptnumber(),rept.getGname(), rept.getGphone(),rept.getGaddress());

    }

    @Override
    public List<Rept> findbyreptname(String reptname) {
        String sql = "SELECT * FROM ypadrept WHERE reptname like ?";
        List<Rept> rept = jt.query(sql, new BeanPropertyRowMapper<>(Rept.class),reptname);
        return rept;
    }

    @Override
    public void delRept(String reptid) {
        String sql = "DELETE FROM ypadrept WHERE reptid = ?";
        jt.update(sql, reptid);
    }

    @Override
    public int getTotalCount() {
        return jt.queryForObject("select count(*) from ypadrept",Integer.class);
    }

    @Override
    public List<Rept> getPageBean(int currentPage, int rows) {

        String sql = "select * from ypadrept limit ? , ? ";

        List<Rept> list = jt.query(sql, new BeanPropertyRowMapper<Rept>(Rept.class), currentPage, rows);

        return list;
    }
    @Test
    public void test(){
        List<Rept> pageBean = getPageBean(2, 5);
        System.out.printf(pageBean.toString());
        int totalCount = getTotalCount();
        System.out.println(totalCount);
    }
}
