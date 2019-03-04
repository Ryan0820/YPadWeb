package cn.com.servlet.empservlet;

import cn.com.service.empservice.EmpService;
import cn.com.service.empservice.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delEmpServlet")
public class DelEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1拿到id
        String id = request.getParameter("empid");

        //2.调用emp服务
        EmpService service = new EmpServiceImpl();

        service.delEmp(id);
        response.sendRedirect(request.getContextPath()+"/listEmpServlet");



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
