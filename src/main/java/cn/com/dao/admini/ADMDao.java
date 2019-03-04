package cn.com.dao.admini;

import cn.com.domain.ADM;

public interface ADMDao {
    ADM getAdmin(String adname, String adpass);
}
