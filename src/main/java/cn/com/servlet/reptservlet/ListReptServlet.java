package cn.com.servlet.reptservlet;

import cn.com.domain.Rept;
import cn.com.service.reptservice.ReptService;
import cn.com.service.reptservice.impl.ReptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listReptServlet")
public class ListReptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.调用ReptService的实现类ReptServiceImpl
        ReptService service = new ReptServiceImpl();
        //2.调用service中方法查询返回list(Rept)对象
        List<Rept> Repts = service.findAll();
        //3,.把对象存入requset域中
        request.setAttribute("rept",Repts);
        //4.转发到Reptlist将员工页面展示
        request.getRequestDispatcher(request.getContextPath()+"reptpage/reptlist.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
