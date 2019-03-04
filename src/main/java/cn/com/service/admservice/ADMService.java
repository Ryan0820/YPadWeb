package cn.com.service.admservice;

import cn.com.domain.ADM;

public interface ADMService {
    ADM getAdmin(String adname, String adpass);
}
