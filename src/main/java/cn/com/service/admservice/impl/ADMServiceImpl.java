package cn.com.service.admservice.impl;

import cn.com.dao.admini.ADMDao;
import cn.com.dao.admini.impl.ADMDaoImpl;
import cn.com.domain.ADM;
import cn.com.service.admservice.ADMService;

public class ADMServiceImpl implements ADMService {
    private ADMDao dao =new ADMDaoImpl();
    @Override
    public ADM getAdmin(String adname, String adpass) {
        return dao.getAdmin( adname,  adpass);
    }
}
