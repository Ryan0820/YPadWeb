package cn.com.dao.admini.impl;

import cn.com.dao.admini.ADMDao;
import cn.com.domain.ADM;
import cn.com.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ADMDaoImpl implements ADMDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public ADM getAdmin(String adname, String adpass) {
        String sql ="SELECT * FROM ypadadm WHERE adname = ? AND adpass = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ADM.class), adname, adpass);
    }

    public ADM getadDaan(String daan) {
        String sql = "SELECT * FROM ypadadm WHERE daan = ?";
        ADM adm = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ADM.class), daan);
        return adm;
    }

    public void uppass(String adpass) {
        String sql = "UPDATE ypadadm SET adpass = ?";
        jdbcTemplate.update(sql, adpass);
    }
}
