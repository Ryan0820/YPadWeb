package cn.com.service.reptservice.impl;

import cn.com.dao.rept.ReptDao;
import cn.com.dao.rept.impl.ReptDaoImpl;
import cn.com.domain.PageBean;
import cn.com.domain.Rept;
import cn.com.service.reptservice.ReptService;

import java.util.List;

public class ReptServiceImpl implements ReptService {
    private ReptDao dao = new ReptDaoImpl();
    @Override
    public List<Rept> findAll() {
        return dao.findAll();
    }

    @Override
    public Rept updateFindbyid(String reptid) {
        return dao.updateFindbyid(Integer.parseInt(reptid));
    }

    @Override
    public void updatRept(Rept rept) {
        //System.out.println(rept.getReptnumber());
        dao.updatRept(rept);
    }

    @Override
    public void addRept(Rept rept) {
        dao.addRept(rept);
    }

    @Override
    public List<Rept> findbyreptname(String reptname) {
        return dao.findbyreptname(reptname);
    }

    @Override
    public void delRept(String reptid) {
        dao.delRept(reptid);
    }



    @Override
    public PageBean<Rept> getPageBean(String currentPage, String rows) {
        PageBean<Rept> pb = new PageBean<Rept>();
        int newcurrentPage = Integer.parseInt(currentPage);
        int newrows = Integer.parseInt(rows);
        //1获取总记录数
        int totalCount = dao.getTotalCount();
        pb.setTotalCount(totalCount);
        //总页数
        int totalPage = (totalCount % newrows) == 0 ? (totalCount / newrows) : (totalCount / newrows) + 1;
        pb.setTotalPage(totalPage);
        //判断前一页后一页的页码
        if (newcurrentPage <= 0) {
            newcurrentPage = 1;
        }
        if (newcurrentPage >= totalPage) {
            newcurrentPage = totalPage;
        }
        pb.setCurrentPage(newcurrentPage);
        pb.setRows(newrows);
        //*******计算每次开始查询的索引
        int start = ((newcurrentPage - 1) * newrows);
        List<Rept> pageBean = dao.getPageBean(start, newrows);

        pb.setList(pageBean);
        return pb;
    }
}
