package cn.com.servlet.empservlet;

import cn.com.domain.Emp;
import cn.com.service.empservice.EmpService;
import cn.com.service.empservice.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Yan
 */
@WebServlet("/listEmpServlet")
public class ListEmpServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.调用EmpService的实现类EmpServiceImpl
        EmpService es = new EmpServiceImpl();
        //2.调用service中方法查询返回list(emp)对象
        List<Emp> emps = es.findAll();
        //3,.把对象存入requset域中
        req.setAttribute("emps",emps);
        //4.转发到emplist将员工页面展示
        req.getRequestDispatcher(req.getContextPath()+"emppage/emplist.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
