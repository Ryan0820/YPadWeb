package cn.com.servlet.reptservlet;

import cn.com.service.reptservice.ReptService;
import cn.com.service.reptservice.impl.ReptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delReptServlet")
public class DelReptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1拿到id
        String reptid = request.getParameter("reptid");
        //2.调用emp服务
        ReptService service = new ReptServiceImpl();
        service.delRept(reptid);
        //response.sendRedirect(request.getContextPath()+"/listReptServlet");
        response.sendRedirect(request.getContextPath()+"/listReptByPageBeanServlet");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
